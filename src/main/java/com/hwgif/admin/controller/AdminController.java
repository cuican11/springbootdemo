package com.hwgif.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lc.huang on 2019/11/18.
 * Description
 */

@Controller
public class AdminController {

    @GetMapping("/demo")
    public String demoView(Model model){
        model.addAttribute("user","小明同学");
        model.addAttribute("time","2019年11月18日18:02:01");
        model.addAttribute("action","ljj");
        return "demo/demo";
    }
}
