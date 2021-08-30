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
import e.aman.whotel_basic_details_service.controller.OffersController;
import e.aman.whotel_basic_details_service.model.Cities;
import e.aman.whotel_basic_details_service.model.Offers;
import e.aman.whotel_basic_details_service.repository.OffersRepository;

@Service
public class OffersService {

	@Autowired
	private OffersRepository repo;

	public ResponseEntity<CollectionModel<Offers>> getOffers() {

		List<Offers> offerList = repo.findAll();

		for (Offers offer : offerList) {
			Link link = linkTo(methodOn(OffersController.class).getOffer(offer.getId())).withSelfRel();
			offer.add(link);
		}

		Link selfLink = linkTo(methodOn(OffersController.class).getOffers()).withSelfRel();
		return ResponseEntity.ok().body(CollectionModel.of(offerList, selfLink));

	}

	public ResponseEntity getOffer(Long id) {
		Optional<Offers> offer = repo.findById(id);
		Offers o = new Offers();
		o.setId(offer.get().getId());
		o.setImage(offer.get().getImage());
		o.setCode(offer.get().getCode());

		Link selfLink = linkTo(methodOn(OffersController.class).getOffer(id)).withSelfRel();
		o.add(selfLink);

		return ResponseEntity.ok().body(o);
	}

}
