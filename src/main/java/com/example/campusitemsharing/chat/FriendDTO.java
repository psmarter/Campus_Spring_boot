package com.example.campusitemsharing.chat;

public class FriendDTO {
    private String account;     // 好友账户名
    private String lastMessage; // 最近一条消息（暂时为空，可后续完善）

    public FriendDTO() {
    }

    public FriendDTO(String account, String lastMessage) {
        this.account = account;
        this.lastMessage = lastMessage;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}

