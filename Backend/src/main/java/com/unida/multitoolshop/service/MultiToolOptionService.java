package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.MultiToolOption;

import java.util.List;

public interface MultiToolOptionService {
    List<MultiToolOption> getAll();
    MultiToolOption create(MultiToolOption multiToolOption);
    MultiToolOption update(MultiToolOption multiToolOption);
    void delete(Integer id);
}
