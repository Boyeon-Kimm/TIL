package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.board.model.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인
	//로그아웃
	//유저등록
	
	
	
	
	@GetMapping("users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/userList";
	}
}
