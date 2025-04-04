package com.example.campusitemsharing.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, FriendshipId> {
    // 根据某个用户查询他参与的好友关系
    List<Friendship> findByIdUser1IdOrIdUser2Id(Long userId1, Long userId2);
}
