package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/4/28.
 */
public class MyThread extends Thread{
    public MyThread(){

        System.out.println("------" + "构造函数开始" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("------" + "构造函数结束" + "------");

    }

    @Override
    public void run(){

        Thread testThread = Thread.currentThread();
        
        System.out.println("------" + "run()开始" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("Thread.currentThread() == this : " + (Thread.currentThread() == this));
        System.out.println("------" + "run()结束" + "------");

    }




    public static void main(String[] args){

        MyThread myThread = new MyThread();
        myThread.setName("A");
        myThread.start();

/*
        MyThread myThread = new MyThread();
        // 将线程对象以构造参数的方式传递给Thread对象进行start（）启动线程
        Thread newThread = new Thread(myThread);
        newThread.setName("A");
        newThread.start();*/

    }
}
