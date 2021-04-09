package ec.fin.edu.espe.cloud.parking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.edu.espe.cloud.parking.model.Parking;
import ec.fin.edu.espe.cloud.parking.repositorys.ParkingRepository;

@RestController
public class ParkingController {
	
	@Autowired
	private ParkingRepository repository;
	
	@GetMapping("/parking/{space}/update")
	public String updateParking(@PathVariable String space)
	{
		Optional<Parking> parkOptional =  repository.findBySpace(space);
		if(parkOptional.isPresent())
		{
			parkOptional.get().setEnable(!parkOptional.get().getEnable());
			repository.save(parkOptional.get());
		}
		
		return "Ok";
	}
	
	@GetMapping("/parkings")
	public List<Parking> getAll()
	{
		return repository.findAll();
	}
}
