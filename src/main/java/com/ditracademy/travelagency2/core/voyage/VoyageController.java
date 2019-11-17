package com.ditracademy.travelagency2.core.voyage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoyageController {

    @Autowired
    VoyageServices voyageServices;

    @PostMapping("/voyage")
    public ResponseEntity<?> createVoyage(@RequestBody Voyage voyage){
        return voyageServices.createVoyage(voyage);
    }

    @GetMapping("/voyages")
    public List<Voyage> getVoyages(){
        return voyageServices.getVoyages();
    }

    @GetMapping("/voyage/{id}")
    public ResponseEntity<?> getOneVoyage(@PathVariable int id){
        return voyageServices.getOneVoyage(id);
    }

    @DeleteMapping("/voyage/{id}")
    public ResponseEntity<?> deleteVoyageById(@PathVariable int id) {
        return voyageServices.deleteVoyage(id);
    }

    @PutMapping("/voyage/{id}")
    public ResponseEntity<?> updateVoyageById(@PathVariable int id,@RequestBody Voyage updatedVoyage){
        return voyageServices.updateVoyageById(id,updatedVoyage);
    }
}
