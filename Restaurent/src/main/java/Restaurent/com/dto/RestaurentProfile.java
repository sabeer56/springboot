package Restaurent.com.dto;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
@Component
public class RestaurentProfile {
	@Id
    private String restaurentName;
    private String email;
    private String location;
    private String cuisineType;
    private String openingHours;
    private String contact;
    private String password;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte images[];
	public String getRestaurentName() {
		return restaurentName;
	}
	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getImages() {
		return images;
	}
	public void setImages(byte[] images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "RestaurentProfile [RestaurentName=" + restaurentName + ", email=" + email + ", location=" + location
				+ ", cuisineType=" + cuisineType + ", openingHours=" + openingHours + ", contact=" + contact
				+ ", password=" + password + ", images=" + Arrays.toString(images) + "]";
	}
	
    
}
