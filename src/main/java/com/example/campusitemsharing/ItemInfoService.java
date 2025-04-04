package com.example.campusitemsharing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemInfoService {

    @Autowired
    private ItemInfoRepository itemInfoRepository;

    // 添加物品
    public ResponseModel addItem(ItemInfo itemInfo) {
        ResponseModel response = new ResponseModel();

        // 生成 uniqueId，形如 "username1", "username2" ...
        String accountName = itemInfo.getAccountName(); // 获取用户名

        if (accountName == null || accountName.isEmpty()) {
            response.setStatus("error");
            response.setMessage("Account name cannot be null or empty");
            return response;
        }

        String newImageUniqueId = generateImageUniqueId(accountName);

        // 检查生成的 ID 是否唯一
        if (itemInfoRepository.findByImageUniqueId(newImageUniqueId) != null) {
            response.setStatus("error");
            response.setMessage("Item with this image unique ID already exists");
            return response;
        }

        itemInfo.setImageUniqueId(newImageUniqueId); // 设置生成的唯一图片ID



        byte[] imageDataBytes = itemInfo.getImageData();
        itemInfo.setImageData(imageDataBytes);

        // 保存物品信息
        itemInfoRepository.save(itemInfo);
        response.setStatus("success");
        response.setMessage("Item added successfully with ID: " + newImageUniqueId);
        return response;
    }


    public List<ItemDetails> getAllItems() {
        List<ItemInfo> items = itemInfoRepository.findAll();

        return items.stream()
                .sorted(Comparator.comparing(ItemInfo::getCreatedAt).reversed())
                .map(item -> new ItemDetails(
                        item.getAccountName(),
                        item.getItemType(),
                        item.getPrice().doubleValue(),
                        item.getContactName(),
                        item.getContactNumber(),
                        item.getTags(),
                        Base64.getEncoder().encodeToString(item.getImageData()),
                        item.getImageUniqueId(),
                        item.getDescription()
                ))
                .collect(Collectors.toList());
    }

    // 生成新的 uniqueId
    private String generateImageUniqueId(String accountName) {
        // 获取当前用户的所有物品并计算数量
        long itemCount = itemInfoRepository.findByAccountName(accountName).size();
        // 生成新的 uniqueId
        return accountName + (itemCount + 1); // 为现有物品计数，生成新的 ID
    }

}