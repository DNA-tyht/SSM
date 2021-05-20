package com.DNA3.proxy.jdk;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/19 16:32
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running");
    }
}
