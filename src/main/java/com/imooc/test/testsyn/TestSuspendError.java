package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/4/28.
 */
public class TestSuspendError {
    public synchronized void dosth(){
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a线程被暂停了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        TestSuspendError testSuspendError = new TestSuspendError();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testSuspendError.dosth();
            }
        },"a").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testSuspendError.dosth();
            }
        },"b").start();
    }
}
