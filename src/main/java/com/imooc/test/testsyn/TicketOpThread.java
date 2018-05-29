package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/3/31.
 */
public class TicketOpThread implements Runnable{

    private RestTicket restTicket;

    public TicketOpThread(RestTicket restTicket){
        this.restTicket = restTicket;
    }

    @Override
    public void run() {
        try {
            restTicket.minuse();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
