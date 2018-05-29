package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/4/29.
 */
public class TestSynchronizedTwoObjectLock {

    public synchronized void methodA(){
        System.out.println("methodA begin");
        try {
            Thread.sleep(2000);
            throw new NullPointerException("抛出一个异常，会自动释放锁");
        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        }
        System.out.println("methodA end");
    }


    public synchronized void methodB(){
        System.out.println("methodB begin");
        System.out.println("method end");
    }



    static class threadA implements Runnable{
        private TestSynchronizedTwoObjectLock twoObjectLock ;
        public threadA(TestSynchronizedTwoObjectLock twoObjectLock){
            this.twoObjectLock = twoObjectLock;
        }

        @Override
        public void run() {
            twoObjectLock.methodA();
        }
    }


    static class threadB implements Runnable{
        private TestSynchronizedTwoObjectLock twoObjectLock ;
        public threadB(TestSynchronizedTwoObjectLock twoObjectLock){
            this.twoObjectLock = twoObjectLock;
        }

        @Override
        public void run() {
            twoObjectLock.methodB();
        }
    }

    public static void main(String[] args) {
        TestSynchronizedTwoObjectLock twoObjectLock = new TestSynchronizedTwoObjectLock();
        new Thread(new threadA(twoObjectLock),"a").start();
        new Thread(new threadB(twoObjectLock),"a").start();
    }
}
