package ec.fin.edu.espe.cloud.parking.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.fin.edu.espe.cloud.parking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long>{

	Optional<Parking> findBySpace(String space);
}
