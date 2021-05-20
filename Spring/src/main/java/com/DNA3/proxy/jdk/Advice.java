package com.DNA3.proxy.jdk;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/19 16:33
 */
public class Advice {
    public void before() {
        System.out.println("前置增强");
    }

    public void after() {
        System.out.println("后置增强");
    }
}
