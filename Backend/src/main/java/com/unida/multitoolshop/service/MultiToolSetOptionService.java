package com.unida.multitoolshop.service;

import com.unida.multitoolshop.entity.SetOptionId;
import com.unida.multitoolshop.model.MultiToolSet;
import com.unida.multitoolshop.model.MultiToolSetOption;

import java.util.List;

public interface MultiToolSetOptionService {
    List<MultiToolSetOption> getAllBySet(MultiToolSet multiToolSet);
    MultiToolSetOption getById(SetOptionId  setOptionId);
    MultiToolSetOption create(MultiToolSetOption multiToolSetOption);
    MultiToolSetOption update(MultiToolSetOption multiToolSetOption);
    void delete(SetOptionId  setOptionId);
}
