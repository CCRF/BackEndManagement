package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysOrder;
import cn.edu.guet.backendmanagement.http.HttpResult;

import java.util.List;

/**
 * @author HJK
 * @date 2022/8/13 23:39
 * @Version 1.0
 */

public interface SysWxOrderService {

    List<SysOrder> getCurrentOrder();
    List<SysOrder> getHistoryOrder();

    HttpResult moderOrderState(String id,int state);

}
