package com.unida.multitoolshop.controller;

import com.unida.multitoolshop.model.Order;
import com.unida.multitoolshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    OrderService orderService;

    @GetMapping("/api/orders/{customerId}")
    public ResponseEntity<?> getAllByCustomerId(@PathVariable final int customerId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            List<Order> orderList = orderService.getAllByCustomerId(customerId);
            responseEntity = ResponseEntity.ok(orderList);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/api/order/{id}")
    public  ResponseEntity<?> getById(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            Order order = orderService.getById(id);
            responseEntity = ResponseEntity.ok(order);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @PostMapping("/api/order")
    public ResponseEntity<?> create(@RequestBody final Order order) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            Order newOrder = orderService.create(order);
            responseEntity = ResponseEntity.ok(newOrder);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/api/order")
    public ResponseEntity<?> update(@RequestBody final Order order) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            Order newOrder = orderService.update(order);
            responseEntity = ResponseEntity.ok(newOrder);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/api/order/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            orderService.delete(id);
            responseEntity = ResponseEntity.ok("Order deleted");
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

}
