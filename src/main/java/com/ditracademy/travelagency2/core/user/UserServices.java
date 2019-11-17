package com.ditracademy.travelagency2.core.user;

import com.ditracademy.travelagency2.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> createUser(User user){
        if (user.getName()== null)
            return new ResponseEntity<>(new ErrorResponseModel("User Name Required"), HttpStatus.BAD_REQUEST);
        if  (user.getName().length()<3)
            return new ResponseEntity<>(new ErrorResponseModel("Wrong User Name"), HttpStatus.BAD_REQUEST);
        if (user.getAge()== null)
            return new ResponseEntity<>(new ErrorResponseModel("User Age Required"), HttpStatus.BAD_REQUEST);
        if (user.getAge()<0 || user.getAge()>200)
            return new ResponseEntity<>(new ErrorResponseModel("Wrong User Age"), HttpStatus.BAD_REQUEST);

        user=userRepository.save(user);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }

    public List<User> getUser(){

        return userRepository.findAll();
    }

    public ResponseEntity<?> getOneUser(int id){
        Optional<User> userOptional= userRepository.findById(id);

        if (!userOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("User not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        User user = userOptional.get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteUserById(int id) {
        Optional<User> userOptional= userRepository.findById(id);

        if (!userOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("User not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> updateUserById(int id, User updatedUser){
        Optional<User> userOptional= userRepository.findById(id);


        if (!userOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("User not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        User dataBaseUser = userOptional.get();

        if (updatedUser.getName() != null){
            if (updatedUser.getName()== null)
                return new ResponseEntity<>(new ErrorResponseModel("User Name Required"), HttpStatus.BAD_REQUEST);
            if  (updatedUser.getName().length()<3)
                return new ResponseEntity<>(new ErrorResponseModel("Wrong User Name"), HttpStatus.BAD_REQUEST);
            dataBaseUser.setName(updatedUser.getName());
        }

        if (updatedUser.getAge() != null){
            if (updatedUser.getAge()== null)
                return new ResponseEntity<>(new ErrorResponseModel("User Age Required"), HttpStatus.BAD_REQUEST);
            if (updatedUser.getAge()<0 || updatedUser.getAge()>200)
                return new ResponseEntity<>(new ErrorResponseModel("Wrong User Age"), HttpStatus.BAD_REQUEST);
            dataBaseUser.setAge(updatedUser.getAge());
        }


        userRepository.save(dataBaseUser);
        return  new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    public  ResponseEntity<?> getUsersByAge(){
        List<User> userList = userRepository.findAllByAgeIsLessThan(20);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


}
