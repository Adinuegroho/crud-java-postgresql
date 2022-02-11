package com.crud.bagus.service;

import com.crud.bagus.model.Customer;
import com.crud.bagus.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public boolean deleteCustomer(long id){
        Customer customer;
        customer = customerRepository.findById(id);
        if (customer != null){
            customerRepository.delete(customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateCustomer(Customer data){
        Customer customer;
        customer = customerRepository.findById(data.getId());
        if (customer != null){
            customerRepository.save(data);
            return true;
        } else {
            return false;
        }
    }

}
