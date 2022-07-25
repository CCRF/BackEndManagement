package cn.edu.guet.backendmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/admin/login")
    public String login(){
        return "loginTest";
    }
}
