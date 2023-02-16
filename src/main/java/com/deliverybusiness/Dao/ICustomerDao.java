package com.deliverybusiness.Dao;
import com.deliverybusiness.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer> {
    List<Customer> findByFullName(String name);

    List<Customer> findByFullNameStartingWith(String prefix);

    List<Customer> findByFullNameIsNotNull();

    List<Customer> findByFullNameIsNot(String name);

@Query("Select c from Customer c where address=:address and c.city.name=:name")
    List<Customer> findByCityAndAddress(String address, String name);

}
