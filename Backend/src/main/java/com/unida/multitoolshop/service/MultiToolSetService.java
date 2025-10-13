package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.MultiToolSet;

import java.util.List;

public interface MultiToolSetService {
    List<MultiToolSet> getAll();
    MultiToolSet getById(Integer id);
    MultiToolSet create(MultiToolSet multiToolSet);
    MultiToolSet update(MultiToolSet multiToolSet);
    void delete(Integer id);
}
