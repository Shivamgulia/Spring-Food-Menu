package com.shivam.menu.service;

import com.shivam.menu.dao.FoodRepository;
import com.shivam.menu.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodClassImpl implements FoodService {

    @Autowired
    public FoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food findById(int id) throws Exception {
        Optional<Food> temp = foodRepository.findById(id);
        if(temp.isPresent()) {
            return temp.get();
        }
        throw new Exception("Food Item Not FOund Exception");
    }

    @Override
    public void deleteFood(Food food) throws Exception {
        Optional<Food> temp = foodRepository.findById(food.getId());
        if(temp.isPresent()) {
            foodRepository.delete(temp.get());
        }
        throw new Exception("Food Item not Found Exception");
    }
}
