package com.example.guacnroll.controller;

import com.example.guacnroll.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public String showMenu(Model model) {
        model.addAttribute("categories", menuService.getAllCategories());
        model.addAttribute("foodItems", menuService.getAllFoodItems());
        return "menu";
    }
}