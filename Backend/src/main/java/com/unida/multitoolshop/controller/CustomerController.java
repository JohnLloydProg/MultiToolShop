package com.unida.multitoolshop.controller;

import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    CustomerService customerService;

    @GetMapping("/api/customer/{id}")
    public ResponseEntity<?> getById(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            Customer customer = customerService.getById(id);
            responseEntity = ResponseEntity.ok(customer);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return  responseEntity;
    }

    @GetMapping("/api/customer")
    public ResponseEntity<?> login(@RequestHeader("password") String password, @RequestHeader("email") String email) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            Customer customer = customerService.getByEmailPassword(email, password);
            responseEntity = ResponseEntity.ok(customer);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return  responseEntity;
    }

    @PostMapping("/api/customer")
    public ResponseEntity<?> create(@RequestBody final Customer customer) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            Customer newCustomer = customerService.create(customer);
            responseEntity = ResponseEntity.ok(newCustomer);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/api/customer")
    public ResponseEntity<?> update(@RequestBody final Customer customer) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            Customer newCustomer = customerService.update(customer);
            responseEntity = ResponseEntity.ok(newCustomer);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/api/customer/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            customerService.delete(id);
            responseEntity = ResponseEntity.ok("Deleted the Customer");
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }
}
