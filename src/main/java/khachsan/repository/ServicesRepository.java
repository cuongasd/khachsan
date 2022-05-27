package khachsan.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import khachsan.domain.Services;
@Repository
public interface ServicesRepository extends CrudRepository<Services, Integer>{
	
}
