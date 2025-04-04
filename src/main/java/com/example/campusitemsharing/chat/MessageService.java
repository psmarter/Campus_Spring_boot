package com.example.campusitemsharing.chat;

import com.example.campusitemsharing.ResponseModel;
import com.example.campusitemsharing.User;
import com.example.campusitemsharing.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 发送消息：根据 senderId 和 receiverId 查找用户，创建消息并保存
     */
    public ResponseModel sendMessage(String senderAccount, String receiverAccount, String messageText) {
        ResponseModel response = new ResponseModel();
        User sender = userRepository.findByAccount(senderAccount);
        if (sender == null) {
            response.setStatus("error");
            response.setMessage("发送者不存在");
            return response;
        }
        User receiver = userRepository.findByAccount(receiverAccount);
        if (receiver == null) {
            response.setStatus("error");
            response.setMessage("接收者不存在");
            return response;
        }

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setMessageText(messageText);
        messageRepository.save(message);

        response.setStatus("success");
        response.setMessage("消息发送成功");
        response.setData(message);
        return response;
    }

    /**
     * 查询两个用户间的聊天记录
     */
    public ResponseModel getChatHistory(String account1, String account2) {
            ResponseModel response = new ResponseModel();
        User user1 = userRepository.findByAccount(account1);
        User user2 = userRepository.findByAccount(account2);
        if (user1 == null || user2 == null) {
            response.setStatus("error");
            response.setMessage("用户不存在");
            return response;
        }

        List<Message> messages = messageRepository.findChatMessages(user1.getId(), user2.getId());
        response.setStatus("success");
        response.setMessage("聊天记录获取成功");
        response.setData(messages);
        return response;
    }
}