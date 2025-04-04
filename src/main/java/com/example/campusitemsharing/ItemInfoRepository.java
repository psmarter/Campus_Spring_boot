package com.example.campusitemsharing;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemInfoRepository extends JpaRepository<ItemInfo, Long> {
    ItemInfo findByImageUniqueId(String imageUniqueId); // 根据图片唯一ID查找

    List<ItemInfo> findByAccountName(String accountName); // 根据账户名查找
}