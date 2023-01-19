package com.shivam.menu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Table {

    @Id
    private int id;

    private List<Food> order;

    public Table(int id, List<Food> order) {
        this.id = id;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Food> getOrder() {
        return order;
    }

    public void setOrder(List<Food> order) {
        this.order = order;
    }
}
