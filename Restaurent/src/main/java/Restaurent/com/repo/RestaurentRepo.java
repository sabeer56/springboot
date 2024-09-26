package Restaurent.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Restaurent.com.dto.RestaurentProfile;

public interface RestaurentRepo extends JpaRepository<RestaurentProfile, String>{

}
