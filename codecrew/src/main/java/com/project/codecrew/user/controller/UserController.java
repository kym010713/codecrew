package com.project.codecrew.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.codecrew.user.dto.UserDto;
import com.project.codecrew.user.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/signup")
	public String showSignupForm() {
	    return "/user/signup";  // templates/signup.html 렌더링
	}
	
	//회원가입 처리 
	@PostMapping("/signup")
	public String registerUser(@ModelAttribute UserDto userDto,
	                           RedirectAttributes redirectAttributes) {
	    // 아이디 중복 체크
	    if (userService.existsByUserid(userDto.getId())) {
	        redirectAttributes.addFlashAttribute("errorMessage", "사용중인 아이디 입니다.");
	        return "redirect:/signup";
	    }
 
	    // 이메일 중복 체크
	    if (userService.existsByEmail(userDto.getEmail())) {
	        redirectAttributes.addFlashAttribute("errorMessage", "사용중인 이메일 입니다.");
	        return "redirect:/signup";
	    }

	    try {
	        userService.registerUser(userDto);
	        redirectAttributes.addFlashAttribute("message", "회원가입 성공!");
	        return "redirect:/login";
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "회원가입 중 오류가 발생했습니다.");
	        return "redirect:/signup";
	    }
	}

	
	
	
}
