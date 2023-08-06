package com.example.Customer.controller;



import com.example.Customer.model.Customer;
import com.example.Customer.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;


@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @MockBean

    private CustomerRepository crepo;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldGetByState() throws Exception {
        mockMvc.perform(get("/customers/VA"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCustomerById() throws Exception{
        mockMvc.perform(get("/customer/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/customer/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldCreateCustomer() throws Exception{
        Customer customer = new Customer();

        customer.setFirstName("Alphonse");
        customer.setLastName("Akakpo");
        customer.setAddress1("397 Apeyime");
        customer.setAddress2("181 Pentecost");
        customer.setEmail("moi@email.com");
        customer.setCompany("Asher Cold Store");
        customer.setCity("Hollywood");
        customer.setState("VA");
        customer.setCountry("US");
        customer.setPostalCode("22314");

        String input = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customer")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }


}
