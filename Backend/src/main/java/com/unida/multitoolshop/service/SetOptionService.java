package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.SetOption;

import java.util.List;

public interface SetOptionService {
    List<SetOption> getAll();
    List<SetOption> getAllBySetId(int setId);
    SetOption getById(int  id);
    SetOption create(SetOption setOption);
    SetOption update(SetOption setOption);
    void delete(int  setOptionId);
}
