package khachsan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblUser")
@Component
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 255)
	private String name;
	
	@Column(unique = true,nullable = false,length = 255)
	private String email;
	
	@Column(nullable = false,length = 255)
	private String passWord;
	
	@Column(nullable = false,length = 255)
	private String phone;
	
	@Column(nullable = false,length = 255)
	private String roles;
	
	public String toString() {
		return id+" "+email;
	}
	
}

