package khachsan.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import khachsan.domain.ImgRoom;
import khachsan.domain.Room;
import khachsan.repository.ImgRoomRepository;
@Service
public class ImgRoomService {
	@Autowired
	private ImgRoomRepository imgRoomRepository;
	
	public List<ImgRoom> getListAll() {
		return (List<ImgRoom>) imgRoomRepository.findAll();
	}
	public List<ImgRoom> getListById(int roomId){
		List<ImgRoom> list = new ArrayList();
		List<ImgRoom> list1 = new ArrayList();
		list= getListAll();
		ImgRoomService imgRoomService = new ImgRoomService();
		System.out.println(list.size());
		
		for (ImgRoom imgRoom : list) {
			if(imgRoom.getRoom().getId()==roomId) {
				list1.add(imgRoom);
			}
		}
		return list1;
	}
	
}
