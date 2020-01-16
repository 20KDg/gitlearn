package com.learn.system.service;

import com.learn.system.model.Menu;

import java.util.List;

/**
 * 菜单管理
 *
 */
public interface MenuService {

    /**
     * 查询菜单树,用户ID和用户名为空则查询全部
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @param account
     * @return
     */
    List<Menu> findTree(String account, int menuType);

    /**
     * 根据用户名查找菜单列表
     * @param account
     * @return
     */
    List<Menu> findByUser(String account);
}
