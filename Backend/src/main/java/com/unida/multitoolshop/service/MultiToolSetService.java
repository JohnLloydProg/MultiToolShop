package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.MultiToolSet;

import java.util.List;

public interface MultiToolSetService {
    List<MultiToolSet> getAll();
    MultiToolSet getById(int id);
    MultiToolSet create(MultiToolSet multiToolSet);
    MultiToolSet update(MultiToolSet multiToolSet);
    void delete(int id);
}
