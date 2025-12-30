package com.example.campusitemsharing;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 物品信息实体类 / Item Information Entity Class
 * 
 * 表示共享物品的详细信息，映射到数据库的 item_info 表。
 * Represents detailed information about shared items, mapped to the 'item_info' table in the database.
 * 
 * 包含物品的名称、类型、价格、联系方式、图片等完整信息。
 * Contains complete information such as item name, type, price, contact details, and images.
 * 
 * @author psmarter
 * @version 1.0
 * @since 2025-12-30
 */
@Entity
@Table(name = "item_info")
public class ItemInfo {
    /**
     * 物品唯一标识符（主键）/ Item unique identifier (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 发布者账号名称（不能为空）/ Publisher account name (not null)
     */
    @Column(name = "account_name", nullable = false)
    private String accountName;

    /**
     * 图片唯一标识符（唯一且不能为空）/ Image unique identifier (unique and not null)
     */
    @Column(name = "image_unique_id", nullable = false, unique = true)
    private String imageUniqueId;

    /**
     * 物品类型（不能为空）/ Item type (not null)
     * 例如：书籍、电子产品、运动器材等
     * Examples: Books, Electronics, Sports Equipment, etc.
     */
    @Column(name = "item_type", nullable = false)
    private String itemType;

    /**
     * 物品价格（不能为空）/ Item price (not null)
     */
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    /**
     * 联系人姓名（不能为空）/ Contact person name (not null)
     */
    @Column(name = "contact_name", nullable = false)
    private String contactName;

    /**
     * 联系电话（不能为空）/ Contact phone number (not null)
     */
    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    /**
     * 物品标签（可选）/ Item tags (optional)
     * 用于分类和搜索，多个标签用逗号分隔
     * Used for categorization and search, multiple tags separated by commas
     */
    @Column(name = "tags")
    private String tags;

    /**
     * 物品图片数据（大对象，不能为空）/ Item image data (large object, not null)
     * 以字节数组形式存储图片二进制数据
     * Stores image binary data as byte array
     */
    @Lob
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    /**
     * 物品描述（可选）/ Item description (optional)
     */
    @Column(name = "description")
    private String description;

    /**
     * 物品创建时间（不可更新）/ Item creation time (not updatable)
     */
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // ==================== Getters and Setters / 获取器和设置器 ====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getImageUniqueId() {
        return imageUniqueId;
    }

    public void setImageUniqueId(String imageUniqueId) {
        this.imageUniqueId = imageUniqueId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}