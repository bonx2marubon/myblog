package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	// emailとpasswordの情報でUsersテーブルのnameをもってくる
	User findByEmailAndPassword(String email, String password);

}