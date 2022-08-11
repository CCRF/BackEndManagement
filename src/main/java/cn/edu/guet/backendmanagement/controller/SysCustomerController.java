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

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public HttpResult upload(@RequestParam("name") String name,
                             HttpServletRequest request){
        System.out.println("upload....");
        System.out.println(name);

//        String originalFilename = file.getOriginalFilename();
//        String type = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
//        String filePath = "/usr/local/img/"; // 存储到linux这个目录下
//
//        // 先存储到磁盘
//        File uploadParentFile = new File(filePath);
//        if (!uploadParentFile.exists()){
//            uploadParentFile.mkdirs();
//        }
//
//        // 定义一个文件唯一标识码
////        String uuid = IdUtil.fastSimpleUUID();
//        String saveUrl = filePath + originalFilename;
//        System.out.println("保存的路径 " + saveUrl);
//        File uploadFile = new File(saveUrl);
//
//        try {
//            file.transferTo(uploadFile);
//            System.out.println("上传成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @RequestMapping(value = "/test")
    public HttpResult test(){
        System.out.println("test....");

        return null;
    }

}
