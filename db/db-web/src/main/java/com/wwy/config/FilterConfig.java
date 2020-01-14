package com.wwy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wwy.filter.UserFilter;
/**
 * 配置拦截器的配置类
 * @author wwy
 * @ClassName com.wwy.config.FilterConfig.java
 * @date 2020年1月14日  下午3:40:35
 * @version v0.0.1
 *
 */
@Configuration
public class FilterConfig implements WebMvcConfigurer{
	@Autowired
	private UserFilter filter;
	/**
	 * 添加拦截器
	 */
	  public void addInterceptors(InterceptorRegistry registry) {
		  registry.addInterceptor(filter).excludePathPatterns("/sso/login/**","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
		  
	  }
}
