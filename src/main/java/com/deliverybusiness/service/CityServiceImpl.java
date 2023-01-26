package com.deliverybusiness.service;

import com.deliverybusiness.Dao.ICityDao;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private ICityDao iCityDao;

    public CityServiceImpl() {
    }
      //connecting Dao to implementation
    public CityServiceImpl(ICityDao iCityDao) {
        this.iCityDao = iCityDao;
    }

    @Override
    public List<City> findAll() {
        return this.iCityDao.findAll();
    }

    @Override
    public City findById(int id) throws WrongIdException {
        Optional<City> optional = this.iCityDao.findById(id); /* checks if City with particular id exist.
        If its there, it will return it
        ,otherwise it will return null
        */

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new WrongIdException("Id doesnt exist");
        }
    }

    @Override
    public String removeCity(int id) {
        City city = findById(id);
        this.iCityDao.delete(city);
        return "good job";
    }

    @Override
    public City addCity(City city) {
        return this.iCityDao.save(city);
    }

    @Override
    public City updateCity(City city, int id) {
        City cityDb = findById(id);
        cityDb.setName(city.getName());
        cityDb.setZipCode(city.getZipCode());
        return this.iCityDao.save(cityDb);
    }

    @Transactional(readOnly = true)
    @Override
    public List<City> findByName(String name) {

        return this.iCityDao.findByName(name);
    }

    @Transactional
    @Override
    public List<City> saveList(List<City> cityList) {

        return this.iCityDao.saveAll(cityList);
    }

    @Override
    public List<City> findByNameLike(String pattern) {
        return this.iCityDao.findByNameContaining(pattern);
    }
}
