package de.logilutions.de.pantryservice.controller;

import de.logilutions.de.pantryservice.model.Location;
import de.logilutions.de.pantryservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/location/")
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getLocations() {
        return this.locationService.getLocations();
    }

    @GetMapping("id/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @GetMapping("name/{name}")
    public Location getLocationByName(@PathVariable String name) {
        return locationService.getLocationByName(name);
    }

    @GetMapping("like/{name}")
    public List<Location> getLocationsWithNameLike(@PathVariable String name) {
        return locationService.getLocationsWithNameLike(name);
    }


    @PostMapping
    public Location addLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    @PutMapping
    public Location saveLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    @DeleteMapping("{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
