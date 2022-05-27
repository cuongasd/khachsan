package khachsan.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import khachsan.domain.Booking;
import khachsan.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	public void saveBooking(Booking booking) {
		bookingRepository.save(booking);
	}
	
	public Booking getBookingById(int id) {
		Optional<Booking> rooOptional =bookingRepository.findById(id);
		return rooOptional.get();
	}
	
	public List<Booking> getListAll() {
		return (List<Booking>) bookingRepository.findAll();
	}
	public List<Booking> getListByUser(int idUser){
		List<Booking> list = getListAll();
		List<Booking> list1 = new ArrayList<>();
		for(Booking booking: list) {
			if(booking.getUser().getId()==idUser) {
				list1.add(booking);
			}
		}
		return list1;
	}
}
