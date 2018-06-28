package com.thinkxfactor.zomatoplus.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Items;
import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.ItemsRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurant")

public class RestaurantController {
	
	/*@PostMapping("/create")
	public Restaurant restaurantCreate(@RequestBody Restaurant restaurant)
	{
		System.out.println(restaurant.toString());
		return restaurant;
	}

	@GetMapping("/listall")
	public List<Restaurant> restaurantList() {
		List<Restaurant> rst = new ArrayList<>();
		Restaurant rst1,rst2,rst3;
		rst1 = new Restaurant("India",8,24523452,"www.indiarestaurant.com");
		rst2 = new Restaurant("Meridian",6,23423671,"www.meridian.com");
		rst3 = new Restaurant("Aminia",10,24982271,"www.aminiarestaurant.com");
		rst.add(rst1);
		rst.add(rst2);
		rst.add(rst3);
		return rst;
	}
	
	@PostMapping("/items")
	public Items addItem(@RequestBody Items item)
	{
		System.out.println(item.toString());
		return item;
	}*/
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private ItemsRepository itemsRepository;
	
	@PostMapping("/add")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant)
	{
		Restaurant persistedRestaurant =restaurantRepository.save(restaurant);//inserting in the database
		return persistedRestaurant;
	}
	
	@GetMapping("/getAll")
	public List<Restaurant> getAll()
	{
		List<Restaurant> listofrestaurants = restaurantRepository.findAll();//retrieving all the records from the database
		return listofrestaurants;
	}
	@PostMapping("/addItem")
	public Items addItem(@RequestBody Items item)
	{
		Items persistedItem = itemsRepository.save(item);
		return persistedItem;
	}
	@GetMapping("/getAllItems")
	public List<Items> getItems()
	{
		List<Items> listofitems = itemsRepository.findAll();
		return listofitems;
	}
	
}
