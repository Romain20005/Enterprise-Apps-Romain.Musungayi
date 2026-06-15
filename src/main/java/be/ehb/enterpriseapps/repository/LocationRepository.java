package be.ehb.enterpriseapps.repository;

import be.ehb.enterpriseapps.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
