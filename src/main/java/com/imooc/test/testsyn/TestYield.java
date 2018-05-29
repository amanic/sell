package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/4/29.
 */
public class TestYield implements Runnable{

    private InheritableThreadLocal inheritableThreadLocal;

    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    public static void main(String[] args) {

        new Thread(new TestYield()).start();
    }
}
