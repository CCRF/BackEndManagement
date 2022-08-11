package cn.edu.guet.backendmanagement.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.mapper.SysMenuMapper;
import cn.edu.guet.backendmanagement.service.SysMenuService;
import cn.edu.guet.backendmanagement.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author zhh
 * @Date 2022-08-10 17:50
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findByUser(String userName) {
        if (userName == null || "".equals(userName) || "admin".equalsIgnoreCase(userName)) {
            return sysMenuMapper.findAll();
        }
        List<SysMenu> sysMenus = sysMenuMapper.findByUserName(userName);
        System.out.println("findByUserName " + sysMenus);
        return sysMenus;
    }

    @Override
    public List<SysMenu> findTree(String userName, int menuType) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = findByUser(userName);
        for (SysMenu menu : menus) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if (!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus, menus, menuType);

        System.out.println("最后 " + sysMenus);
        return sysMenus;
    }

    @Override
    public List<SysMenu> searchMsg(String msg) {

        return sysMenuMapper.searchMsg(msg);
    }

    private void findChildren(List<SysMenu> SysMenus, List<SysMenu> menus, int menuType) {
        for (SysMenu SysMenu : SysMenus) {
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus) {
                if (menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if (SysMenu.getId() != null && SysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(SysMenu.getName());
                    menu.setLevel(SysMenu.getLevel() + 1);
                    if (!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            SysMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menus, menuType);
        }
    }

    private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
        boolean exist = false;
        for (SysMenu menu : sysMenus) {
            if (menu.getId().equals(sysMenu.getId())) {
                exist = true;
            }
        }
        return exist;
    }



    @Override
    public HttpResult deleteMsg(Long id) {

        List<SysMenu> sysMenuList = sysMenuMapper.count();

        for (int i = 0; i < sysMenuList.size(); i++) {
            if (id == sysMenuList.get(i).getParentId()) {
                return HttpResult.error("该菜单具有子菜单，无法删除！！！");
            }
        }

        sysMenuMapper.deleteMsg(id);


        return HttpResult.ok("删除成功");
    }

    @Override
    public int addMsg(SysMenu sysMenu) {

        if (sysMenu != null) {
            if (sysMenu.getType() != 0 && sysMenu.getType() != 1) {
                sysMenu.setOrderNum(0);
            } else {
                sysMenu.setOrderNum(5);
            }
            sysMenu.setDelFlag((byte) 0);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            sysMenu.setCreateTime(date);
            Authentication authentication = SecurityUtils.getAuthentication();
            String userName = authentication.getPrincipal().toString();
            sysMenu.setCreateBy(userName);
        }


        int row = sysMenuMapper.addMsg(sysMenu);
        return row;
    }

    @Override
    public HttpResult updateName(SysMenu sysMenu) {

        String name = sysMenu.getName();
        String url = sysMenu.getUrl();

        Long id = sysMenu.getId();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        sysMenu.setLastUpdateTime(date);
        Date lastUpdateTime = sysMenu.getLastUpdateTime();

        Authentication authentication = SecurityUtils.getAuthentication();
        String updateName = authentication.getPrincipal().toString();
        sysMenu.setLastUpdateBy(updateName);
        String lastUpdateBy = sysMenu.getLastUpdateBy();

        sysMenuMapper.updateName(name, url, id, lastUpdateTime, lastUpdateBy);
        return HttpResult.ok();
    }
}
