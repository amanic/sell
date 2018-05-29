package com.imooc.test.testsyn;

import com.sun.tools.javac.util.List;
import lombok.experimental.var;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenhaitao on 2018/4/17.
 */
public class AutomicDemo {
    public static int k=0;
    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        for (int m = 0; m<10;m++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int p=0;p<50;p++) {
                        System.out.println("i："+ i.get());
                        i.getAndIncrement();
                        System.out.println("k: "+k);
                        k++;
                    }
                }
            });
            t.start();

        }
        System.out.println("最终i： --------------"+i);
        System.out.println("最终k: --------------"+k);
        
    }
}