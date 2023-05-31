package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.Place;
import com.example.demo.Repository.RepositoryPlace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicePlace {
    private final RepositoryPlace repositoryPlace;

    public List<Place> findAll() {
        return repositoryPlace.findAll();
    }

    public void addPlace(Place place) {
        repositoryPlace.save(place);
    }

    public void updatePlace(Place place, Integer id) {
        Place place1 = repositoryPlace.findPlaceById(id);
        if (place1 == null) {
            throw new ApiException("update");
        }
        place1.setName(place.getName());
        place1.setCity(place.getCity());
        place1.setRole(place.getRole());
        repositoryPlace.save(place1);
    }



    public void deletePlace(Integer id) {
       Place place = repositoryPlace.getById(id);
        if (place == null) {
            throw new ApiException("DELETE");
        }
        repositoryPlace.delete(place);
    }

}
