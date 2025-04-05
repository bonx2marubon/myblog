package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	// ログイン画面を表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		// セッション情報を全てクリアする
		session.invalidate();
		// エラーパラメータのチェック
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "メールアドレスとパスワードを入力してください");
		}
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
		}
		return "login";
	}

	// 新規登録画面を表示
	@GetMapping("/new")
	public String signup(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		// セッション情報を全てクリアする
		session.invalidate();
		// エラーパラメータのチェック
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "全ての項目を入力してください");
		}
		return "signup";
	}

	// 新規登録の実行
	@PostMapping("/new")
	public String create(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		// パラメータが空文字の場合はエラーメッセージを出力
		if (name == null || name.length() == 0 || email == null || email.length() == 0 || password == null
				|| password.length() == 0) {
			model.addAttribute("message", "名前、メールアドレスとパスワードを入力してください");
		}
		return "signup";
	}
}
