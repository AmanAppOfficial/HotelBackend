package e.aman.whotel_basic_details_service.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import e.aman.whotel_basic_details_service.controller.CitiesController;
import e.aman.whotel_basic_details_service.controller.HomeController;
import e.aman.whotel_basic_details_service.controller.OffersController;
import e.aman.whotel_basic_details_service.model.Home;

@Service
public class HomeService {

	@Autowired
	private CitiesController cityController;
	
	@Autowired
	private OffersController offerController;
	
	
	public ResponseEntity<Home> getHomeDetails(){
		
		Home home = new Home();
		
		home.setCities(cityController.getCities());
		home.setOffers(offerController.getOffers());
		
		Link selfLink = linkTo(methodOn(HomeController.class).getHomeDetails()).withSelfRel();
		home.add(selfLink);
		return ResponseEntity.ok().body(home);
		
	}
	
}
