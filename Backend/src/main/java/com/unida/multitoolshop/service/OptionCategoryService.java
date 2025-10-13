package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.OptionCategory;

import java.util.List;

public interface OptionCategoryService {
    List<OptionCategory> getAll();
    OptionCategory create(OptionCategory optionCategory);
    void delete(Integer id);
}
