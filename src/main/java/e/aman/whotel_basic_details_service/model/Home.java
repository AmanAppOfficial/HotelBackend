package e.aman.whotel_basic_details_service.model;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;

public class Home extends RepresentationModel<Home>{
	
	private ResponseEntity<CollectionModel<Cities>> cities;
	private ResponseEntity<CollectionModel<Offers>> offers;
	
	public Home() {}

	public ResponseEntity<CollectionModel<Cities>> getCities() {
		return cities;
	}

	public void setCities(ResponseEntity<CollectionModel<Cities>> cities) {
		this.cities = cities;
	}

	public ResponseEntity<CollectionModel<Offers>> getOffers() {
		return offers;
	}

	public void setOffers(ResponseEntity<CollectionModel<Offers>> offers) {
		this.offers = offers;
	}

	
	
	
	
}
