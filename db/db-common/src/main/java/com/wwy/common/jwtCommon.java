package com.wwy.common;


/**
 * JWT使用常量值
 * @author wwy
 * @ClassName com.wwy.common.jwtCommon.java
 * @date 2020年1月14日  上午10:33:06
 * @version v0.0.1
 *
 */
public class jwtCommon {

    //签名秘钥
    public static final String BASE64SECRET = "wwyawwyawwyawwy";

    //超时毫秒数（默认30分钟）
    public static final int EXPIRESSECOND = 1800000;

    //用于JWT加密的密匙
    public static final String DATAKEY = "wwy";

}
