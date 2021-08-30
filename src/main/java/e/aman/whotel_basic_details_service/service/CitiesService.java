package e.aman.whotel_basic_details_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import e.aman.whotel_basic_details_service.controller.CitiesController;
import e.aman.whotel_basic_details_service.model.Cities;
import e.aman.whotel_basic_details_service.repository.CitiesRepository;

@Service
public class CitiesService {
	
	@Autowired
	private CitiesRepository repo;
	
	public ResponseEntity<CollectionModel<Cities>> getCities(){
		
		List<Cities> cityList = repo.findAll();
		
		for(Cities city : cityList) {
			Link link = linkTo(methodOn(CitiesController.class).getCity(city.getId())).withSelfRel();
			city.add(link);
		}
		
		Link selfLink = linkTo(methodOn(CitiesController.class).getCities()).withSelfRel();
		return ResponseEntity.ok().body(CollectionModel.of(cityList , selfLink));
		
	}
	
	public ResponseEntity getCity(Long id) {
	    Optional<Cities> city = repo.findById(id);
	    Cities c = new Cities();
	    c.setId(city.get().getId());
	    c.setImage(city.get().getImage());
	    c.setName(city.get().getName());
	    
	    Link selfLink = linkTo(methodOn(CitiesController.class).getCity(id)).withSelfRel();
	    c.add(selfLink);
	    
		return ResponseEntity.ok().body(c);
	}

}
