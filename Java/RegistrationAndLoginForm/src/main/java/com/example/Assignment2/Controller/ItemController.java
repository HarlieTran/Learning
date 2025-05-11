package com.example.Assignment2.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Assignment2.Model.Item;
import com.example.Assignment2.Service.ItemService;

@Controller
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String showItems(Model model) {
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/item")
    public String showItemDetails(@RequestParam String name, Model model) {
        List<Item> items = itemService.getItems();
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                model.addAttribute("item", item);
                return "/item-details";
            }
        }

        model.addAttribute("error", "Item not found!");
        return "items";
    }
}
