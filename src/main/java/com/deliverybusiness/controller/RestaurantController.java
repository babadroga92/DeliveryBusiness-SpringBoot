package com.deliverybusiness.controller;

import com.deliverybusiness.model.Restaurant;
import com.deliverybusiness.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private RestaurantServiceImpl restaurantService;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(method= RequestMethod.GET,produces ="application/json")
    public List<Restaurant> getAll(){
        return restaurantService.findAll();
    }
    @PostMapping
    public Restaurant addRestaurant(@RequestBody @Valid Restaurant restaurant){
        return this.restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/name")
    public List<Restaurant> findByName(@RequestParam (name = "name", required = true)String name){
        return restaurantService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable int id){
        return restaurantService.removeRestaurant(id);
    }
}
