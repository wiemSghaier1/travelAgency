package com.ditracademy.travelagency2.core.voyage;


import com.ditracademy.travelagency2.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoyageServices {

    @Autowired
    VoyageRepository voyageRepository;

    public ResponseEntity<?> createVoyage(Voyage voyage){
        voyage=voyageRepository.save(voyage);
        return  new ResponseEntity<>(voyage, HttpStatus.OK);
    }

    public List<Voyage> getVoyages (){

        return voyageRepository.findAll();
    }

    public ResponseEntity<?> getOneVoyage(int id){
        Optional<Voyage> voyageOptional= voyageRepository.findById(id);

        if (!voyageOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("voyage not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        Voyage voyage = voyageOptional.get();
        return new ResponseEntity<>(voyage, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteVoyage(int id) {
        Optional<Voyage> voyageOptional= voyageRepository.findById(id);

        if (!voyageOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("voyage not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        voyageRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> updateVoyageById(int id, Voyage updatedVoyage){
        Optional<Voyage> voyageOptional= voyageRepository.findById(id);

        if (!voyageOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("voyage not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        Voyage dataBaseVoyage = voyageOptional.get();

        if (updatedVoyage.getDate()!=null)
            dataBaseVoyage.setDate(updatedVoyage.getDate());

        if (updatedVoyage.getDescription()!= null)
            dataBaseVoyage.setDescription(updatedVoyage.getDescription());

        if (updatedVoyage.getTitre()!= null)
            dataBaseVoyage.setTitre(updatedVoyage.getTitre());

        if (updatedVoyage.getPrix()!= null)
            dataBaseVoyage.setPrix(updatedVoyage.getPrix());

        if (updatedVoyage.getNbPlaces()!= null)
            dataBaseVoyage.setNbPlaces(updatedVoyage.getNbPlaces());

        voyageRepository.save(dataBaseVoyage);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
