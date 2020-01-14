package com.wwy.util;


/**
 * ThreadLocal的工具类
 * @author wwy
 * @ClassName com.wwy.util.ThreadLocalUtil.java
 * @date 2020年1月14日  下午4:30:34
 * @version v0.0.1
 *
 */
public class ThreadLocalUtil {
	//构造方法私有化，不允许用户new对象
private ThreadLocalUtil() {}
//新建一个ThreadLocal对象，在类加载的时候创建一个（单例的）
private static final ThreadLocal<String> tl=new ThreadLocal<>();
//重写set。get。remove方法
public static void set(String username){
    tl.set(username);
}

public static String get(){
    return tl.get();
}

public static void remove(){
    tl.remove();
}


}
