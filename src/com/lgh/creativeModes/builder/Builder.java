package com.lgh.creativeModes.builder;

/**
 * @ClassName Builder
 * @Author l42142
 * @Date 2021/3/1 9:29
 * @Description TODO
 * @Version 1.0
 **/
abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}