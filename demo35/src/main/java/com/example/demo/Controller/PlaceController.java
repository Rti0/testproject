package com.example.demo.Controller;

import com.example.demo.Model.Place;
import com.example.demo.Service.ServicePlace;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/place")
@RequiredArgsConstructor
public class PlaceController {
    private final ServicePlace servicePlace;

@GetMapping("get")
    public List<Place> findAll() {
        return servicePlace.findAll();
    }


    @PostMapping("/addPlace")
    public ResponseEntity addPlace(Place place){
        servicePlace.addPlace(place);
        return ResponseEntity.status(200).body("Added Done");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePlace(@Valid @RequestBody Place place,@PathVariable Integer id){
    servicePlace.updatePlace(place, id);
        return ResponseEntity.status(200).body("Updated Done");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlace(@PathVariable Integer id){
        servicePlace.deletePlace(id);
        return ResponseEntity.status(200).body("Deleted Done");
    }

}
