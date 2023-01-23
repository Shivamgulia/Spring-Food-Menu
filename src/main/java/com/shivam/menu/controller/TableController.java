package com.shivam.menu.controller;

import com.shivam.menu.entity.Table;
import com.shivam.menu.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class TableController {

    @Autowired
    public TableService tableService;

    @GetMapping("/tables")
    public List<Table> findAll() {
        return tableService.findAll();
    }

    @PostMapping("/tables")
    public Table saveTable(@RequestBody Table table) {
        return tableService.saveTable(table);
    }

    @PatchMapping("/tables")
    public Table updateTable(@RequestBody Table table)  {
        return tableService.updateTable(table);
    }

    @DeleteMapping("/tables")
    public void DeleteTable(Table table) throws Exception {
         tableService.deleteTable(table);
    }

    @PostMapping("/tables/{id}")
    public void orderCompleted(@PathVariable int id) throws Exception {
        tableService.orderCompleted(id);
    }

}
