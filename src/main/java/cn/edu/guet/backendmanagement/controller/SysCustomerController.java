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
import java.util.Collections;
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
        Collections.sort(all,(x, y)->{
            return Double.compare(y.getSum(),x.getSum());
        });

        return HttpResult.ok(all);
    }
}
