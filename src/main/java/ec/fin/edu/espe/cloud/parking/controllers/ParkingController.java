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
	
	@GetMapping("/parking/{space}/{state}/update")
	public String updateParking(@PathVariable String space, @PathVariable Integer state)
	{
		Optional<Parking> parkOptional =  repository.findBySpace(space);
		if(parkOptional.isPresent())
		{
			Parking park = parkOptional.get();
			if(state == 1)
			{
				park.setEnable(true);
			}
			else
			{
				park.setEnable(false);
			}
			repository.save(park);
		}
		
		return "Ok";
	}
	
	@GetMapping("/parkings")
	public List<Parking> getAll()
	{
		return repository.findAll();
	}
	
	@GetMapping("/parking/{space}/get-state")
	public Integer getState(@PathVariable String space)
	{
		Optional<Parking> parkOptional =  repository.findBySpace(space);
		if(parkOptional.isPresent())
		{
			 if(parkOptional.get().getEnable())
			 {
				 return 1;
			 }
		}
		return 0;
	}
}
