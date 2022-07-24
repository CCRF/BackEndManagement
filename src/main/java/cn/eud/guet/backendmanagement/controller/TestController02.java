package cn.eud.guet.backendmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class TestController02 {

    @RequestMapping("/admin/login2")
    public String login2(){
        return "loginTest2";
    }
}
