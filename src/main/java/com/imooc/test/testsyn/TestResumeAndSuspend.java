package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/4/28.
 */
public class TestResumeAndSuspend extends Thread{
    private Integer i;

    public TestResumeAndSuspend(Integer i){
        this.i =i;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true){
            this.i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestResumeAndSuspend thread = new TestResumeAndSuspend(1);
        thread.start();
        Thread.sleep(10);
        thread.suspend();
        System.out.println("现在是："+thread.getI());
        Thread.sleep(10);
        System.out.println("现在是："+thread.getI());
        thread.resume();
        Thread.sleep(10);
        thread.suspend();
        System.out.println("现在是："+thread.getI());
        Thread.sleep(10);
        System.out.println("现在是："+thread.getI());


    }
}
