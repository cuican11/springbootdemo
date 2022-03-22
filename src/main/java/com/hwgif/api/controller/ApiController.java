package com.hwgif.api.controller;

import com.hwgif.common.CommonResult;
import com.hwgif.demo.bean.User;
import com.hwgif.demo.service.UserService;
import com.hwgif.demotwo.bean.UserNd;
import com.hwgif.demotwo.service.UserNdService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lc.huang on 2019/11/18.
 * Description
 */
@Api(value = "demo接口", description = "demo接口", position = 1)
@RestController
public class ApiController {

    @Autowired
    UserService userService;
    @Autowired
    UserNdService userServiceT;

    @ApiOperation(value = "demo接口", notes = "demo接口", httpMethod = "GET", position = 1)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "返回值结构", response = String.class)})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "goodsType", value = "qweqweq", required = true, dataType =
                    "String")
    })
    @PreAuthorize("hasAnyAuthority('a')")
    @RequestMapping("hallo")
    public CommonResult halloword(HttpServletRequest request , HttpSession session , @RequestParam(value = "goodsType",
            required =
            true) String
            goodsType) throws Exception{

     //   int i = 1/0;

        User user = new User();
        user.setPhone("12345678901");
        user.setEmail("qq.com");
        user.setName("momo");
        user.setPassword("123");
        user.setSalt("ss");
        user.setStatus("1");
//        userService.insertUser(user);
//        User user = userService.find(1);
        return CommonResult.successResult(user.toString());
    }

}
