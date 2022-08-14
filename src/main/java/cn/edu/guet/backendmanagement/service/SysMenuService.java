package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.http.HttpResult;

import java.util.List;


/**
 * 菜单管理
 *
 * @version 1.0
 * @Author zhh
 * @Date 2022-08-10 17:50
 */
public interface SysMenuService {
    /**
     * 根据用户名查找菜单列表
     *
     * @param userName
     * @return
     */
    List<SysMenu> findByUser(String userName);

    /**
     * 查询菜单树,用户ID和用户名为空则查询全部
     *
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @param userName
     * @return
     */
    List<SysMenu> findTree(String userName, int menuType);

    List<SysMenu> searchMsg(String msg);

    HttpResult deleteMsg(Long id);

    int addMsg(SysMenu sysMenu);

    HttpResult updateName(SysMenu sysMenu);
}
