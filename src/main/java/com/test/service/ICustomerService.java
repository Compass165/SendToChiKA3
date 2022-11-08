package com.test.service;

import com.test.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer add(Customer customer);

    Customer findById(int id);
}