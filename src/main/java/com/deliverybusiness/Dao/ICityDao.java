package com.deliverybusiness.Dao;

import com.deliverybusiness.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // radi sa bazom podataka, cita i vraca podatke

public interface ICityDao extends JpaRepository<City, Integer> {
    //it has to extend JPaRepository with <{name of the table}, type{most likely Integer}>
    //JPa already has built in methods
    //List<City> findByZipCode(String zipCode);

    List<City> findByName(String name);

    List<City> findByNameContaining(String pattern);





}
