package com.example.Customer.controller;

import com.example.Customer.model.Customer;
import com.example.Customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository CusRepo;

    //Get customer by id
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        Optional<Customer> val = CusRepo.findById(id);
        if(val.isPresent()){
            return val.get();
        }else{
            return null;
        }
    }



    //Get customers by state
    @GetMapping("/customers/{state}")
    public List<Customer> getCustomerByState(@PathVariable String state){
        return CusRepo.findByState(state);
    }




    //Create new customer
    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return CusRepo.save(customer);
    }




    //Update an existing customer
    @PutMapping("/customer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer){
        CusRepo.save(customer);
    }



    //Delete an existing Customer
    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id){
        CusRepo.deleteById(id);
    }









}
