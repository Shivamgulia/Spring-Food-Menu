package com.shivam.menu.dao;

import com.shivam.menu.entity.Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends MongoRepository<Table, Integer> {
}
