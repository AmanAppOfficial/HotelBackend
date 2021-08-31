package e.aman.whotel_basic_details_service.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import e.aman.whotel_basic_details_service.controller.CitiesController;
import e.aman.whotel_basic_details_service.controller.HotelsController;
import e.aman.whotel_basic_details_service.model.Cities;
import e.aman.whotel_basic_details_service.model.Hotels;
import e.aman.whotel_basic_details_service.repository.HotelsRepository;

@Service
public class HotelsService {

	@Autowired
	private HotelsRepository repo;
	
	public ResponseEntity<CollectionModel<Hotels>> getRecommendedHotels(int number){
		
		List<Hotels> hotelList = repo.getHotelsByLimit(number);
		
		for(Hotels hotel : hotelList) {
			Link link = linkTo(methodOn(HotelsController.class).getHotel(hotel.getId())).withSelfRel();
			hotel.add(link);
		}
		Link selfLink = linkTo(methodOn(HotelsController.class).getRecommendedHotels(number)).withSelfRel();
		return ResponseEntity.ok().body(CollectionModel.of(hotelList , selfLink));
		
	}
	
	public ResponseEntity getHotel(Long id) {
	    Optional<Hotels> hotel = repo.findById(id);
	    Hotels h = new Hotels();
	    h.setAddress(hotel.get().getAddress());
	    h.setCity(hotel.get().getCity());
	    h.setId(hotel.get().getId());
	    h.setImage(hotel.get().getImage());
	    h.setName(hotel.get().getName());
	    h.setRating(hotel.get().getRating());
	    h.setReal_price(hotel.get().getReal_price());
	    h.setSale_price(hotel.get().getSale_price());
	    
	    Link selfLink = linkTo(methodOn(HotelsController.class).getHotel(id)).withSelfRel();
	    h.add(selfLink);
	    
		return ResponseEntity.ok().body(h);
	}
	
}
