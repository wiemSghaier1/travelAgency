package com.ditracademy.travelagency2.core.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAllByAgeIsLessThan(int age);
}
