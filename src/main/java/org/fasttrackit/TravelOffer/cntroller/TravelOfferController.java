package org.fasttrackit.TravelOffer.cntroller;

import org.fasttrackit.TravelOffer.model.TravelOffer;
import org.fasttrackit.TravelOffer.service.TravelOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TravelOfferController {
    private final TravelOfferService travelOfferService;

    @Autowired
    public TravelOfferController(TravelOfferService travelOfferService) {
        this.travelOfferService = travelOfferService;
    }

    @GetMapping("/traveloffers")
    public String getAllTravelOffers(Model model) {
        List<TravelOffer> travelOffers = travelOfferService.getAllTravelOffers();
        model.addAttribute("travelOffers", travelOffers);
        return "travel_offer_list";
    }





    @GetMapping("/traveloffers/{id}")
    public String getTravelOfferById(@PathVariable Long id, Model model) {
        TravelOffer travelOffer = travelOfferService.getTravelOfferById(id);
        model.addAttribute("travelOffer", travelOffer);
        return "travel_offer_details";
    }

    @GetMapping("/traveloffers/add")
    public String showAddForm(Model model) {
        model.addAttribute("travelOffer", new TravelOffer());
        return "add_travel_offer";
    }

    @PostMapping("/traveloffers/add")
    public String addTravelOffer(@ModelAttribute TravelOffer travelOffer) {
        travelOfferService.saveTravelOffer(travelOffer);
        return "redirect:/traveloffers";
    }

    @GetMapping("/traveloffers/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        TravelOffer travelOffer = travelOfferService.getTravelOfferById(id);
        model.addAttribute("travelOffer", travelOffer);
        return "edit_travel_offer";
    }

    @PostMapping("/traveloffers/edit/{id}")
    public String updateTravelOffer(@PathVariable Long id, @ModelAttribute TravelOffer travelOffer) {
        travelOffer.setId(id);
        travelOfferService.saveTravelOffer(travelOffer);
        return "redirect:/traveloffers";
    }

    @GetMapping("/traveloffers/delete/{id}")
    public String deleteTravelOffer(@PathVariable Long id) {
        travelOfferService.deleteTravelOffer(id);
        return "redirect:/traveloffers";
    }
}
