package com.shivam.menu.service;

import com.shivam.menu.entity.Food;

import java.util.List;

public interface FoodService {

    public List<Food> findAll();

    public Food saveFood(Food food);

    public Food findById(int id) throws Exception;

    public void deleteFood(Food foof) throws Exception;

}
