package com.andy.thread.concurrency;

import java.util.concurrent.*;

public class CompleteFutureTest {
    public static void main(String args[]) {

        CompletableFuture<String> f = CompletableFuture.supplyAsync(()->{
                System.out.println("CompletableFuture thread:"+Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hekllk";
        });
        try {

            System.out.println(f.thenAccept(res -> {
                System.out.println("call back in:" + Thread.currentThread().getName());
                System.out.println(res);
            }));
            System.out.println("main:" + Thread.currentThread().getName());
        } finally {
            f.join();
        }
        //System.out.println("main thred");
    }

}
