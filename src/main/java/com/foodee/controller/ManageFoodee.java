package com.foodee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.foodee.dto.FoodItems;
import com.foodee.dto.ResponseDto;
import com.foodee.repository.FoodRepository;
import com.foodee.service.UploadUtility;

@Controller
@RequestMapping("/manage")
public class ManageFoodee {

	@Autowired
	FoodRepository foodrepository;

	@Autowired
	UploadUtility uploadUtility;

	@ResponseBody
	@RequestMapping(value = "/foodItems", method = RequestMethod.GET)
	public List<FoodItems> getFoodItems() {

		return foodrepository.findAll();

	}

	@ResponseBody
	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public void addNew(MultipartHttpServletRequest request, HttpSession session) throws IOException

	{

		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		MultipartFile imgFile = request.getFile("file");

		uploadUtility.addFoodItems(itemName, itemPrice, imgFile, session);
	}

	@ResponseBody
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	public String handleFoodActivation(@PathVariable("id") int id) {

		FoodItems items = foodrepository.findById(id);
		boolean active = items.isEnabled();
		items.setEnabled(!items.isEnabled());
		foodrepository.save(items);

		return (active) ? "You have Successfully Deactivate the FoodItems with Id" + items.getId()
				: "You have Succesfully Activate the FoodItems with ID" + items.getId();
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto adminAuth(@RequestParam(value = "password") String Password) {
		System.out.println("!@#$%^&!@#$%^!@#$%!@#$%!@#$%^");
		ResponseDto responseDto = new ResponseDto();

		if (Password.equals("admin")) {
			responseDto.setStatus(200);
			responseDto.setMessage("items");
			System.out.println("password match");

		} else {
			responseDto.setStatus(400);
			responseDto.setMessage("password not match");
			System.out.println("password not match");
		}
		return responseDto;
	}

}
