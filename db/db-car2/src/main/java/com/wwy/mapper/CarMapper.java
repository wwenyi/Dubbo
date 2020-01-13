package com.wwy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wwy.entry.Car;

@Mapper
public interface CarMapper {
List<Car> getAll();
}
