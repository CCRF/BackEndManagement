package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.SysCustomer;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class SysCustomerController {

    @Autowired
    private SysCustomerService scs;

    @RequestMapping("/getAll")
    public HttpResult getAllCustomer(){
        List<SysCustomer> list = scs.getAllCustomer();
        return HttpResult.ok(list);
    }

}
