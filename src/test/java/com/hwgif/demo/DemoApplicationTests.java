package com.hwgif.demo;

import com.hwgif.demo.bean.SysUser;
import com.hwgif.demo.service.SysUserService;
import com.hwgif.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	SysUserService sysUserService;

	@Test
	void contextLoads() {
		SysUser sysUser = sysUserService.getLoadUserByName(1);
	}

}
