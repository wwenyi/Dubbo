package com.wwy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwy.entry.APIEntry;
import com.wwy.entry.User;
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
	public APIEntry login(User user,HttpServletRequest request,HttpServletResponse response) {
		return service.login(user,request,response);
		
	}
	
}
