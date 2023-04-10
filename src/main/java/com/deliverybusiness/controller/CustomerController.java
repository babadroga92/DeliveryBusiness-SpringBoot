package com.deliverybusiness.controller;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.Customer;
import com.deliverybusiness.model.Orders;
import com.deliverybusiness.model.dto.CustomerDTO;
import com.deliverybusiness.service.CustomerServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerServiceImpl customerService;


    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }



    @RequestMapping(path = "/all",method = RequestMethod.GET,produces ="application/json")
    public Page<Customer> getAll(Pageable page){
        return customerService.findAll(page);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Customer getById(@PathVariable int id) throws WrongIdException {
        return customerService.findById(id);
    }
    @PostMapping
    public Customer addCustomer(@RequestBody @Valid Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody @Valid Customer customer){
        return customerService.updateCustomer(customer, id);
    }

    @GetMapping("/name")
    public List<Customer> findByFullName(@RequestParam (name = "fullName", required = true) String name){
        return customerService.findByFullName(name);
    }

    @GetMapping("/address")
    public List<Customer> findByCityAndAddress(@RequestParam(name = "address", required = false)String address, @RequestParam(name = "name", required = false)String name){
        return customerService.findByCityAndAddress(address,name);
    }

    @PutMapping("/address")
    public Customer updateCustomersName(@RequestParam(name = "address")String address,
                                        @RequestParam(name = "name")String name, @RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomerName(address, name, customerDTO);
    }
    @GetMapping("/cusorder")
    public List<Customer> customerByOrder(@RequestParam(name = "price")double price){
        return customerService.findCustomerByOrder(price);
    }
    @GetMapping("/orders")
    public List<Orders> findByCustomer(@RequestParam(name = "customerId")int customerId) {
        return customerService.findByCustomer(customerId);
    }


}
