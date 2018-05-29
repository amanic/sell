package com.imooc.test.testsyn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenhaitao on 2018/3/31.
 */
public class Operation {

    public static void main(String[] args) {
        RestTicket restTicket = new RestTicket(100);

        /*TicketOpThread ticketOpThreadA = new TicketOpThread(restTicket);

        TicketOpThread ticketOpThreadB = new TicketOpThread(restTicket);

        TicketOpThread ticketOpThreadC = new TicketOpThread(restTicket);

        new Thread(ticketOpThreadA,"A").start();

        new Thread(ticketOpThreadB,"B").start();

        new Thread(ticketOpThreadC,"C").start();*/
        ExecutorService ts = Executors.newFixedThreadPool(10);


        for (int i = 0; i < 20; i++) {
            new Thread(new TicketOpThread(restTicket),"线程"+i).start();
        }

        for (int i = 0; i < 100; i++) {
            if(i==99){
                System.out.println("主线程执行完了");
                return ;
            }
        }


    }


}
