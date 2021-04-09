package ec.fin.edu.espe.cloud.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.edu.espe.cloud.parking.model.Parking;
import ec.fin.edu.espe.cloud.parking.repositorys.ParkingRepository;

@RestController("/api")
@CrossOrigin("*")
public class ClientWebController {

	@Autowired
	private ParkingRepository repository;
	
	@GetMapping("/parkings")
	public List<Parking> getAll()
	{
		return repository.findAll();
	}
}
