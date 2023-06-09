package com.example.tailormate.controller;

import com.example.tailormate.model.Customers;
import com.example.tailormate.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    private final CustomersService customerService;

    @Autowired
    public CustomersController(CustomersService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Customers>> getAllCustomers() {
        List<Customers> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int id) {
        Optional<Customers> optionalCustomer = customerService.getCustomerById(id);
        if (optionalCustomer.isPresent()) {
            Customers customer = optionalCustomer.get();
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer) {
        Customers createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Customers>> updateCustomer(@PathVariable int id, @RequestBody Customers updatedCustomer) {
        Optional<Customers> optionalCustomer = customerService.getCustomerById(id);
        if (optionalCustomer.isPresent()) {
            updatedCustomer.setCustomerId(id);
            Optional<Customers> savedCustomer = customerService.updateCustomer(id,updatedCustomer);
            return ResponseEntity.ok(savedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable int id) {
        Optional<Customers> optionalCustomer = customerService.getCustomerById(id);
        if (optionalCustomer.isPresent()) {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
