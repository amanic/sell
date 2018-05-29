package com.imooc.test.testsyn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenhaitao on 2018/4/25.
 */
public class SimpleDateFormateTest2 {


    public static void main(String[] args) {
        final DateFormat df = new SimpleDateFormat("yyyyMMdd,HHmmss");
        ExecutorService ts = Executors.newFixedThreadPool(100);
        for (;;) {
            ts.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //生成随机数，格式化日期
                        String format =  df.format(new Date(Math.abs(new Random().nextLong())));
                        System.out.println(format);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            });
        }
    }
}
