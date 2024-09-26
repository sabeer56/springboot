package Restaurent.com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Restaurent.com.dto.RestaurentProfile;
import Restaurent.com.repo.RestaurentRepo;

@Repository
public class RestaurentDao {
	@Autowired
	public RestaurentRepo repo;
	
	public RestaurentProfile RestaurentSave(RestaurentProfile res) {
		return repo.save(res);
	}
}
