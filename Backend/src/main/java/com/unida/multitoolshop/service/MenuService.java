package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenus();
    Menu create(Menu menu);
}
