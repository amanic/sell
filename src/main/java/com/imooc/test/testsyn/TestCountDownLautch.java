package com.imooc.test.testsyn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by chenhaitao on 2018/4/25.
 */
public class TestCountDownLautch {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        try {
            for (int i = 0; i < 10; i++) {
                new DoJob("线程"+i,500,countDownLatch).run();
            }
            countDownLatch.await();
            System.out.println("哈哈哈，执行完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    static class DoJob implements Runnable{

        private String jobName;

        private Integer workTime;

        private CountDownLatch countDownLatch;


        public DoJob(String s, Integer i, CountDownLatch c){
            this.countDownLatch = c;
            this.jobName = s;
            this.workTime = i;
        }

        @Override
        public void run() {
            System.out.println("Worker "+jobName+" do work begin at "+sdf.format(new Date()));
            try {
                Thread.sleep(workTime);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker "+jobName+" do work complete at "+sdf.format(new Date()));
        }
    }
}
