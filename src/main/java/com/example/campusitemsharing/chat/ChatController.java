package com.example.campusitemsharing.chat;


import com.example.campusitemsharing.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatController {

    @Autowired
    private MessageService messageService;

    /**
     * 发送消息接口
     * 请求参数：senderId, receiverId, messageText
     */
    @PostMapping("/send")
    public ResponseModel sendMessage(@RequestParam String senderAccount,
                                     @RequestParam String receiverAccount,
                                     @RequestParam String messageText) {
        return messageService.sendMessage(senderAccount, receiverAccount, messageText);
    }

    /**
     * 获取聊天记录接口
     * 请求参数：userId1, userId2
     */
    @GetMapping("/history")
    public ResponseModel getChatHistory(@RequestParam String account1,
                                        @RequestParam String account2) {
        return messageService.getChatHistory(account1, account2);
    }
}