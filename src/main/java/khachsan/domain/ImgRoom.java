package khachsan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tblImgroom")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImgRoom {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "room_id",nullable = false)
	private Room room;
	@Column(nullable = false)
	private String img;
}
