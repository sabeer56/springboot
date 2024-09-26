package Restaurent.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurent.com.Dao.RestaurentDao;
import Restaurent.com.dto.RestaurentProfile;

@Service
public class RestaurentService {
	@Autowired
	public RestaurentDao dao;
	
	public RestaurentProfile RestaurentSave(RestaurentProfile res) {
		return dao.RestaurentSave(res);
	}
}
