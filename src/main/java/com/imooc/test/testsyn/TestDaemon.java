package com.imooc.test.testsyn;

/**
 * 测试守护线程
 * Created by chenhaitao on 2018/4/29.
 */
public class TestDaemon implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while (true){
            System.out.println(i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestDaemon());
        thread.setDaemon(true);
        thread.start();
        /*for (int i = 0; i < 100; i++) {
            i++;
        }*/
        Thread.sleep(1000);
        System.out.println("😀😁🤣😂");
    }
}
