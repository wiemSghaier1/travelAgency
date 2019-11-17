package com.ditracademy.travelagency2.core.destination;

import com.ditracademy.travelagency2.core.user.User;
import com.ditracademy.travelagency2.core.user.UserRepository;
import com.ditracademy.travelagency2.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationServices {

    @Autowired
    DestinationRepository destinationRepository;

    public ResponseEntity<?> createDestination(Destination destination){
        destination=destinationRepository.save(destination);
        return  new ResponseEntity<>(destination, HttpStatus.OK);
    }

    public List<Destination> getDestination(){

        return destinationRepository.findAll();
    }

    public ResponseEntity<?> getOneDestination(int id){
        Optional<Destination> destinationOptional= destinationRepository.findById(id);

        if (!destinationOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("Destination not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        Destination destination = destinationOptional.get();
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteDestinationById(int id) {
        Optional<Destination> destinationOptional= destinationRepository.findById(id);

        if (!destinationOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("Destination not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        destinationRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> updateDestinationById(int id, Destination updatedDestination){
        Optional<Destination> destinationOptional= destinationRepository.findById(id);

        if (!destinationOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("Destination not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        Destination dataBaseDestination = destinationOptional.get();

        if(updatedDestination.getNom() != null)
            dataBaseDestination.setNom(updatedDestination.getNom());

        if (updatedDestination.getDescription() != null)
            dataBaseDestination.setDescription(updatedDestination.getDescription());

        destinationRepository.save(dataBaseDestination);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
