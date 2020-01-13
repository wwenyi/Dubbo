package com.wwy.entry;
import java.io.Serializable;
import lombok.Data;
/**
 * Car的实体类
 * @author wwy
 * @ClassName com.wwy.entry.CarEntry.java
 * @date 2020年1月13日  上午11:44:07
 * @version v0.0.1
 *
 */
@Data
public class Car implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 149221415710475302L;
private Integer id;
private String name;
private String createTime;
private Double money;
}
