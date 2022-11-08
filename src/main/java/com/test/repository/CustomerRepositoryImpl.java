package com.test.repository;

import com.test.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements ICustomerRepository{
    private static final Map<Integer, Customer> customers;

    static {

        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Hoang", "Kien"));
        customers.put(2, new Customer(2, "Lam", "Thai"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer add(Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }
}