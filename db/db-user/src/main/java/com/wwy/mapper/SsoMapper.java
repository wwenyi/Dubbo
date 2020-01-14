package com.wwy.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wwy.entry.User;
@Mapper
public interface SsoMapper {

	User getUser(String username);

}
