package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.DTO.PlaceDetailsDTO;
import com.example.demo.Model.Place;
import com.example.demo.Model.PlaceDetails;
import com.example.demo.Repository.PlaceDetailsRepository;
import com.example.demo.Repository.RepositoryPlace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceDetailsService {
    private final PlaceDetailsRepository placeDetailsRepository;
    public final RepositoryPlace repositoryPlace;



    public List<PlaceDetails> findAll(){
        return placeDetailsRepository.findAll();
    }

    public void addPlaceDetails(PlaceDetailsDTO dto){
        Place place=repositoryPlace.findPlaceById(dto.getPlease_id());

        if (place==null){
            throw new ApiException("Can't add details, place not found");
        }
        PlaceDetails placeDetails=new PlaceDetails(null, dto.getLocation(), dto.getTimeWork(), dto.getTimeWork(), dto.getDurationOfEvent(), place);
    }

    public void updatePlaceDetails(PlaceDetails placeDetails, Integer id){
        PlaceDetails old=placeDetailsRepository.findPlaceDetailsById(id);
        if(old==null){
            throw new ApiException("Not found");
        }

        old.setId(old.getId());
        old.setLocation(old.getLocation());
        old.setTimeWork(old.getTimeWork());
        old.setDate(old.getDate());
        placeDetailsRepository.save(old);
    }


    public void deletePlaceDetails(Integer id){
        PlaceDetails placeDetails=placeDetailsRepository.findPlaceDetailsById(id);
        if(placeDetails==null){
            throw new ApiException("Not found");
        }
        placeDetailsRepository.delete(placeDetails);
    }

    public Place getPlaceDetails(Integer id){
        return repositoryPlace.findPlaceById(id);

    }

}
