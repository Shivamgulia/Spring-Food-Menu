package com.shivam.menu.service;

import com.shivam.menu.dao.TableRepository;
import com.shivam.menu.entity.Food;
import com.shivam.menu.entity.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService{

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
    public Table updateTable(Table table) throws Exception {
        Optional<Table> existingTable = tableRepository.findById(table.getId());
        if (existingTable.isPresent()) {
            Table tab = existingTable.get();
            List<Food> orders = tab.getOrder();
            if(orders != null) {
                int n = table.getOrder().size();
                for (int i = 0; i < n; i++) {
                    orders.add(table.getOrder().get(i));
                }
                tab.setOrder(orders);
                return tableRepository.save(tab);
            }
            else {
                tab.setOrder(table.getOrder());
                return tableRepository.save(tab);
            }
        }
        throw new Exception("Table not Found Exception") ;
    }

    @Override
    public void deleteTable(Table table) throws Exception {
        Optional<Table> temp = tableRepository.findById(table.getId());
        if(temp.isPresent()) {
            tableRepository.delete(temp.get());
            return ;
        }
        throw new Exception("Table Not Found Exception");
    }
}
