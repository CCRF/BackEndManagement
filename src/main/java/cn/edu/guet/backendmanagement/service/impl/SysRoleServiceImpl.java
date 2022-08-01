package cn.edu.guet.backendmanagement.service.impl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.bean.SysRoleMenu;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.mapper.SysRoleMapper;
import cn.edu.guet.backendmanagement.service.SysRoleService;
import cn.edu.guet.backendmanagement.util.SecurityUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhh
 * @version 1.0
 * @Date 2022-07-30 11:25
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public PageBean<SysRole> selectByPage(int currentPage, int pageSize) {

        int begin = (currentPage - 1) * pageSize;

        int size =pageSize;
        List<SysRole> rows = sysRoleMapper.selectByPage(begin, size);

        int totalCount = sysRoleMapper.selectTotalCount();

        PageBean<SysRole> pageBean =new PageBean<>();

        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }

    @Override
    public HttpResult deleteMsg(Long id) {

        int count1 = sysRoleMapper.count(id);

        if (count1 > 0) {
            return HttpResult.error("当前角色具有权限，无法删除");
        }


        sysRoleMapper.updateMsg(id);
        return HttpResult.ok("删除成功");
    }

    @Override
    public int addMsg(SysRole sysRole) {

        if (sysRole != null) {
            sysRole.setDelFlag((byte) 0);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            sysRole.setCreateTime(date);
            Authentication authentication = SecurityUtils.getAuthentication();
            String userName = authentication.getPrincipal().toString();
            sysRole.setCreateBy(userName);
        }


        int row = sysRoleMapper.addMsg(sysRole);
        return row;
    }

    @Override
    public List<SysMenu> getNewMsg(Long id) {
        return sysRoleMapper.getNewMsg(id);
    }

    @Override
    public HttpResult updateName(SysRole sysRole) {

        String userName = sysRole.getName();
        String remark = sysRole.getRemark();

        Long id = sysRole.getId();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        sysRole.setLastUpdateTime(date);
        Date lastUpdateTime = sysRole.getLastUpdateTime();

        Authentication authentication = SecurityUtils.getAuthentication();
        String updateName = authentication.getPrincipal().toString();
        sysRole.setLastUpdateBy(updateName);
        String lastUpdateBy = sysRole.getLastUpdateBy();

        sysRoleMapper.updateName(userName, remark, id, lastUpdateTime, lastUpdateBy);
        return HttpResult.ok();
    }

    @Override
    public HttpResult updateRoleMenu(List<String> nameList, Long id) {


        if (nameList.size()>0){

            List<SysMenu> menuId = sysRoleMapper.updateRoleMenu(nameList);


            List<Integer> rows = sysRoleMapper.selectId(id);

            if (rows.size() > 0) {

                sysRoleMapper.deleteRoleMenu(id);

            }
            sysRoleMapper.insertRoleMenu(menuId, id);

        }else {
            sysRoleMapper.deleteRoleMenu(id);
        }


        return HttpResult.ok();
    }

    @Override
    public List<SysRole> searchMsg(String msg) {
        return sysRoleMapper.searchMsg(msg);
    }

}
