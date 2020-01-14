package com.wwy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.wwy.entry.Car;
import com.wwy.mapper.CarMapper;
import com.wwy.service.CarService;
import com.wwy.util.ThreadLocalUtil;

import lombok.extern.slf4j.Slf4j;
/**
 * Carservice实现类
 * @author wwy
 * @ClassName com.wwy.service.impl.CarServiceImpl.java
 * @date 2020年1月13日  上午11:37:52
 * @version v0.0.1
 *
 */
//注意，此处的@service注解为dubbo的service注解！！！
@Service(timeout = 3000,loadbalance = "random")
@Slf4j
public class CarServiceImpl implements CarService{
	@Autowired
	private CarMapper mapper;
	@Override
	public List<Car> getAll() {
		return mapper.getAll();
	}

}
