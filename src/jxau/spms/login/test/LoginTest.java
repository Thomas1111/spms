package jxau.spms.login.test;

import java.util.HashMap;

import jxau.spms.login.service.LoginService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;

public class LoginTest {

	@Test
	public void testLogin(){
		ClassPathXmlApplicationContext actionContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService loginService = (LoginService) actionContext.getBean("loginService");
		HashMap<String, Object> params = new HashMap<>();
		params.put("account", "0791");
		params.put("password", "123456");
		System.out.print(loginService.identifyUser(3, params));
	}
}
