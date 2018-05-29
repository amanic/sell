package com.imooc.test.testsyn;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenhaitao on 2018/3/31.
 */
public class RestTicket {
    private AtomicInteger restNum = new AtomicInteger();

    public RestTicket(Integer i){
        this.restNum.set(i);
    }

    public void minuse() throws InterruptedException {
//        this.notify();
        System.out.println(Thread.currentThread().getName()+"消费前票余量为："+restNum);
        this.restNum.getAndDecrement();
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName()+"消费后票余量为："+restNum);
//        this.wait();
    }
}
