package de.logilutions.de.pantryservice.repository;

import de.logilutions.de.pantryservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryById(Long id);
    Category findCategoryByName(String name);
    List<Category> findAllByNameLike(String name);
}
