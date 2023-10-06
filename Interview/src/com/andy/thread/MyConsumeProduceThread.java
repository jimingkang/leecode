package com.andy.thread;

/**
 * Created by aweng on 6/27/2016.
 */
public class MyConsumeProduceThread {


    /**
     * Created by aweng on 6/27/2016.
     */

    public static void main(String[] ss) {
        System.out.println("Hello");
        MyCount Count = new MyCount(0);

        Thread Producer = new Thread(new Producer(Count));
        Producer.start();
        System.out.println("Producer thread name:"+Producer.getName());
        try{
            Thread.sleep(500) ;
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }
        Thread ConsumerOne = new Thread(new Consumer(Count));
        ConsumerOne.start();
        System.out.println("ConsumerOne thread name:"+ConsumerOne.getName());
        Thread ConsumerTwo = new Thread(new Consumer(Count));
        ConsumerTwo.start();
        System.out.println("ConsumerTwo thread name:"+ConsumerTwo.getName());
    }
}

    class Consumer implements Runnable{
        MyCount count;
        public Consumer(MyCount count){
            this.count=count;
        }
        public void run() {
            while(true)
            {
                count.get();
            }

        }
    }
    class Producer extends Thread{
        MyCount count;
        public Producer(MyCount count){
            this.count=count;
        }
        public void run(){
            while(true)
            {

                count.set();
            }
        }
    }
    class MyCount {
        int num;
        boolean flag = true ;   // 设置标志位,初始时先生产
        public MyCount(int num){
            this.num=num;
        }
        public void  get(){
            synchronized (this) {
                while(num<=0) {
                try {
                    //   Thread.sleep(5);
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                System.out.println(Thread.currentThread().getName()+":Consumer:count=" +num);
                num--;
                flag=true;
                try {

                    Thread.sleep((int)(10*Math.random()));



                } catch (Exception e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
        public void set()
        {
            synchronized (this) {
                while(num>=2) {

                    try {
                        System.out.println("before wait:Producer:count=" +num);
                        wait();
                        System.out.println("after wait:Producer:count=" +num);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName()+":Producer:count=" +num);
                flag=false;
                try {
                      Thread.sleep(1);


                } catch (Exception e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
    }


