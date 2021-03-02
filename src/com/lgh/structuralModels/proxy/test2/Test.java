package com.lgh.structuralModels.proxy.test2;

/**
 * @ClassName Test
 * @Author l42142
 * @Date 2021/3/1 10:58
 * @Description TODO
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        JdkFuDao jdkFuDao = new JdkFuDao();

        IPerson zhaoliu = jdkFuDao.getInstance(new ZhaoLiu());
        zhaoliu.findTeacher();
    }
}
