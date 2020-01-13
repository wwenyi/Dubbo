package com.wwy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * SpringBoot启动类
 * @author wwy
 * @ClassName com.wwy.SpringBootRun.java
 * @date 2020年1月13日  上午10:56:08
 * @version v0.0.1
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBootRun {
public static void main(String[] args) {
	SpringApplication.run(SpringBootRun.class, args);
}
}
