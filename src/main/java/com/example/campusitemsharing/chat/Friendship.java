package com.example.campusitemsharing.chat;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@Entity
@Table(name = "friendships")
public class Friendship {

    @EmbeddedId
    private FriendshipId id;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    public Friendship() {
    }

    // 构造函数：传入两个用户的 id，内部保证较小的 id 在前
    public Friendship(Long userId, Long friendId) {
        this.id = new FriendshipId(userId, friendId);
    }

    // Getters 和 Setters
    public FriendshipId getId() {
        return id;
    }

    public void setId(FriendshipId id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}