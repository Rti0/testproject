package com.example.demo.Controller;

import com.example.demo.DTO.PlaceDetailsDTO;
import com.example.demo.Model.Place;
import com.example.demo.Model.PlaceDetails;
import com.example.demo.Service.PlaceDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/placeD")
@RequiredArgsConstructor
public class PlaceDetailsController {
    private final PlaceDetailsService placeDetailsService;

    public List<PlaceDetails> findAll() {
        return placeDetailsService.findAll();
    }

    @PostMapping("/addDetails")
    public ResponseEntity addDetailsToPlace(@RequestBody @Valid PlaceDetailsDTO placeDetailsDTO){
        placeDetailsService.addPlaceDetails(placeDetailsDTO);
        return ResponseEntity.status(200).body("Done Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePlaceDetails(@Valid @RequestBody PlaceDetails placeDetails, @PathVariable Integer id){
       placeDetailsService.updatePlaceDetails(placeDetails,id);
        return ResponseEntity.status(200).body("Updated Done");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlaceDetails(@PathVariable Integer id){
       placeDetailsService.deletePlaceDetails(id);
        return ResponseEntity.status(200).body("Deleted Done");
    }

    @GetMapping("/getDetails/{id}")
    public ResponseEntity getPlaceDetails(@PathVariable  Integer id){
        return ResponseEntity.status(200).body(placeDetailsService.getPlaceDetails(id));
    }


}
