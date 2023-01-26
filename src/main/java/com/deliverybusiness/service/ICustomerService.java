package com.deliverybusiness.service;

import com.deliverybusiness.model.City;
import com.deliverybusiness.model.Customer;
import com.deliverybusiness.model.Orders;
import com.deliverybusiness.model.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable page);

    Customer findById(int id);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer, int id);

    List<Customer> findByFullName(String name);

    List<Customer> findByCityAndAddress(String address, String name);

    Customer updateCustomerName(String address, String name, CustomerDTO customerDTO);

    List<Customer> findCustomerByOrder(double price);

    List<Orders> findByCustomer(int customerId);

}
