package com.hwgif.demo;

import com.hwgif.demo.bean.SysUser;
import com.hwgif.demo.service.SysUserService;
import com.hwgif.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	SysUserService sysUserService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		SysUser sysUser = sysUserService.getLoadUserByName("xccint");
		System.out.printf(sysUser.toString());
	}

	@Test
	void bcryptPasswordEncoder(){
		String password = "admin";
		System.out.println(password + ": encrypt");
					String hashedPassword = passwordEncoder.encode(password);
			System.out.println("hashedPassword:" + hashedPassword);
		int i = 0;
		while(i < 10){

//			String hashedPassword = passwordEncoder.encode(password);
//			System.out.println("hashedPassword:" + hashedPassword);

			System.out.println("match result:" + passwordEncoder.matches(password,"$2a$04$8zW2TI2odq58czgW45HXAO57U7UYQr2UTl19Bv5MCli7b6VjK/VN6"));
			i ++;
		}
	}



}
