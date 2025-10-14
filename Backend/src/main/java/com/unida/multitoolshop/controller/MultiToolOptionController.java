package com.unida.multitoolshop.controller;

import com.unida.multitoolshop.model.MultiToolOption;
import com.unida.multitoolshop.service.MultiToolOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MultiToolOptionController {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    MultiToolOptionService multiToolOptionService;


    @GetMapping("/api/option")
    public ResponseEntity<?> getAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            List<MultiToolOption> multiToolOptionList = multiToolOptionService.getAll();
            responseEntity = ResponseEntity.ok(multiToolOptionList);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @PostMapping("/api/option")
    public ResponseEntity<?> create(@RequestBody final MultiToolOption multiToolOption) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            MultiToolOption newMultiToolOption = multiToolOptionService.create(multiToolOption);
            responseEntity = ResponseEntity.ok(newMultiToolOption);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/api/option")
    public ResponseEntity<?> update(@RequestBody final MultiToolOption multiToolOption) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            MultiToolOption newMultiToolOption = multiToolOptionService.update(multiToolOption);
            responseEntity = ResponseEntity.ok(newMultiToolOption);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/api/option/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            multiToolOptionService.delete(id);
            responseEntity = ResponseEntity.ok("Successfully deleted MultiToolOption");
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

}
