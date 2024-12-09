package com.example.guacnroll.service;

import com.example.guacnroll.model.*;
import com.example.guacnroll.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuCategoryRepository categoryRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<MenuCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }
}