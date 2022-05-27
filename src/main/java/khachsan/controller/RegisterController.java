package khachsan.controller;

import javax.swing.Spring;

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
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UserService clientService;
	private static String messString="";
	@GetMapping("")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("mess", messString);
		messString="";
		return "register";
	}
	@PostMapping("")
	public String register(User user,Model model) {
		user.setRoles("client");
		clientService.saveUser(user);
		messString="Register successfully";
		return "redirect:/login";
	}
}
