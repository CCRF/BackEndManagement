package cn.edu.guet.backendmanagement.controller;

import ch.qos.logback.core.util.FileUtil;
import cn.edu.guet.backendmanagement.bean.SysCustomer;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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

    @RequestMapping("/rank")
    public HttpResult getTop3(){
        List<SysCustomer> all = scs.getTop3();
        SysCustomer[] s = new SysCustomer[3];

        //1、找出前三名
        s[0] = all.get(0);
        s[1] = all.get(1);
        s[2] = all.get(2);
        Arrays.sort(s,(x, y)->{
            return Double.compare(y.getSum(),x.getSum());
        });

        for (int i = 3;i < all.size(); i ++){
            SysCustomer t = all.get(i);
            if (t.getSum() > s[0].getSum()){
                s[0] = t;
            }else if (t.getSum() > s[1].getSum()){
                s[1] = t;
            }else if (t.getSum() > s[2].getSum()){
                s[2] = t;
            }
        }

        return HttpResult.ok(s);
    }
}
