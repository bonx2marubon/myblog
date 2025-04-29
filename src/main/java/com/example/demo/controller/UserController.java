package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	Account account;

	@Autowired
	HttpSession session;

	@Autowired
	UserRepository userRepository;

	// Entityは書かなくていい！！！

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
			Model model,
			HttpSession session) {

		// 入力チェック
		if (email.isEmpty() || password.isEmpty()) {
			model.addAttribute("message", "メールアドレスとパスワードを入力してください");
			return "login";
		}

		// ユーザーをメールアドレスとパスワードで検索（1件のみ返す）
		User user = userRepository.findByEmailAndPassword(email, password);

		if (user == null) {
			model.addAttribute("message", "アカウントがみつかりません");
			return "login";
		}

		Account account = new Account(user.getId(), user.getName());

		session.setAttribute("loginUser", account);

		// エラーがなければ通常通りブログ一覧へ
		return "redirect:/blogs";
	}

	// 新規登録画面を表示
	@GetMapping("/users/new")
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
	@PostMapping("/users/add")
	public String add(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword,
			Model model) {

		// パラメータが空文字の場合はエラーメッセージを出力
		if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			model.addAttribute("message", "全ての項目を入力してください");
			return "signup";
		}

		// パスワードとパスワード（確認）が一致しない場合はエラーメッセージを出力
		if (!password.equals(confirmPassword)) {
			model.addAttribute("message", "パスワードが一致しません");
			return "signup";
		}
		User user = new User(name, email, password);

		userRepository.save(user);
		// 上記2つの条件を満たしている場合はログイン画面に遷移
		return "redirect:/login";
	}
}
