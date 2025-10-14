package com.unida.multitoolshop.controller;

import com.unida.multitoolshop.model.MultiToolSetOption;
import com.unida.multitoolshop.service.MultiToolSetOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MultiToolSetOptionController {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    MultiToolSetOptionService multiToolSetOptionService;

    @GetMapping("/api/set-option/set/{setId}")
    public ResponseEntity<?> getAll(@PathVariable final int setId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            List<MultiToolSetOption> multiToolSetOptionList = multiToolSetOptionService.getAllBySetId(setId);
            responseEntity = ResponseEntity.ok(multiToolSetOptionList);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/api/set-option/{id}")
    public ResponseEntity<?> getById(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            MultiToolSetOption multiToolSetOption = multiToolSetOptionService.getById(id);
            responseEntity = ResponseEntity.ok(multiToolSetOption);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }

    @PostMapping("/api/set-option")
    public ResponseEntity<?> create(@RequestBody final MultiToolSetOption multiToolSetOption) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            MultiToolSetOption newMultiToolSetOption = multiToolSetOptionService.create(multiToolSetOption);
            responseEntity = ResponseEntity.ok(newMultiToolSetOption);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/api/set-option")
    public ResponseEntity<?> update(@RequestBody final MultiToolSetOption multiToolSetOption) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            MultiToolSetOption newMultiToolSetOption = multiToolSetOptionService.update(multiToolSetOption);
            responseEntity = ResponseEntity.ok(newMultiToolSetOption);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/api/set-option/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            multiToolSetOptionService.delete(id);
            responseEntity = ResponseEntity.ok("Successfully deleted");
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }
}
