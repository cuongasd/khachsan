package khachsan.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import khachsan.domain.Room;
import khachsan.repository.RoomRepository;
import net.bytebuddy.description.method.ParameterDescription.Token.TypeList;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	public List<Room> getListAll() {
		return (List<Room>) roomRepository.findAll();
	}	
	
	public Room getRoomById(int id) {
		Optional<Room> rooOptional =roomRepository.findById(id);
		return rooOptional.get();
	}
	public List<String> getType(){
		return Arrays.asList("All","Single", "Double", "VIP");
	}
	
	public List<Room> getListAllById(Iterable<Integer> id){
		return (List<Room>) roomRepository.findAllById(id);
	}
	public void saveRoom(Room room) {
		roomRepository.save(room);
	}
	

}
