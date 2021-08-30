package e.aman.whotel_basic_details_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e.aman.whotel_basic_details_service.model.Home;
import e.aman.whotel_basic_details_service.service.HomeService;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

	@Autowired
	private HomeService homeService;

	
	@GetMapping("/home")
	public ResponseEntity<Home> getHomeDetails(){
		return homeService.getHomeDetails();
	}
}
