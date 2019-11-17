package com.ditracademy.travelagency2.core.destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DestinationController {

    @Autowired
    DestinationServices destinationServices;

    @PostMapping("/destination")
    public ResponseEntity<?> createDestination(@RequestBody Destination destination){
        return destinationServices.createDestination(destination);
    }

    @GetMapping("/destination")
    public List<Destination> getDestination(){
        return destinationServices.getDestination();
    }

    @GetMapping("/destination/{id}")
    public ResponseEntity<?> getOneDestination(@PathVariable int id){
        return destinationServices.getOneDestination(id);
    }

    @DeleteMapping("/destination/{id}")
    public ResponseEntity<?> deleteDestinationById(@PathVariable int id) {
        return destinationServices.deleteDestinationById(id);
    }

    @PutMapping("/destination/{id}")
    public ResponseEntity<?> updateDestinationById(@PathVariable int id,@RequestBody Destination updatedDestination){
        return destinationServices.updateDestinationById(id,updatedDestination);
    }
}
