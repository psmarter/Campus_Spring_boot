package com.example.campusitemsharing.chat;

import com.example.campusitemsharing.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friends")
public class FriendController {

    @Autowired
    private FriendService friendService;

    /**
     * 添加好友接口
     * 请求示例：POST /api/friends/add?userId=1&friendId=2
     */
    @PostMapping("/add")
    public ResponseModel addFriend(@RequestParam String account,
                                   @RequestParam String friendAccount) {
        return friendService.addFriend(account, friendAccount);
    }

    /**
     * 获取指定用户的所有好友接口
     * 请求示例：GET /api/friends/list?userId=1
     */
    @GetMapping("/list")
    public ResponseModel getFriends(@RequestParam String account) {
        return friendService.getFriends(account);
    }
}