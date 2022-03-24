package com.hwgif;

import com.hwgif.common.CommonResult;
import com.hwgif.configure.security.UserEntity;
import com.hwgif.demo.bean.User;

public class TestMain {

    public static void main(String[] args) {
        TestMain tt = new TestMain();
        UserEntity enty = new UserEntity();
        enty.setPhone("111");
        tt.test(enty);
        System.out.println(enty.toString());
    }


    public CommonResult test(UserEntity entity){
          entity.setPhone("121");
        return CommonResult.successResult();
    }
}
