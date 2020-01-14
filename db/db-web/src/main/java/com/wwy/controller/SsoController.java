package com.wwy.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.wwy.entry.APIEntry;
import com.wwy.entry.Car;
import com.wwy.entry.User;
import com.wwy.service.CarService;
import com.wwy.service.SsoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 单点登录的Controller
 * @author wwy
 * @ClassName com.wwy.controller.SsoController.java
 * @date 2020年1月14日  上午10:41:18
 * @version v0.0.1
 *
 */
@Api(tags = "单点登录")
@RestController
@RequestMapping("sso")
public class SsoController {
	@Reference(timeout = 3000,check = false)
	private SsoService service;

	/**
	 * 登录方法
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation("登录")
	@PostMapping("login")
	public APIEntry login(@RequestBody User user,HttpServletResponse response) {

		
		APIEntry entry = service.login(user);
		String token=(String) entry.getData();
		Cookie cookie=new Cookie("TOKEN",token);
		//cookie.setDomain("db.com");
		cookie.setPath("/");
		cookie.setMaxAge(1000*60*60);
		response.addCookie(cookie);
		return entry;
	}
	
	


	
}
