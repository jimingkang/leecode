package com.andy.thread.concurrency;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String args[]) {
        ExecutorService ex= Executors.newSingleThreadExecutor();
        Future f=ex.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("excutor pool thread:"+Thread.currentThread().getName());
                Thread.sleep(1);

                return "hekllk";
            }
        });
        try {
            System.out.println("main:"+Thread.currentThread().getName());
            System.out.println(f.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("main thred");
    }

}
