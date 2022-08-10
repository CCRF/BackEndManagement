package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SysLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLogMapper {
    int save(SysLog sysLog);
}
