package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;
import com.example.demo.model.Account;
import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.CategoryRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {

	@Autowired
	Account account;

	@Autowired
	HttpSession session;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	BlogRepository blogRepository;

	// 記事一覧表示
	@GetMapping("/blogs") // URL
	public String index(
			@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
			Model model, HttpSession session) {
		Account loginUser = (Account) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "redirect:/login";
		}
		model.addAttribute("userName", loginUser.getName());

		// 全カテゴリー一覧を取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		// 記事一覧情報の取得
		List<Blog> blogList = null;
		if (categoryId == null) {
			blogList = blogRepository.findAll();
		} else {
			// blogsテーブルをカテゴリーIDを指定して一覧を取得
			blogList = blogRepository.findByCategoryId(categoryId);
		}

		model.addAttribute("blogs", blogList);
		return "blogs";
	}

	// 新規記事作成画面を表示
	@GetMapping("/blogs/new") //URL
	public String postArticle() {
		return "addArticle"; // HTML
	}

	// 新規記事作成の実行
	@PostMapping("/blogs/add")
	public String add(
			@RequestParam("categoryId") Integer categoryId,
			@RequestParam("title") String title,
			@RequestParam("body") String body) {
		List<Blog> allBlog = blogList.getBlog();

	}

	// 記事更新用の記述
	// 記事更新の実行

	// 記事削除用の記述
	// 記事削除の実行

}
