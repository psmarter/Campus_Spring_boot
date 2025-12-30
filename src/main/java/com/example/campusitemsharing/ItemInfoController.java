package com.example.campusitemsharing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物品信息控制器类 / Item Information Controller Class
 * 
 * 处理物品相关的 HTTP 请求，包括添加物品和获取所有物品。
 * Handles item-related HTTP requests including adding items and retrieving all items.
 * 
 * 基础路径：/api/items
 * Base path: /api/items
 * 
 * @author psmarter
 * @version 1.0
 * @since 2025-12-30
 */
@RestController
@RequestMapping("/api/items")
public class ItemInfoController {

    @Autowired
    private ItemInfoService itemInfoService;

    /**
     * 添加物品端点 / Add item endpoint
     * 
     * 接收物品信息并添加到平台。
     * Receives item information and adds it to the platform.
     * 
     * @param itemInfo 物品信息对象 / Item information object
     * @return 响应实体，包含响应模型和HTTP状态码 / Response entity containing response model and HTTP status code
     */
    @PostMapping("/add")  // 增加物品 / Add item
    public ResponseEntity<ResponseModel> addItem(@RequestBody ItemInfo itemInfo) {
        ResponseModel response = itemInfoService.addItem(itemInfo);
        return ResponseEntity.status(response.getStatus().equals("success") ? 201 : 400).body(response);
    }

    /**
     * 获取所有物品端点 / Get all items endpoint
     * 
     * 返回平台上所有共享物品的详细信息列表。
     * Returns a list of detailed information for all shared items on the platform.
     * 
     * @return 响应实体，包含物品详情列表 / Response entity containing list of item details
     */
    @GetMapping("/all")  // 获取所有物品 / Get all items
    public ResponseEntity<List<ItemDetails>> getAllItems() {
        List<ItemDetails> items = itemInfoService.getAllItems(); // 获取 ItemDetails 列表 / Get ItemDetails list
        return ResponseEntity.ok(items);
    }

}