package com.hwgif.demo;

import com.hwgif.common.util.RedisUtil;
import com.hwgif.demo.bean.SysUser;
import com.hwgif.demo.service.SysUserService;
import com.hwgif.demo.service.UserService;
import com.hwgif.designpattern.strategypattern.BeanUtil;
import com.hwgif.designpattern.strategypattern.Strategy;
import com.hwgif.designpattern.strategypattern.StrategyContext;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.hwgif.designpattern.strategypattern.impl.*;


import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
class DemoApplicationTests {

	@Autowired
	SysUserService sysUserService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;



	@Test
	void contextLoads() {
		SysUser sysUser = sysUserService.getLoadUserByName("xccint");
//		System.out.printf(sysUser.toString());
	}
//
	@Test
	void bcryptPasswordEncoder(){
		String password = "123456";
		System.out.println(password + ": encrypt");
//					String hashedPassword = passwordEncoder.encode(password);
//			System.out.println("hashedPassword:" + hashedPassword);
		int i = 0;
		while(i < 10){

			String hashedPassword = passwordEncoder.encode(password);
			System.out.println("hashedPassword:" + hashedPassword);

			System.out.println("match result:" + passwordEncoder.matches(password,"$2a$04$92HXiu7lcBqZ3E7sdXPmpON/xyAiEjuWhG/QX6iaz0N24Yf1xZsPG"));
			i ++;
		}
	}

	@Test
	void jedisTest(){
//		Strategy strategy = (Strategy) BeanUtil.getBean("operationAdd");
//		System.out.println(BeanUtil.getBean("addStrategy","2"));
//		StrategyContext context = new StrategyContext(strategy);
//		Integer add =  context.executeStrategy(1,2);
//		System.out.println(add);

	}

}
