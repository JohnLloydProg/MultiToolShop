package com.unida.multitoolshop.controller;

import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.service.MultiToolSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MultiToolSetController {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    MultiToolSetService multiToolSetService;

    @GetMapping("/api/set")
    public ResponseEntity<?> getMultiToolSets() {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            List<MultiToolSet> multiToolSetList = multiToolSetService.getAll();
            responseEntity = ResponseEntity.ok(multiToolSetList);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/api/set/{id}")
    public ResponseEntity<?> getById(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            MultiToolSet multiToolSet = multiToolSetService.getById(id);
            responseEntity = ResponseEntity.ok(multiToolSet);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return  responseEntity;
    }

    @PostMapping("/api/set")
    public ResponseEntity<?> add(@RequestBody final MultiToolSet multiToolSet) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            MultiToolSet newMultiToolSet = multiToolSetService.create(multiToolSet);
            responseEntity = ResponseEntity.ok(newMultiToolSet);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/api/set")
    public ResponseEntity<?> update(@RequestBody final MultiToolSet multiToolSet) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            MultiToolSet newMultiToolSet = multiToolSetService.update(multiToolSet);
            responseEntity = ResponseEntity.ok(newMultiToolSet);
        }catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/api/set/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            multiToolSetService.delete(id);
            responseEntity = ResponseEntity.ok("Deleted the entity");
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }
}
