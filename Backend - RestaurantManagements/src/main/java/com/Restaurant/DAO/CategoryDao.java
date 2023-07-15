package com.Restaurant.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant.POJO.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	
	List<Category> getAllCategory();
}
