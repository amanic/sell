package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/4/29.
 */
public class TestSynWithOtherObj {

    private String name = "";

    private String token = "";

    private String lockString = "";

    public void doSet(String s1, String s2){
        synchronized(lockString){
            System.out.println("设置线程同步块开始");
            this.name= s1;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.token = s2;
            System.out.println("设置线程同步块结束");
        }
    }

    public void doGet(){
        synchronized (lockString){
            System.out.println("获取线程同步块开始");
            System.out.println("用户名："+this.name+", 密码："+this.token);
            System.out.println("获取线程同步块结束");
        }
    }

    static class ThreadA extends Thread{
        private TestSynWithOtherObj testSynWithOtherObj;
        public ThreadA(TestSynWithOtherObj t){
            this.testSynWithOtherObj = t;
        }
        @Override
        public void run() {
            super.run();
            testSynWithOtherObj.doSet("a","aa");
        }
    }

    static class ThreadB extends Thread{
        private TestSynWithOtherObj testSynWithOtherObj;
        public ThreadB(TestSynWithOtherObj t){
            this.testSynWithOtherObj = t;
        }
        @Override
        public void run() {
            super.run();
            testSynWithOtherObj.doSet("b","bb");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestSynWithOtherObj testSynWithOtherObj = new TestSynWithOtherObj();
        ThreadA threadA = new ThreadA(testSynWithOtherObj);
        ThreadB threadB = new ThreadB(testSynWithOtherObj);
        threadA.start();
        Thread.sleep(3000);
        testSynWithOtherObj.doGet();
        threadB.start();
        Thread.sleep(3000);
        testSynWithOtherObj.doGet();
    }
}
