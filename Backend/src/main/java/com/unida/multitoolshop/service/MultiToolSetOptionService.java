package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.model.MultiToolSetOption;

import java.util.List;

public interface MultiToolSetOptionService {
    List<MultiToolSetOption> getAllBySet(MultiToolSet multiToolSet);
    MultiToolSetOption getById(Integer Id);
    MultiToolSetOption create(MultiToolSetOption multiToolSetOption);
    MultiToolSetOption update(MultiToolSetOption multiToolSetOption);
    void delete(Integer id);
}
