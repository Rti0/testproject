package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "varchar (10) not null ")
    private String name;


    @Column(columnDefinition = "varchar (10) not null ")
    private String City;


    @Column(columnDefinition = "varchar (10) not null check(Category= 'Adman' or 'User')")
    private String role;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "place")
    @PrimaryKeyJoinColumn
    private PlaceDetails placeDetails;


}
