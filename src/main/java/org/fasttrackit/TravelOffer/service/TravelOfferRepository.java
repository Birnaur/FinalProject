package org.fasttrackit.TravelOffer.service;

import org.fasttrackit.TravelOffer.model.TravelOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelOfferRepository extends JpaRepository<TravelOffer, Long> {
}
