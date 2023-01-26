package com.deliverybusiness.service;

import com.deliverybusiness.Dao.ICityDao;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith( SpringRunner.class )
@SpringBootTest
class CityServiceImplTest {

   @Autowired
   private ICityDao iCityDao;

    private CityServiceImpl cityServiceImpl;

    @BeforeEach
    public void setup(){
     cityServiceImpl = new CityServiceImpl(iCityDao);
    }


    @Test
    void findAll() {
        List<City> listaGradova = cityServiceImpl.findAll();
        List<City> listaDaoGradova = iCityDao.findAll();
        assertNotNull(listaGradova);
        assertNotNull(listaDaoGradova);
        assertEquals(listaGradova.size(), listaDaoGradova.size());

    }

    @Test
    void findById() {
     City city = cityServiceImpl.findById(1);
     Optional<City> cityOptional = iCityDao.findById(1);
     assertNotNull(city);
     assertTrue(cityOptional.isPresent());
     assertEquals(city.getId(), cityOptional.get().getId());
    }
 @Test
 void findByWrongId() {
  Assertions.assertThrows(WrongIdException.class, () -> {
   cityServiceImpl.findById(11000);
  });

 }

    @Test
    void removeCity() {
        cityServiceImpl.removeCity(14);
        Optional<City> findCity = iCityDao.findById(14);
        assertFalse(findCity.isPresent());
    }

    @Test
    void addCity() {
       City grad = new City(14, "Kraljevo", "23321");
       cityServiceImpl.addCity(grad);
       Optional<City> nadjiGrad = iCityDao.findById(14);
       assertTrue(nadjiGrad.isPresent());
       assertEquals(grad.getId(), nadjiGrad.get().getId());
       assertEquals(grad.getName(), nadjiGrad.get().getName());
    }

    @Test
    void updateCity() {
        City grad = new City(16, "Kraljevo", "23321");
        cityServiceImpl.addCity(grad);
        grad.setName("Zrenjanin");
        cityServiceImpl.updateCity(grad, 16);
        Optional<City> gradic = iCityDao.findById(16);
        assertTrue(gradic.isPresent());
        assertEquals("Zrenjanin", gradic.get().getName());
    }

    @Test
    void findByName() {
        City ciudad = new City(17, "Barcelona", "12345");
        cityServiceImpl.addCity(ciudad);
        Optional<City> ciudad2 = iCityDao.findById(17);
        assertTrue(ciudad2.isPresent());
        assertEquals(ciudad.getName(), ciudad2.get().getName());


    }

    @Test
    void saveList() {
    }

    @Test
    void findByNameLike() {
        List<City> patternCity = cityServiceImpl.findByNameLike("in");
        List<City> patternCity2 = iCityDao.findByNameContaining("in");
        assertNotNull(patternCity);
        assertNotNull(patternCity2);
        assertEquals(patternCity.size(), patternCity2.size());


    }
}