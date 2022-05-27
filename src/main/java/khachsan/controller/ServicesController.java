package khachsan.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import khachsan.Service.ServicesService;
import khachsan.Service.UserService;
import khachsan.domain.Booking;

@Controller
public class ServicesController {

	@Autowired
	private ServicesService servicesService;
	private int serviceId;
	
	@GetMapping("/services")
	public String BookingForm(Model model) {
		model.addAttribute("inOut",UserService.inOut(UserService.user));
		model.addAttribute("listServices",servicesService.getListAll());
		return "services";
	}
	
//	@GetMapping("/Services")
//	public String choooseService(@PathParam ("id") Integer id,Model model)
//	{
//		serviceId = id;
//		model.addAttribute("id", id);
//		model.addAttribute("listImg",imgRoomService.getListById(id));
//		model.addAttribute("booking",new Booking());
//		return "bookRoom";
//	}
}
