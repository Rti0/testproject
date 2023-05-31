package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@Entity
@NoArgsConstructor
public class PlaceDetails {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(100) not null")
    private String location;


    @Column(columnDefinition = "varchar(8) not null")
    private String timeWork;


    @Column(columnDefinition = "varchar(20) not null")
    private String date;

    @Column(columnDefinition = "varchar(20) not null")
    private String durationOfEvent;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Place place;
}