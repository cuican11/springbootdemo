package com.hwgif.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lc.huang
 * @description
 * @date 2019/11/26
 */
@Controller
public class LoginController {

    @RequestMapping("/signin")
    public String loginHtm(){
        return "demo/login";
    }

//    @RequestMapping("/login")
////    @ResponseBody
//    public String login(){
//        return "demo/login";
//    }


}
