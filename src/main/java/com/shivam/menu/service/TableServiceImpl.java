package com.shivam.menu.service;

import com.shivam.menu.dao.TableRepository;
import com.shivam.menu.entity.Food;
import com.shivam.menu.entity.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    public TableRepository tableRepository;

    @Override
    public List<Table> findAll() {
        return tableRepository.findAll();
    }

    @Override
    public Table saveTable(Table table) {
        return tableRepository.save(table);
    }

    @Override
    public Table updateTable(Table table) {
        Optional<Table> existingTable = tableRepository.findById(table.getId());
        if (existingTable.isPresent()) {
            Table tab = existingTable.get();
            List<Food> orders = tab.getOrder();
            if (orders != null) {
                List<Food> newOrders = sort(orders, table.getOrder());
                tab.setOrder(newOrders);
                return tableRepository.save(tab);
            } else {
                tab.setOrder(table.getOrder());
                return tableRepository.save(tab);
            }
        } else {
            return tableRepository.save(table);
        }
    }

    @Override
    public void deleteTable(Table table) throws Exception {
        Optional<Table> temp = tableRepository.findById(table.getId());
        if (temp.isPresent()) {
            tableRepository.delete(temp.get());
            return;
        }
        throw new Exception("Table Not Found Exception");
    }

    @Override
    public void orderCompleted(int id)  throws Exception{

        Optional<Table> temp = tableRepository.findById(id);
        if(temp.isPresent()) {
            Table table = temp.get();
            table.setOrder(null);
            tableRepository.save(table);
            return;
        }
        throw new Exception("Table Not Found Exception");

    }


    public List<Food> sort(List<Food> oldOrders, List<Food> newOrders) {
        List<Food> result = oldOrders;
        for(int i = 0; i < newOrders.size(); i++) {
            boolean flag = true;
            for(int j = 0; j < result.size(); j++) {
                if(result.get(j).getId() == newOrders.get(i).getId() ) {
                    flag = false;
                    result.get(j).setAmount(result.get(j).getAmount() + newOrders.get(i).getAmount());
                    break;
                }

            }
            if(flag) {
                result.add(newOrders.get(i));
            }
        }

        return result;
    }
}