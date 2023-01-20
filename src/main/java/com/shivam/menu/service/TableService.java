package com.shivam.menu.service;

import com.shivam.menu.entity.Table;

import java.util.List;

public interface TableService {

    public List<Table> findAll();

    public Table saveTable(Table table);

    public Table updateTable(Table table);

    public void deleteTable(Table table) throws Exception;
}
