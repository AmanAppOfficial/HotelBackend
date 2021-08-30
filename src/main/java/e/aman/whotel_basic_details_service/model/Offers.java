package e.aman.whotel_basic_details_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

@Entity
public class Offers extends RepresentationModel<Offers>{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String image;
	private Long code;
	
	public Offers() {}

	public Offers(Long id, String image, Long code) {
		super();
		this.id = id;
		this.image = image;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Offers [id=" + id + ", image=" + image + ", code=" + code + "]";
	}
	
}
