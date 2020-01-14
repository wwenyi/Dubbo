package com.wwy.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.wwy.entry.APIEntry;
import com.wwy.entry.User;
import com.wwy.mapper.SsoMapper;
import com.wwy.service.SsoService;
import com.wwy.util.JwtHelper;
import com.wwy.util.MD5Util;
/**
 * 单点登录的业务层代码
 * @author wwy
 * @ClassName com.wwy.service.impl.SsoServiceImpl.java
 * @date 2020年1月14日  上午11:18:01
 * @version v0.0.1
 *
 */
@Service//阿里巴巴的注解
public class SsoServiceImpl implements SsoService{
	@Autowired
	private SsoMapper mapper;
	/**
	 * 登录方法
	 */
	@Override
	public APIEntry login(User user, HttpServletRequest request, HttpServletResponse response) {
		//1、参数校验
		String username=null;
		String password=null;
		if(user!=null) {
			username=user.getUserName();
			password=user.getPassWord();
		}
		if(user==null||StringUtils.isEmpty(username)||StringUtils.isEmpty(password)) {
			return APIEntry.ERROR("请完善用户信息");
		}
	//2、查询用户信息
		//md5加密
		password=MD5Util.getMD5(password);
		//根据用户名查询用户信息
		User userInfo=mapper.getUser(username);
		if(userInfo==null||!password.equals(userInfo.getPassWord())) {
			return APIEntry.ERROR("用户名或密码错误");
		}
	//用户信息正确，获取jwt令牌，将令牌传递给前端
		String token=JwtHelper.generateJWT(userInfo.getUserId()+"", userInfo.getUserName(), "");
		//将token放入cookie中
		Cookie cookie=new Cookie("TOKEN",token);
		cookie.setDomain("/");
		cookie.setMaxAge(1000*60*60);
		return APIEntry.OK(token);
	}

}
