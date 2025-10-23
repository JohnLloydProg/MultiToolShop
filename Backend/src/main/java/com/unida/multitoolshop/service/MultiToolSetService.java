package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.MultiToolSet;
import org.apache.xpath.operations.Mult;

import java.util.List;

public interface MultiToolSetService {
    List<MultiToolSet> getAll();
    List<MultiToolSet> getMostPopular(int length);
    MultiToolSet getById(int id);
    MultiToolSet create(MultiToolSet multiToolSet);
    MultiToolSet update(MultiToolSet multiToolSet);
    void delete(int id);
}
