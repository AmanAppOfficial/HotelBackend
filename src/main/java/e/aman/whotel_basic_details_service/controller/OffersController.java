package e.aman.whotel_basic_details_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e.aman.whotel_basic_details_service.model.Offers;
import e.aman.whotel_basic_details_service.service.OffersService;

@RestController
@RequestMapping("/api/v1")
public class OffersController {

	@Autowired
	private OffersService offersService;

	@GetMapping("/offers")
	public ResponseEntity<CollectionModel<Offers>> getOffers() {
		return offersService.getOffers();
	}

	@GetMapping("/offer/{id}")
	public ResponseEntity getOffer(@PathVariable("id") Long id) {
		return offersService.getOffer(id);
	}

}
