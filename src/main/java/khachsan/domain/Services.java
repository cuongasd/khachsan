package khachsan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblService")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private float price;
}
