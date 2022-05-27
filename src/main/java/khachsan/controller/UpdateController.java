package khachsan.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.sym.Name;

import khachsan.Service.*;
import khachsan.domain.*;
import khachsan.repository.*;


@Controller
//@RequestMapping("/update")
public class UpdateController {
	@Autowired
	private  BookingService bookingService;
	
	@Autowired
	private ImgRoomService imgRoomService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	public static int bookingid;
	public static int roomid;
	public static int userid;
	@GetMapping("/listbooking")
	public String ListBooking(Model model) {
		model.addAttribute("listBooking",bookingService.getListAll());
		return "bookingupdate";
	}
	@GetMapping("/bookingupdate")
	public String BookingUpdateForm(@PathParam("id") Integer id,Model model) {
		bookingid=id;
		model.addAttribute("booking",bookingService.getBookingById(id));
		return "BookingUpdateForm";
	}
	@PostMapping("/bookingupdate")
	public String BookingUpdate(Booking booking) {
		booking.setId(bookingid);
		bookingService.saveBooking(booking);
		return "redirect:/listbooking";
	}
	
	@GetMapping("/listroom")
	public String ListRoom(Model model) {
		model.addAttribute("listroom",roomService.getListAll());
		return "roomupdate";
	}
	@GetMapping("/roomupdate")
	public String RoomUpdateForm(@PathParam("id") Integer id,Model model) {
		roomid=id;
		model.addAttribute("room",roomService.getRoomById(id));
		return "RoomUpdateForm";
	}
	@PostMapping("/roomupdate")
	public String RoomUpdate(Room room) {
		room.setId(roomid);
		roomService.saveRoom(room);
		return "redirect:/listroom";
	}
	@GetMapping("/listuser")
	public String ListUser(Model model) {
		model.addAttribute("listuser",userService.getListAll());
		return "userupdate";
	}
	@GetMapping("/userupdate")
	public String UserUpdateForm(@PathParam("id") Integer id,Model model) {
		userid=id;
		model.addAttribute("user",userService.getUserById(id));
		return "UserUpdateForm";
	}
	@PostMapping("/userupdate")
	public String UserUpdate(User user) {
		user.setId(userid);
		userService.saveUser(user);
		return "redirect:/listuser";
	}
	
	
}
