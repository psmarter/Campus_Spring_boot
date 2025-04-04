package com.example.campusitemsharing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemInfoController {

    @Autowired
    private ItemInfoService itemInfoService;

    // 增加物品
    @PostMapping("/add")
    public ResponseEntity<ResponseModel> addItem(@RequestBody ItemInfo itemInfo) {
        ResponseModel response = itemInfoService.addItem(itemInfo);
        return ResponseEntity.status(response.getStatus().equals("success") ? 201 : 400).body(response);
    }

    // 获取所有物品
    @GetMapping("/all")
    public ResponseEntity<List<ItemDetails>> getAllItems() {
        List<ItemDetails> items = itemInfoService.getAllItems(); // 获取 ItemDetails 列表
        return ResponseEntity.ok(items);
    }

}