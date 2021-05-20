package com.DNA3.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/19 16:35
 */
public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target = new Target();
        //增强对象
        final Advice advice = new Advice();

        //返回值是动态生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                //目标对象加载器
                target.getClass().getClassLoader(),
                //目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                //传入处理调用方法的InvocationHandler
                new InvocationHandler() {
                    //调用代理对象的任何方法，实际上执行的都是invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        //执行目标方法
                        method.invoke(target, args);
                        advice.after();
                        return null;
                    }
                }
        );
        //调用代理对象的方法
        proxy.save();
    }
}
