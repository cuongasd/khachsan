package khachsan.controller;

import java.security.PublicKey;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import khachsan.Service.UserService;
import khachsan.domain.User;


@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	private static String messString="";
	@GetMapping("")
	public String loginForm (Model model) {
		UserService.user= new User();
		model.addAttribute("user", new User());
		model.addAttribute("mess",messString ); 
		messString="";
		return "login";
	}
	@PostMapping("")
	public String login(User user) {
		if(userService.login(user) == "admin") {
			return("redirect:/admin");
		}
		if(userService.login(user) == "client") {
			return("redirect:/");
		}	
		messString= "Wrong account password";
		return "redirect:/login";
	}
}
