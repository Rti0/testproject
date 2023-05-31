package com.example.demo.Repository;


import com.example.demo.Model.Place;
import com.example.demo.Model.PlaceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDetailsRepository extends JpaRepository <PlaceDetails,Integer> {
    Place findAllById(Integer id);
    PlaceDetails findPlaceDetailsById(Integer id);
}
