package com.lgh.creativeModes.builder;


/**
 * @ClassName Client
 * @Author l42142
 * @Date 2021/3/1 9:28
 * @Description TODO
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}
