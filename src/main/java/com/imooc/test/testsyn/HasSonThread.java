package com.imooc.test.testsyn;

/**
 * Created by chenhaitao on 2018/4/26.
 */
public class HasSonThread {

    public HasSonThread(String ss){
        if(s.get()==null){
            s.set(ss);
        }
    }
    private static ThreadLocal<String> s = new ThreadLocal<>();

    public void tooString() {
        System.out.println(Thread.currentThread().getName()+"直接取："+s.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"的变量是"+s.get());
            }
        }).start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new HasSonThread("线程"+ finalI).tooString();
                }
            },"线程"+i).start();
        }
    }
}
