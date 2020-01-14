package com.wwy.service;

import com.wwy.entry.APIEntry;
import com.wwy.entry.User;
/**
 * 单点登录的业务接口层
 * @author wwy
 * @ClassName com.wwy.service.SsoService.java
 * @date 2020年1月14日  上午11:18:30
 * @version v0.0.1
 *
 */
public interface SsoService {

	APIEntry login(User user);

}
