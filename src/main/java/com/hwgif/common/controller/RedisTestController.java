package com.hwgif.common.controller;


import com.hwgif.common.CommonResult;
import com.hwgif.common.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Thread.sleep;

@RestController
@RequestMapping("/public/test")
public class RedisTestController {

    @GetMapping("/redis")
    public CommonResult redis(){
        RedisUtil.set("doubi","11");
        return CommonResult.successResult(RedisUtil.get("doubi"));
    }

    @GetMapping("/redis/lock")
    public CommonResult redisgetlock() throws InterruptedException {

        new Thread(new Runnable() {
             @Override
             public void run() {
                RedisUtil.getLock("testlock","cpdd",30000);
             }
         }).start();
            sleep(4000);
        return CommonResult.successResult(RedisUtil.getLock("testlock","cpmm",30000));
    }
}
