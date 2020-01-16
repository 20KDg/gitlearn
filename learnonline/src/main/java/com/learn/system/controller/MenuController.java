package com.learn.system.controller;

import com.learn.system.model.Menu;
import com.learn.system.service.MenuService;
import com.learn.system.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

//    @PostMapping(value="/save")
//    public HttpResult save(@RequestBody SysMenu record) {
//        return HttpResult.ok(sysMenuService.save(record));
//    }
//
//    @PostMapping(value="/delete")
//    public HttpResult delete(@RequestBody List<SysMenu> records) {
//        return HttpResult.ok(sysMenuService.delete(records));
//    }

        @GetMapping(value="/findNavTree")
    public ResponseEntity<Map<String, Object>> findNavTree(@RequestParam String userName) {
        Map map = new HashMap();
        List<Menu> navTree = menuService.findTree(userName, ConstantUtils.MUNE_TYPE_MENU);
        map.put("navTree", navTree);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping(value="/findMenuTree")
    public ResponseEntity<Map<String, Object>> findMenuTree() {
        Map map = new HashMap();
        List<Menu> menuTree = menuService.findTree(null, ConstantUtils.MUNE_TYPE_NAV);
        map.put("menuTree", menuTree);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
