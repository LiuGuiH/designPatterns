package com.lgh.creativeModes.builder;

/**
 * @ClassName Director
 * @Author l42142
 * @Date 2021/3/1 9:29
 * @Description TODO
 * @Version 1.0
 **/
class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
