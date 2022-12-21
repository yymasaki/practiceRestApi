package com.example.practiceRestApi.controller;

import com.example.practiceRestApi.exception.ItemNotFoundException;
import com.example.practiceRestApi.model.Item;
import com.example.practiceRestApi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    @PostMapping("/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @PutMapping("/items/{itemId}")
    public void updateItem(@RequestBody Item item, @PathVariable("itemId") Long itemId) {
        itemService.updateItem(itemId, item);
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
    }
}
