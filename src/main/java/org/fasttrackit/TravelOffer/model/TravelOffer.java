package org.fasttrackit.TravelOffer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TravelOffer {

    @Id
    @GeneratedValue
    private Long id;

    private String destination;
    private double price;
    private String startDate;
    private String endDate;
}

