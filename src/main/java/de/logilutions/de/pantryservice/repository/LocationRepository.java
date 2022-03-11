package de.logilutions.de.pantryservice.repository;

import de.logilutions.de.pantryservice.model.Category;
import de.logilutions.de.pantryservice.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findLocationById(Long id);
    Location findLocationByName(String name);
    List<Location> findAllByNameLike(String name);
}
