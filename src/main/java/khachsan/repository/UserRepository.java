package khachsan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import khachsan.domain.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
}
