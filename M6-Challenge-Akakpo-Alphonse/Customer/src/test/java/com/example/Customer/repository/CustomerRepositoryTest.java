package com.example.Customer.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Customer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository CusRepo;

    @BeforeEach
    public void setUp() throws Exception{
        CusRepo.deleteAll();
    }

    @Test
    public void createCustomer(){
        //Arrange
        Customer customer = new Customer();
        customer.setFirstName("Frank");
        customer.setLastName("Fofo");
        customer.setAddress1("024 Hattiesburg");
        customer.setAddress2("00233 New Orleans");
        customer.setEmail("c1@yahoo.co.uk");
        customer.setCompany("YahooYahoo");
        customer.setCity("Hattiesburg");
        customer.setState("MS");
        customer.setCountry("US");
        customer.setPostalCode("00233");
        //Act
        customer = CusRepo.save(customer);
        //Assert
        Optional<Customer> customer1 = CusRepo.findById(customer.getId());

        assertEquals(customer1.get(),customer);
    }

    @Test
    public void getCustomersByState() {
        //Arrange
        Customer customer = new Customer();
        customer.setFirstName("Frank");
        customer.setLastName("Fofo");
        customer.setAddress1("024 Hattiesburg");
        customer.setAddress2("00233 New Orleans");
        customer.setEmail("c1@yahoo.co.uk");
        customer.setCompany("YahooYahoo");
        customer.setCity("Hattiesburg");
        customer.setState("MS");
        customer.setCountry("US");
        customer.setPostalCode("00233");
        //Act
        customer = CusRepo.save(customer);

        //Arrange
        Customer customer2 = new Customer();
        customer2.setFirstName("Frank");
        customer2.setLastName("Fofo");
        customer2.setAddress1("024 Hattiesburg");
        customer2.setAddress2("00233 New Orleans");
        customer2.setEmail("c1@yahoo.co.uk");
        customer2.setCompany("YahooYahoo");
        customer2.setCity("Hattiesburg");
        customer2.setState("MS");
        customer2.setCountry("US");
        customer2.setPostalCode("00233");
        //Act
        customer2 = CusRepo.save(customer2);

        List<Customer> customerList = CusRepo.findByState(customer.getState());
        assertEquals(2,customerList.size());
    }

    @Test
    public void updateCustomer(){


        //Arrange
        Customer customer = new Customer();
        customer.setFirstName("Frank");
        customer.setLastName("Fofo");
        customer.setAddress1("024 Hattiesburg");
        customer.setAddress2("00233 New Orleans");
        customer.setEmail("c1@yahoo.co.uk");
        customer.setCompany("YahooYahoo");
        customer.setCity("Hattiesburg");
        customer.setState("MS");
        customer.setCountry("US");
        customer.setPostalCode("00233");

        customer = CusRepo.save(customer);

        customer.setFirstName("NewName");

        CusRepo.save(customer);

        Optional<Customer> customer1 = CusRepo.findById(customer.getId());

        assertEquals(customer1.get(),customer);
    }


    @Test
    public void deleteCustomer(){
        //Arrange
        Customer customer = new Customer();
        customer.setFirstName("Frank");
        customer.setLastName("Fofo");
        customer.setAddress1("024 Hattiesburg");
        customer.setAddress2("00233 New Orleans");
        customer.setEmail("c1@yahoo.co.uk");
        customer.setCompany("YahooYahoo");
        customer.setCity("Hattiesburg");
        customer.setState("MS");
        customer.setCountry("US");
        customer.setPostalCode("00233");

        customer = CusRepo.save(customer);

        CusRepo.deleteById(customer.getId());

        Optional<Customer> customer1 = CusRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }
}