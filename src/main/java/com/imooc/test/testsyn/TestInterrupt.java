package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/4/28.
 */
public class TestInterrupt extends Thread{
    @Override
    public void run() {
        int i = 0;
        while (true){
            if(this.isInterrupted()){
                return;
            }
            System.out.println(i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestInterrupt testInterrupt = new TestInterrupt();
        testInterrupt.start();
        Thread.sleep(100);
        testInterrupt.interrupt();
        System.out.println("是否终止："+testInterrupt.isInterrupted());
    }
}
