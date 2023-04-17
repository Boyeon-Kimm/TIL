package com.ssafy.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// regist라고 하는 요청이 들어오면 regist.jsp로 보내면 좋겠어
	// 그런데 요청이 a태그를 이용해서 날아왔어...
	@GetMapping("regist")
	public String regist() {
		// 로그인 유무를 파악해서...
		// 로그인을 했으면 계속 고
		// 로그인 안했으면 다시 메인으로 돌아가...
		return "regist";
	}
	
	@GetMapping("login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(HttpSession session, String id, String pw) {
		
		// id와 pw를 이용해서 실제 로그인을 해야겠지요
		// Service를 만들어서 Dao DB
		if(id.equals("ssafy") && pw.contentEquals("1234")) {
			session.setAttribute("id", "ssafy");
			return "redirect:/";
		}
		
		// 아니라면 로그인페이지로 다시 가라. 실패했으니까
		return "redirect:/login";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
	
}
