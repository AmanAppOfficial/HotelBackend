package e.aman.whotel_basic_details_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

@Entity
public class Cities extends RepresentationModel<Cities>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String image;
	
	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cities(Long id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Cities [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
	
	

}
