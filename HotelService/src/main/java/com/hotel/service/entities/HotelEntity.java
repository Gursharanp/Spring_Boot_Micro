package com.hotel.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="hotels")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class HotelEntity {

    @Id
    @Column(name="Id")
    private String id;

    @Column(name="Hotel_Name")
    private String name;

    @Column(name="Location")
    private String location;

    @Column(name="About")
    private String about;

}
