package cn.edu.guet.backendmanagement.service.impl;

import java.util.List;

import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.mapper.SysRoleMapper;
import cn.edu.guet.backendmanagement.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Liwei
 * @Date 2021-08-13 18:12
 */
@Service
public class SysRoleServiceImpl  implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRole> findAll() {
		return sysRoleMapper.findAll();
	}
	
}
