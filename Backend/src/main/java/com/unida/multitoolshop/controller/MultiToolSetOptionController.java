package com.unida.multitoolshop.controller;

import com.unida.multitoolshop.model.SetOption;
import com.unida.multitoolshop.service.SetOptionService;
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
    SetOptionService setOptionService;

    @GetMapping("/api/set-option")
    public ResponseEntity<?> getAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            List<SetOption> setOptionList = setOptionService.getAll();
            responseEntity = ResponseEntity.ok(setOptionList);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/api/set-option/set/{setId}")
    public ResponseEntity<?> getAllBySetid(@PathVariable final int setId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            List<SetOption> setOptionList = setOptionService.getAllBySetId(setId);
            responseEntity = ResponseEntity.ok(setOptionList);
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
            SetOption setOption = setOptionService.getById(id);
            responseEntity = ResponseEntity.ok(setOption);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }

    @PostMapping("/api/set-option")
    public ResponseEntity<?> create(@RequestBody final SetOption setOption) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            SetOption newSetOption = setOptionService.create(setOption);
            responseEntity = ResponseEntity.ok(newSetOption);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/api/set-option")
    public ResponseEntity<?> update(@RequestBody final SetOption setOption) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<?> responseEntity;
        try {
            SetOption newSetOption = setOptionService.update(setOption);
            responseEntity = ResponseEntity.ok(newSetOption);
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
            setOptionService.delete(id);
            responseEntity = ResponseEntity.ok("Successfully deleted");
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return responseEntity;
    }
}
