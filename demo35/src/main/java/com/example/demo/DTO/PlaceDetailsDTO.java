package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PlaceDetailsDTO {

    private Integer please_id;

    private String location;
    private String timeWork;
    private String date;
    private String durationOfEvent;
}
