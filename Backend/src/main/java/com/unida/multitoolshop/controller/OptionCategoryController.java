package com.unida.multitoolshop.controller;


import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.model.OptionCategory;
import com.unida.multitoolshop.service.OptionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OptionCategoryController {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    OptionCategoryService optionCategoryService;

    @GetMapping("/api/option-category")
    public ResponseEntity<?> getAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            List<OptionCategory> optionCategoryList = optionCategoryService.getAll();
            responseEntity = ResponseEntity.ok(optionCategoryList);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @PostMapping("/api/option-category")
    public ResponseEntity<?> create(@RequestBody final OptionCategory optionCategory) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            OptionCategory newOptionCategory = optionCategoryService.create(optionCategory);
            responseEntity = ResponseEntity.ok(newOptionCategory);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/api/option-category/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            optionCategoryService.delete(id);
            responseEntity = ResponseEntity.ok("Successfully deleted OptionCategory");
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }
}
