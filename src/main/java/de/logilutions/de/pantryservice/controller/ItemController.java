package de.logilutions.de.pantryservice.controller;

import de.logilutions.de.pantryservice.model.Category;
import de.logilutions.de.pantryservice.model.Item;
import de.logilutions.de.pantryservice.model.Location;
import de.logilutions.de.pantryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item/")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems() {
        return this.itemService.getItems();
    }

    @GetMapping("id/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @GetMapping("description/{description}")
    public List<Item> getItemsByDescription(@PathVariable String description) {
        return itemService.getItemsByDescription(description);
    }

    @GetMapping("like/{description}")
    public List<Item> getItemsWithDescriptionLike(@PathVariable String description) {
        return itemService.getItemsWithDescriptionLike(description);
    }

    @GetMapping("location")
    public List<Item> getItemsByLocation(@RequestBody Location location) {
        return itemService.getItemsByLocation(location);
    }

    @GetMapping("category")
    public List<Item> getItemsByCategory(@RequestBody Category category) {
        return itemService.getItemsByCategory(category);
    }

    @GetMapping("expired")
    public List<Item> getExpiredItems() {
        return itemService.getExpiredItems();
    }


    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping
    public Item saveItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
