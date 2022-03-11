package de.logilutions.de.pantryservice.repository;

import de.logilutions.de.pantryservice.model.Item;
import de.logilutions.de.pantryservice.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemById(Long id);
    List<Item> findAllByDescription(String description);
    List<Item> findAllByDescriptionLike(String description);

    List<Item> findAllByLocation_Id(Long locationId);
    List<Item> findAllByCategory_Id(Long categoryId);

    List<Item> findAllByExpiryDateBefore(Date date);
}
