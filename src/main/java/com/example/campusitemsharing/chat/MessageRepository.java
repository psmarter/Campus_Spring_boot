package com.example.campusitemsharing.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE " +
            "(m.sender.id = :userId1 AND m.receiver.id = :userId2) " +
            "OR (m.sender.id = :userId2 AND m.receiver.id = :userId1) " +
            "ORDER BY m.sentAt ASC")
    List<Message> findChatMessages(@Param("userId1") Long userId1, @Param("userId2") Long userId2);

    /**
     * 查询两个用户之间的最新消息
     */
    @Query(value = "SELECT message_text FROM messages " +
            "WHERE (sender_id = ?1 AND receiver_id = ?2) OR (sender_id = ?2 AND receiver_id = ?1) " +
            "ORDER BY sent_at DESC LIMIT 1", nativeQuery = true)
    String findLastMessage(Long userId1, Long userId2);
}