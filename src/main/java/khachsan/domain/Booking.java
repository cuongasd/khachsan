package khachsan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblbooking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 255)
	private String name;
	@Column(nullable = false,length = 255)
	private String email;
	@Column(nullable = false,length = 255)
	private String phone;
	@Column(nullable = false)
	private int lengthStay;
	@Column(nullable = false)
	private int numberPerson;
	@Column(nullable = false,length = 255)
	private String arrivalDate;
	
	@OneToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
}
