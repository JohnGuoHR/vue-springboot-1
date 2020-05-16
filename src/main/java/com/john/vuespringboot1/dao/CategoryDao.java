package com.john.vuespringboot1.dao;

import com.john.vuespringboot1.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
