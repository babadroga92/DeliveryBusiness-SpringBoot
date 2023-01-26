package com.deliverybusiness.controller;

import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.City;
import com.deliverybusiness.model.view.View;
import com.deliverybusiness.service.CityServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController  // oznaka za kontroler
@RequestMapping("/city") //
public class CityController {

    private CityServiceImpl cityService;
    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @JsonView(View.Dragana.class)
    @RequestMapping(method= RequestMethod.GET,produces ="application/json")
    public List<City> getAll(){
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    //@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public City getById(@PathVariable int id) throws WrongIdException {
        return cityService.findById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable int id){
        return cityService.removeCity(id);
    }
    @PostMapping
    public City addCity(@RequestBody @Valid City city){
        return cityService.addCity(city);
    }
    @PutMapping("/{id}")
    public City updateCity(@PathVariable int id, @RequestBody @Valid City city){
        return cityService.updateCity(city,id);
    }
    @GetMapping("/name")
    public List<City> findByName(@RequestParam (name = "name", required = true) String name){
        return cityService.findByName(name);
    }
    @GetMapping("/pattern")
    public List<City> findByNameLike(@RequestParam(name = "name", required = true) String pattern){
        return cityService.findByNameLike(pattern);
    }
    @PostMapping("/saveAll")
    public List<City> saveList(@RequestBody @Valid List<City> cityList){
        return cityService.saveList(cityList);
    }
}
