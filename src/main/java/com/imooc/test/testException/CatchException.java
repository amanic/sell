package com.imooc.test.testException;

/**
 * Created by chenhaitao on 2018/4/17.
 */
public class CatchException {

    public static void main(String[] args) {
        String s = new ThrowException().test("1");
        System.out.println(s);
        System.out.println("好了");
    }
}
