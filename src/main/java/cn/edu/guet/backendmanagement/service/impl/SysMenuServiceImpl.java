package cn.edu.guet.backendmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.mapper.SysMenuMapper;
import cn.edu.guet.backendmanagement.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Liwei
 * @Date 2021-08-13 18:12
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
    public PageBean<SysMenu> findAll(int currentPage, int pageSize) {
        int begin = (currentPage - 1) * pageSize;

        int size = pageSize;
        List<SysMenu> rows = sysMenuMapper.selectByPage(begin, size);

        int totalCount = sysMenuMapper.selectTotalCount();

        PageBean<SysMenu> pageBean = new PageBean<>();

        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        return pageBean;
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
}
