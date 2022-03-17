package com.hwgif.admin.controller;

import com.hwgif.configure.security.UserEntity;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
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

    @PreAuthorize("hasAuthority('0003')")
    @GetMapping("/demo")
    public String demoView(Model model, @AuthenticationPrincipal UserEntity userDetails){

        model.addAttribute("user",  userDetails.getUsername()+":"+userDetails.getPhone());
        model.addAttribute("time","2019年11月18日18:02:01");
        model.addAttribute("action","ljj");
        return "demo/demo";
    }


}
