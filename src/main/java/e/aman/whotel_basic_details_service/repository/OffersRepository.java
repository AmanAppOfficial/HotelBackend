package e.aman.whotel_basic_details_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import e.aman.whotel_basic_details_service.model.Offers;

@Repository
public interface OffersRepository extends JpaRepository<Offers , Long>{

}
