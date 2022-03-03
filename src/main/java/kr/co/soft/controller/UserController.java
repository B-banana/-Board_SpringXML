package kr.co.soft.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.soft.beans.UserBean;
import kr.co.soft.validator.UserValidator;

@RequestMapping("/user")
@Controller
public class UserController {

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {

		return "user/join";
	}

	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {

		if (result.hasErrors()) { // 유효성 검사를 통하가지 못하게 된다면
			return "user/join";
		}
		return "user/join_success";
	}

	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}

	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}

}
