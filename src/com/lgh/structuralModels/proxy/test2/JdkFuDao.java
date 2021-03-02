package com.lgh.structuralModels.proxy.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkFuDao
 * @Author l42142
 * @Date 2021/3/1 10:57
 * @Description TODO
 * @Version 1.0
 **/
public class JdkFuDao implements InvocationHandler {
    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意，开始辅导");
    }

    private void before() {
        System.out.println("这里是C语言中文网辅导班，已经收集到您的需求，开始挑选老师");
    }
}
