package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blogs")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "user_id")
	private Integer userId;
	private String title;
	private String body;

	// コンストラクタ
	public Blog() {
	}

	public Blog(Integer categoryId, String title, String body) {
		this.categoryId = categoryId;
		this.title = title;
		this.body = body;
	}

	// ゲッター
	public Integer getId() {
		return id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
