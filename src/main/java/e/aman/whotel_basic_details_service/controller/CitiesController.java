package e.aman.whotel_basic_details_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e.aman.whotel_basic_details_service.model.Cities;
import e.aman.whotel_basic_details_service.service.CitiesService;

@RestController
@RequestMapping("/api/v1")
public class CitiesController {
	
	@Autowired
	private CitiesService citiesService;
	
	@GetMapping("/cities")
	public ResponseEntity<CollectionModel<Cities>> getCities(){
		return citiesService.getCities();
	}
	
	
	@GetMapping("/city/{id}")
	public ResponseEntity getCity(@PathVariable("id") Long id){
		return citiesService.getCity(id);
	}

}
