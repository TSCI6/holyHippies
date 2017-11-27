package com.foodee.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.foodee.dto.FoodItems;
import com.foodee.repository.FoodRepository;

@Service
public class UploadUtility {
	
	private static final String UPLOAD_DIRECTORY = "/FoodItemsImages";
	
	@Autowired
	FoodRepository foodrepository;
	


	public void addFoodItems(String itemName, String itemPrice, MultipartFile imgFile, HttpSession session) {
		FoodItems food=new FoodItems();
		food.setName(itemName);
		food.setPrice(Integer.parseInt(itemPrice));
		food.setEnabled(true);
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = imgFile.getOriginalFilename();
		food.setImagUrl(filename);
		try {
			foodrepository.save(food);
			byte[] bytes = imgFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		
	}
	

	}
}
