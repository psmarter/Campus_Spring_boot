package com.example.campusitemsharing.chat;

import com.example.campusitemsharing.ResponseModel;
import com.example.campusitemsharing.User;
import com.example.campusitemsharing.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FriendService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    /**
     * 添加好友，无需验证直接创建记录
     */
    public ResponseModel addFriend(String account, String friendAccount) {
        ResponseModel response = new ResponseModel();

        // 根据账户名查找用户
        User user = userRepository.findByAccount(account);
        if (user == null) {
            response.setStatus("error");
            response.setMessage("当前用户不存在");
            return response;
        }
        User friend = userRepository.findByAccount(friendAccount);
        if (friend == null) {
            response.setStatus("error");
            response.setMessage("目标好友不存在");
            return response;
        }

        // 构造复合主键，内部会自动保证较小的 id 在前
        FriendshipId friendshipId = new FriendshipId(user.getId(), friend.getId());
        if (friendshipRepository.existsById(friendshipId)) {
            response.setStatus("error");
            response.setMessage("好友关系已存在");
            return response;
        }

        Friendship friendship = new Friendship(user.getId(), friend.getId());
        friendshipRepository.save(friendship);
        response.setStatus("success");
        response.setMessage("好友添加成功");
        response.setData(friendship); // 若需要返回数据，可设置 data 字段
        return response;
    }


    /**
     * 获取指定用户的所有好友关系
     */
    public ResponseModel getFriends(String account) {
        ResponseModel response = new ResponseModel();

        // 根据账户名查找当前用户
        User user = userRepository.findByAccount(account);
        if (user == null) {
            response.setStatus("error");
            response.setMessage("用户不存在");
            return response;
        }

        // 查询当前用户参与的所有好友关系
        List<Friendship> friendships = friendshipRepository.findByIdUser1IdOrIdUser2Id(user.getId(), user.getId());
        List<FriendDTO> friendDTOList = new ArrayList<>();

        // 遍历好友关系，提取好友账户名
        for (Friendship fs : friendships) {
            Long friendId;
            // 判断哪个是当前用户，另一个即为好友
            if (fs.getId().getUser1Id().equals(user.getId())) {
                friendId = fs.getId().getUser2Id();
            } else {
                friendId = fs.getId().getUser1Id();
            }

            Optional<User> friendOpt = userRepository.findById(friendId);
            if (friendOpt.isPresent()) {
                User friendUser = friendOpt.get();

                // 查询最后一条消息
                String lastMessage = messageRepository.findLastMessage(user.getId(), friendId);
                if (lastMessage == null) {
                    lastMessage = ""; // 没有消息时返回空字符串
                }

                FriendDTO dto = new FriendDTO(friendUser.getAccount(), lastMessage);
                friendDTOList.add(dto);
            }
        }

        response.setStatus("success");
        response.setMessage("好友列表获取成功");
        response.setData(friendDTOList);
        return response;
    }
}