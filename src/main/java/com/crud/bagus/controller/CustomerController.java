package com.crud.bagus.controller;

import com.crud.bagus.model.Customer;
import com.crud.bagus.repository.CustomerRepository;
import com.crud.bagus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    List<Customer> showAllCustomer(){
        return customerRepository.findAll();
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer dataCustomer){
        Customer data = customerRepository.save(dataCustomer);
        return data;
    }

    @DeleteMapping("/delete")
    Map<String, Object> deleteCustomer(@RequestParam long id){
        Map<String, Object> response = new HashMap<>();
        if (customerService.deleteCustomer(id)){
            response.put("succsess", true);
            response.put("message", "Data sukses dihapus");
        } else {
            response.put("succsess", false);
            response.put("message", "Data gagal dihapus");
        }
        return response;
    }

    @PutMapping("/update")
    Map<String, Object> updateCustomer(@RequestBody Customer dataCustomer){
        Map<String, Object> response = new HashMap<>();
        if (customerService.updateCustomer(dataCustomer)){
            response.put("succsess", true);
            response.put("Message", "Data berhasil ditambahkan");
        } else {
            response.put("success", false);
            response.put("Message", "Data gagal ditambahkan");
        }
        return response;
    }


}
