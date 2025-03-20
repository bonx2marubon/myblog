package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	HttpSession session;

	@Autowired
	User user;

	// ログイン画面を表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		// セッション情報を全てクリアする
		session.invalidate();
		return "login";
	}

	// ログインを実行
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		// 名前が空の場合やパスワードがからの場合にエラーとする
		if (email == null || password == null) {
			model.addAttribute("message", "メールアドレスとパスワードを入力してください");
			return "login";
		}
	}

}
