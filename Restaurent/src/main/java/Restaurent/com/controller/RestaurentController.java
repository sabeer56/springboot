package Restaurent.com.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Restaurent.com.dto.RestaurentProfile;
import Restaurent.com.service.RestaurentService;

@RestController
public class RestaurentController {
    @Autowired
    private RestaurentService restaurentService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public ResponseEntity<String> saveRestaurentData(
            @ModelAttribute RestaurentProfile r, @RequestBody  MultipartFile images) {
        try {
            byte[] compressedImage = compressImageData(images.getBytes());
            r.setImages(compressedImage);

            // Call service method to save restaurant profile
            restaurentService.RestaurentSave(r);

            return ResponseEntity.ok("Restaurant data saved successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to process the image file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred: " + e.getMessage());
        }
    }
  
    public byte[] compressImageData(byte[] originalImageData) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(originalImageData);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        deflater.end();
        return outputStream.toByteArray();
    }
}
