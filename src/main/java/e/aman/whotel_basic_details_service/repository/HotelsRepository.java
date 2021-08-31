package e.aman.whotel_basic_details_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import e.aman.whotel_basic_details_service.model.Hotels;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels , Long>{
	

	@Query( nativeQuery=true , value="SELECT * FROM hotels e ORDER BY e.id LIMIT :limit")
	List<Hotels> getHotelsByLimit(@Param("limit") int limit);
	
}
