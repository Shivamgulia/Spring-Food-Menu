package com.shivam.menu.controller;

import com.shivam.menu.entity.Food;
import com.shivam.menu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class FoodController {

    @Autowired
    public FoodService foodService;

    @GetMapping("/foods")
    public List<Food> findAll() {
        return foodService.findAll();
    }

    @PostMapping("/foods")
    public Food saveFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    @GetMapping("/foods/{id}")
    public Food findById(@PathVariable int id) throws Exception {
        return foodService.findById(id);
    }

    @DeleteMapping("/foods")
    public void deleteFood(Food food) throws Exception {
        foodService.deleteFood(food);
    }
}
