package com.deliverybusiness.service;
import com.deliverybusiness.Dao.ICustomerDao;
import com.deliverybusiness.Dao.IOrderDao;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.Customer;
import com.deliverybusiness.model.Orders;
import com.deliverybusiness.model.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerDao iCustomerDao;
    @Autowired
    private IOrderDao iOrderDao;

    public CustomerServiceImpl() {
    }
    public CustomerServiceImpl(ICustomerDao iCustomerDao) {
    }
    public CustomerServiceImpl(IOrderDao iOrderDao) {
        this.iOrderDao = iOrderDao;
    }

    public CustomerServiceImpl(ICustomerDao iCustomerDao, IOrderDao iOrderDao) {
        this.iCustomerDao = iCustomerDao;
        this.iOrderDao= iOrderDao;
    }

    @Override
    public Page<Customer> findAll(Pageable page) {
        return this.iCustomerDao.findAll(page);
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> optional = this.iCustomerDao.findById(id); /* checks if City with particular id exist.
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
    public Customer addCustomer(Customer customer) {
        return this.iCustomerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        Customer customerDb = findById(id); //trazimo klijenta sa specificnim Id
        customerDb.setFullName(customer.getFullName());
        customerDb.setAddress(customer.getAddress());
        customerDb.setCity(customer.getCity());
        return this.iCustomerDao.save(customerDb);

    }

    @Override
    public List<Customer> findByFullName(String name) {
        return this.iCustomerDao.findByFullName(name);
    }

    @Override
    public List<Customer> findByCityAndAddress(String address, String name) {
        return this.iCustomerDao.findByCityAndAddress(address,name);
    }

    @Override
    public Customer updateCustomerName(String address, String name, CustomerDTO customerDTO) {
        List<Customer> customerList = findByCityAndAddress(address,name);
        if(customerList.size() > 0){
            String fullName = customerDTO.getFirstName() + " " + customerDTO.getLastName();
            customerList.get(0).setFullName(fullName);
           return this.iCustomerDao.save(customerList.get(0));
        }
        return null;
    }

    @Override
    public List<Customer> findCustomerByOrder(double price) {
        return this.iOrderDao.findCustomerByOrder(price);
    }

    @Override
    public List<Orders> findByCustomer(int customerId) {
        Customer customer = this.findById(customerId);
        return this.iOrderDao.findByCustomer(customer);
    }

}
