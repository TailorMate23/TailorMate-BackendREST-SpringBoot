package com.example.tailormate.service;

import com.example.tailormate.model.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomersService {
    List<Customers> getAllCustomers();

    Optional<Customers> getCustomerById(int id);

    Customers createCustomer(Customers customer);

    Optional<Customers> updateCustomer(int id, Customers updatedCustomer);

    boolean deleteCustomer(int id);
}
