package khachsan.controller;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import khachsan.Service.UserService;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("inOut",UserService.inOut(UserService.user));
		return "home";
	}
	@GetMapping("/admin")
	public String homeAdmin(Model model) {
		model.addAttribute("inOut",UserService.inOut(UserService.user));
		return "update";
	}
}
