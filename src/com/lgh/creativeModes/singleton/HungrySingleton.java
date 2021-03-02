package com.lgh.creativeModes.singleton;

/**
 * @ClassName HungrySingleton
 * @Author l42142
 * @Date 2021/2/26 16:33
 * @Description TODO
 * @Version 1.0
 **/
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
