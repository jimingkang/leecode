package com.andy.thread;

public class ThreadAltermate {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    business.son();
                }
            }
        }.start();  //为business.son();开启线程
        //主线程
        for (int i = 0; i < 5; i++) {
            business.parent();
        }

    }
}


/**
 * 1、synchronized在这里的锁是Business对象，作用：parent和son函数互斥
 * 2、flag和wait，作用是：让parent和son完成各自函数内的代码再切换运行
 */
class Business {
    boolean flag = true;

    public synchronized void parent() {
        while (flag) {
            try {
                System.out.println("-----parent wait----");
                this.wait();
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("-----parent run----" + i);
        }
        flag = true;
        this.notify();
    }

    public synchronized void son() {
        while (!flag) {
            try {
                System.out.println("-----son wait----");
                this.wait();
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 1; i++) {
            System.out.println("-----son run----" + i);
        }
        flag = false;
        this.notify();
    }
}