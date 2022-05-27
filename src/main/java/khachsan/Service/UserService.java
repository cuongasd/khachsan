package khachsan.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import khachsan.domain.User;
import khachsan.exception.EmailException;
import khachsan.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public static User user = new User();

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	public List<User> getListAll() {
		return (List<User>) userRepository.findAll();
	}

	public String login(User user) {
		List<User> list = getListAll();
		for (User u : list) {
			if (user.getEmail().equals(u.getEmail()) && user.getPassWord().equals(u.getPassWord())) {
				UserService.user = u;
				if(u.getRoles().equals("admin"))
					return "admin";
				if(u.getRoles().equals("client"))
					return "client";
			}
		}
		return null;
	}

	

	public static boolean inOut(User user) {
		if (user.getId() > 0)
			return true;
		return false;
	}
}
