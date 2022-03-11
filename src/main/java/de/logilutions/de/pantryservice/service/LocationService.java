package de.logilutions.de.pantryservice.service;

import de.logilutions.de.pantryservice.model.Location;
import de.logilutions.de.pantryservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LocationService {
    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }



    public List<Location> getLocations() {
        return this.locationRepository.findAll();
    }

    public Location getLocation(Long id) {
        Location location = locationRepository.findLocationById(id);
        if (location == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location with given id " + id + " does not exist");
        return location;
    }

    public Location getLocationByName(String name) {
        Location location = locationRepository.findLocationByName(name);
        if (location == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location with given name '" + name + "' does not exist");
        return location;
    }

    public List<Location> getLocationsWithNameLike(String name) {
        name = "%" + name + "%";
        return locationRepository.findAllByNameLike(name);
    }



    public Location addLocation(Location location) {
        if (location.getId() != null) {
            location.setId(null);
        }
        return saveLocation(location);
    }

    public Location saveLocation(Location location) {
        if (location.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty location name is not allowed");
        }

        if (locationRepository.findLocationByName(location.getName()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location with given name '" + location.getName() + "' already exists");
        }

        return this.locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        Location location = locationRepository.findLocationById(id);
        if (location == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location with given id " + id + " does not exist");
        else locationRepository.delete(location);
    }
}
