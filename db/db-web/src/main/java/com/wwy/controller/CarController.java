package com.wwy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.wwy.entry.APIEntry;
import com.wwy.entry.Car;
import com.wwy.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Car controller层
 * @author wwy
 * @ClassName com.wwy.controller.CarController.java
 * @date 2020年1月13日  下午1:43:02
 * @version v0.0.1
 *
 */

@RestController
@Api(tags = "Car")
@RequestMapping("car")
public class CarController {
	//注入的时候使用dubbo的注解，timeout表示超时时间，check表示表示是否启动时检查服务提供者
	//loadbalance表示负载均衡的策略
	
@Reference(timeout = 3000,check=false,loadbalance = "random")
private CarService service;
/**
 * 查询所有购物车数据
 * @return
 */
@ApiOperation("查询所有")
@GetMapping("getall")
public APIEntry getAll() {
	List<Car> data = service.getAll();
	return APIEntry.OK(data);
}
}
