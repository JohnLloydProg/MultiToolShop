package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.MultiToolSetOption;

import java.util.List;

public interface MultiToolSetOptionService {
    List<MultiToolSetOption> getAllBySetId(int setId);
    MultiToolSetOption getById(int  id);
    MultiToolSetOption create(MultiToolSetOption multiToolSetOption);
    MultiToolSetOption update(MultiToolSetOption multiToolSetOption);
    void delete(int  setOptionId);
}
