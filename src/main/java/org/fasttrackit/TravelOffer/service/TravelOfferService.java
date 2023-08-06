package org.fasttrackit.TravelOffer.service;

import org.fasttrackit.TravelOffer.model.TravelOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelOfferService {
    private final TravelOfferRepository travelOfferRepository;

    @Autowired
    public TravelOfferService(TravelOfferRepository travelOfferRepository) {
        this.travelOfferRepository = travelOfferRepository;
    }

    public List<TravelOffer> getAllTravelOffers() {
        return travelOfferRepository.findAll();
    }

    public TravelOffer getTravelOfferById(Long id) {
        return travelOfferRepository.findById(id).orElse(null);
    }

    public void saveTravelOffer(TravelOffer travelOffer) {
        travelOfferRepository.save(travelOffer);
    }

    public void deleteTravelOffer(Long id) {
        travelOfferRepository.deleteById(id);
    }
}


