package com.DNA3.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/19 17:00
 */
public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target = new Target();
        //增强对象
        final Advice advice = new Advice();

        //创建增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Target.class);
        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.after();
                return invoke;
            }
        });
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
