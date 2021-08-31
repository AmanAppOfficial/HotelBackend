package e.aman.whotel_basic_details_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import e.aman.whotel_basic_details_service.model.Hotels;
import e.aman.whotel_basic_details_service.service.HotelsService;

@RestController
@RequestMapping("/api/v1")
public class HotelsController {
	

	@Autowired
	private HotelsService hotelsService;

	@GetMapping("/recommended")
	public ResponseEntity<CollectionModel<Hotels>> getRecommendedHotels(@RequestParam int number){
		return hotelsService.getRecommendedHotels(number);
	}
	
	@GetMapping("/hotel/{id}")
	public ResponseEntity getHotel(@PathVariable("id") Long id){
		return hotelsService.getHotel(id);
	}
	
}
