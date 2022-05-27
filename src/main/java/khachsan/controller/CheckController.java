package khachsan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import khachsan.Service.BookingService;
import khachsan.Service.UserService;

@Controller
public class CheckController {
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/check")
	public String check(Model model) {
		model.addAttribute("listBooking",bookingService.getListByUser(UserService.user.getId()));
		return "check";
	}

}
