package cn.edu.guet.backendmanagement.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.bean.SysUser;
import cn.edu.guet.backendmanagement.bean.SysUserRole;
import cn.edu.guet.backendmanagement.mapper.SysRoleMapper;
import cn.edu.guet.backendmanagement.mapper.SysUserMapper;
import cn.edu.guet.backendmanagement.mapper.SysUserRoleMapper;
import cn.edu.guet.backendmanagement.service.SysMenuService;
import cn.edu.guet.backendmanagement.service.SysUserService;
import cn.edu.guet.backendmanagement.util.LinuxLogin;
import cn.edu.guet.backendmanagement.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Liwei
 * @Date 2021-08-13 18:12
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private LinuxLogin linuxLogin;


    @Override
    public SysUser findByName(String name) {
        SysUser sysUser = sysUserMapper.findByName(name);
        if (sysUser != null) {
            List<SysUserRole> userRoles = findUserRoles(sysUser.getId());
            sysUser.setUserRoles(userRoles);
            sysUser.setRoleNames(getRoleNames(userRoles));
            return sysUser;
        }
        return null;
    }

    private String getRoleNames(List<SysUserRole> userRoles) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<SysUserRole> iter = userRoles.iterator(); iter.hasNext(); ) {
            SysUserRole userRole = iter.next();
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(userRole.getRoleId());
            if (sysRole == null) {
                continue;
            }
            sb.append(sysRole.getRemark());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return sysUserRoleMapper.findUserRoles(userId);
    }

    @Override
    public List<SysUser> findAllUser() {

        return sysUserMapper.findAllUser();
    }

    @Override
    public boolean deleteUserById(String id) {
        if(sysUserMapper.deleteUserById(id)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateUser(SysUser sysUser) {
        File tempFile =new File(sysUser.getAvatar().trim());
        String fileName = tempFile.getName();
        sysUser.setAvatar("https://g1.glypro19.com/img/avatar/"+fileName);
        String salt = PasswordUtils.getSalt();
        sysUser.setPassword(PasswordUtils.encode(sysUser.getPassword(),salt));
        sysUser.setSalt(salt);
        if(sysUserMapper.updateUser(sysUser)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean insertUser(SysUser sysUser) {
        File file = new File(sysUser.getAvatar().trim());
        String fileName = file.getName();
        sysUser.setAvatar("https://g1.glypro19.com/img/avatar/"+fileName);
        String salt = PasswordUtils.getSalt();
        sysUser.setPassword(PasswordUtils.encode(sysUser.getPassword(),salt));
        sysUser.setSalt(salt);
        if(sysUserMapper.insertUser(sysUser)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<SysUser> findUserById(String id) {
        return sysUserMapper.findUserById(id);
    }

    @Override
    public List<SysUser> findUserByMsg(String msg) {
        return sysUserMapper.findUserByMsg(msg);
    }

    @Override
    public List<SysUser> findUserByName(String name) {
        return sysUserMapper.findUserByName(name);
    }

    @Override
    public List<SysRole> findAllRole() {
        return sysUserMapper.findAllRole();
    }

    @Override
    public Set<String> findPermissions(String userName) {
        System.out.println("获取用户权限菜单: "+userName);
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findByUser(userName);
        for (SysMenu sysMenu : sysMenus) {
            if (sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public String uploadImage(MultipartFile image) throws IOException {
        System.out.println("开始上传");
        String filePath = "/usr/local/img/avatar/";
        String s = linuxLogin.uploadVideo(image,filePath);
        if (s!=null){
            System.out.println(s);
            System.out.println("上传成功");
        }else {
            System.out.println("上传失败");
        }
        return s;
    }



}
