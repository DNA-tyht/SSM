package com.DNA3.proxy.cglib;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/19 16:59
 */
public class Advice {
    public void before() {
        System.out.println("前置增强");
    }

    public void after() {
        System.out.println("后置增强");
    }
}
