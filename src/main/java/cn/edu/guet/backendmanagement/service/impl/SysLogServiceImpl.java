package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysLog;
import cn.edu.guet.backendmanagement.mapper.SysLogMapper;
import cn.edu.guet.backendmanagement.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog sysLog) {
        return sysLogMapper.save(sysLog);
    }
}
