package com.ditracademy.travelagency2.core.destination;

import com.ditracademy.travelagency2.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination,Integer> {
}
