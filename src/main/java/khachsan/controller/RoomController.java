package khachsan.controller;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import khachsan.Service.UserService;
import khachsan.Service.RoomService;

@Controller
public class RoomController {
	@Autowired
	private RoomService roomService;
	@GetMapping("/rooms")
	public String RoomsForm(Model model) {
		model.addAttribute("inOut",UserService.inOut(UserService.user));
		model.addAttribute("listRoom",roomService.getListAll());
		model.addAttribute("listType",roomService.getType());
		return "rooms";
	}
	@PostMapping("/rooms")
	public  String RoomsView(String type) {
		return "redirect:/rooms";
	}
}
