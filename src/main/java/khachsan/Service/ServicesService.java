package khachsan.Service;

import org.springframework.stereotype.Service;

import khachsan.domain.Services;
import khachsan.repository.ServicesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ServicesService {
	@Autowired
	private ServicesRepository servicesRepository;
	
	public List<Services> getListAll() {
		return (List<Services>) servicesRepository.findAll();
	}

	
	
}
