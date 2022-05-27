package khachsan.controller;

import java.security.PublicKey;

import javax.websocket.server.PathParam;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.sym.Name;

import khachsan.Service.BookingService;
import khachsan.Service.UserService;
import khachsan.Service.ImgRoomService;
import khachsan.Service.RoomService;

import khachsan.domain.Booking;
import khachsan.domain.User;
import net.bytebuddy.asm.Advice.This;

@Controller
public class BookingController {
	
	@Autowired
	private RoomService roomService;
	@Autowired
	private ImgRoomService imgRoomService;
	@Autowired
	private BookingService bookingService;
	private static int room_id;
	private static Booking booking;
	@GetMapping("/booking")
	public String BookingForm(Model model) {
		model.addAttribute("inOut",UserService.inOut(UserService.user));
		model.addAttribute("listRoom",roomService.getListAll());
		return "booking";
	}
	@GetMapping("/bookroom")
	public String bookRoom(@PathParam ("id") Integer id,Model model)
	{
		room_id=id;
		model.addAttribute("id", id);
		model.addAttribute("listImg",imgRoomService.getListById(id));
		System.out.println(imgRoomService.getListById(id).size());
		model.addAttribute("booking",new Booking());
		return "bookRoom";
	}
	@PostMapping("/bookroom")
	public String bookRoom(Booking booking)
	{
		booking.setRoom(roomService.getRoomById(room_id));
		booking.setUser(UserService.user);
		this.booking = booking;
		return "redirect:/bill";
	}
	@GetMapping("/bill")
	public String billForm(Model model) {
		model.addAttribute("booking",this.booking);
		return "bill";
	}
	
	@PostMapping("/bill")
	public String bill() {
		bookingService.saveBooking(this.booking);
		return "redirect:/booking";
	}
	
}
