package com.wwy.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.alibaba.fastjson.JSONObject;
import com.wwy.util.JwtHelper;
import com.wwy.util.ThreadLocalUtil;
/**
 * 验证用户是否登录的拦截器
 * @author wwy
 * @ClassName com.wwy.filter.UserFilter.java
 * @date 2020年1月14日  下午1:06:29
 * @version v0.0.1
 *
 */
@Component
public class UserFilter implements HandlerInterceptor{
	/**
	 * 重写前置过滤器方法
	 * 返回值，true表示放行，false表示拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("yizhixing");
		//获取所有的cookie
		Cookie[] cookies = request.getCookies();
		//遍历cookie
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getValue());
			if("TOKEN".equals(cookie.getName())) {
				//获取token
				String token=cookie.getValue();
				//对token解密为json
				String userJson=JwtHelper.validateLogin(token);
				JSONObject json=JSONObject.parseObject(userJson);
				//获取用户名信息，存放到请求头中
				String username=json.getString("userName");
				//response.setHeader("token", username);
				//将用户信息存储到Thread中，方便后续使用,实际使用中一般是存储user对象，这里以用户名为例
				ThreadLocalUtil.set(username);
				return true;
			}
		}
		response.setStatus(4004);
		response.getOutputStream().write("未登录".getBytes());
		return false;
	}
}
