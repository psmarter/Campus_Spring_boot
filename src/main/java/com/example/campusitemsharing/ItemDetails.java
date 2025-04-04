package com.example.campusitemsharing;


import java.time.LocalDateTime;

public class ItemDetails {

    private String accountName;         // 用户名
    private String itemType;            // 物品类型
    private double price;                // 价格
    private String contactName;          // 联系人姓名
    private String contactNumber;        // 联系人号码
    private String tags;                 // 标签
    private String imageData;            // Base64 编码图像数据
    private String imageUniqueId;        // 物品唯一ID
    private String description;          // 描述

    public ItemDetails() {
    }

    // 构造函数
    public ItemDetails(String accountName, String itemType, double price,
                       String contactName, String contactNumber, String tags,
                       String imageData, String imageUniqueId,
                       String description) {
        this.accountName = accountName;
        this.itemType = itemType;
        this.price = price;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.tags = tags;
        this.imageData = imageData;
        this.imageUniqueId = imageUniqueId;
        this.description = description;
    }

    // Getter 和 Setter 方法
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getImageUniqueId() {
        return imageUniqueId;
    }

    public void setImageUniqueId(String imageUniqueId) {
        this.imageUniqueId = imageUniqueId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}