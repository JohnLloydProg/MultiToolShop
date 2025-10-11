package com.unida.multitoolshop.service;

import java.util.List;

public interface MenuService {
    List<Menu> getMenus();
    Menu create(Menu menu);
}
