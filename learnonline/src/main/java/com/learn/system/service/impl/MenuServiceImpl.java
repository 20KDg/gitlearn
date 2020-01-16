package com.learn.system.service.impl;

import com.learn.system.dao.MenuMapper;
import com.learn.system.model.Menu;
import com.learn.system.service.MenuService;
import com.learn.system.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findTree(String account, int menuType) {
        // 初始化父菜单集合
        List<Menu> sysMenus = new ArrayList<>();
        // 查询该账户拥有所有菜单
        List<Menu> menus = findByUser(account);
        for (Menu menu : menus) {
            // 如果没有parentId，则判定为子菜单
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if(!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1, o2) -> o1.getOrder().compareTo(o2.getOrder()));
        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    @Override
    public List<Menu> findByUser(String account) {
        // 如果是超级管理员，则查询全部菜单
        if(account == null || "".equals(account) || ConstantUtils.ADMIN.equalsIgnoreCase(account)) {
            return menuMapper.findAll();
        }
        return menuMapper.findByAccount(account);
    }

    /**
     * 根据父菜单查询对应子菜单
     *
     * @param sysMenus 父菜单集合
     * @param menus 所有菜单
     * @param menuType
     */
    private void findChildren(List<Menu> sysMenus, List<Menu> menus, int menuType) {
        // 遍历父菜单
        for (Menu sysMenu : sysMenus) {
            List<Menu> children = new ArrayList<>();
            // 遍历所有菜单
            for (Menu menu : menus) {
                if(menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue ;
                }
                if (menu.getId() != null && sysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentId(sysMenu.getId());
                    menu.setLevel(sysMenu.getLevel() + 1);
                    if(!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrder().compareTo(o2.getOrder()));
            findChildren(children, menus, menuType);
        }
    }

    private boolean exists(List<Menu> sysMenus, Menu sysMenu) {
        boolean exist = false;
        for(Menu menu:sysMenus) {
            if(menu.getId().equals(sysMenu.getId())) {
                exist = true;
            }
        }
        return exist;
    }
}
