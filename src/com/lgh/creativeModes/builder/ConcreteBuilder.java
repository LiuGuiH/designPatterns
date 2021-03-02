package com.lgh.creativeModes.builder;

/**
 * @ClassName ConcreteBuilder
 * @Author l42142
 * @Date 2021/3/1 9:28
 * @Description TODO
 * @Version 1.0
 **/
public class ConcreteBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    public void buildPartB() {
        product.setPartB("建造 PartB");
    }

    public void buildPartC() {
        product.setPartC("建造 PartC");
    }
}
