package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	// SLECT * FROM blogs WHERE category_id = ?
	List<Blog> findByCategoryId(Integer categoryId);

}
