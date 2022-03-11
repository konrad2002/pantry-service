package de.logilutions.de.pantryservice.service;

import de.logilutions.de.pantryservice.model.Category;
import de.logilutions.de.pantryservice.model.Item;
import de.logilutions.de.pantryservice.model.Location;
import de.logilutions.de.pantryservice.repository.CategoryRepository;
import de.logilutions.de.pantryservice.repository.ItemRepository;
import de.logilutions.de.pantryservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private LocationRepository locationRepository;
    private CategoryRepository categoryRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository, LocationRepository locationRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
    }


    public List<Item> getItems() {
        return this.itemRepository.findAll();
    }

    public Item getItem(Long id) {
        Item item = itemRepository.findItemById(id);
        if (item == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with given id " + id + " does not exist");
        return item;
    }

    public List<Item> getItemsByDescription(String description) {
        return itemRepository.findAllByDescription(description);
    }

    public List<Item> getItemsWithDescriptionLike(String description) {
        description = "%" + description + "%";
        return itemRepository.findAllByDescriptionLike(description);
    }

    public List<Item> getItemsByLocation(Location location) {
        if (location.getName().isEmpty() && location.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No location found matching given id or name.");
        }
        Long locationId = location.getId();

        if (locationId == null) {
            locationId = locationRepository.findLocationByName(location.getName()).getId();
        }
        if (locationId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No location found matching given id or name.");
        }

        return itemRepository.findAllByLocation_Id(locationId);
    }

    public List<Item> getItemsByCategory(Category category) {
        if (category.getName().isEmpty() && category.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No category found matching given id or name.");
        }
        Long categoryId = category.getId();

        if (categoryId == null) {
            categoryId = categoryRepository.findCategoryByName(category.getName()).getId();
        }
        if (categoryId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No category found matching given id or name.");
        }

        return itemRepository.findAllByCategory_Id(categoryId);
    }

    public List<Item> getExpiredItems() {
        return itemRepository.findAllByExpiryDateBefore(new Date());
    }


    public Item addItem(Item item) {
        item.setId(null);

        return saveItem(item);
    }

    public Item saveItem(Item item) {
        if (item.getDescription().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty item name is not allowed");
        }

        Category category = null;
        Location location = null;

        if (item.getCategory() != null && ( item.getCategory().getId() != null || !item.getCategory().getName().isEmpty())) {
            // if id is set, find category by id, otherwise use name
            if (item.getCategory().getId() != null) {
                category = categoryRepository.findCategoryById(item.getCategory().getId());
                if (category == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No category found with given id");
            } else {
                category = categoryRepository.findCategoryByName(item.getCategory().getName());
                if (category == null) {
                    category = categoryRepository.save(new Category(null, item.getCategory().getName()));
                }
            }
        }


        if (item.getLocation() != null && ( item.getLocation().getId() != null || !item.getLocation().getName().isEmpty())) {
            // if id is set, find location by id, otherwise use name
            if (item.getLocation().getId() != null) {
                location = locationRepository.findLocationById(item.getLocation().getId());
                if (location == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No location found with given id");
            } else {
                location = locationRepository.findLocationByName(item.getLocation().getName());
                if (location == null) {
                    location = locationRepository.save(new Location(null, item.getLocation().getName()));
                }
            }
        }

        item.setCategory(category);
        item.setLocation(location);

        return this.itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findItemById(id);
        if (item == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with given id " + id + " does not exist");
        else itemRepository.delete(item);
    }
}
