package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysWxOrderService;
import cn.edu.guet.backendmanagement.mapper.SysWxOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HJK
 * @date 2022/8/13 23:44
 * @Version 1.0
 */
@Service
public class SysWxOrderServiceImpl implements SysWxOrderService{

    @Autowired
    private SysWxOrderMapper sysWxOrderMapper;

    @Override
    public HttpResult moderOrderState(String id,int state){
        int i=sysWxOrderMapper.moderOrderState(id,state);
        System.out.println("影响了" + i + "个");
        return i>0 ? HttpResult.ok("退单成功") : HttpResult.ok("退单失败了");
    }

}
