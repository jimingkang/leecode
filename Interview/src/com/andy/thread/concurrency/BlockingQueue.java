package com.andy.thread.concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class BlockingQueue<T> {

    private final Queue<T> queue = new LinkedList<>();

    // 队列容量
    private final int capacity;

    // 锁
    private final ReentrantLock lock = new ReentrantLock();

    // 两个Condition
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    // =======================
    // Producer
    // =======================
    public void put(T value) throws InterruptedException {

        lock.lock();

        try {

            // 队列满了
            while (queue.size() == capacity) {
                notFull.await();
            }

            queue.offer(value);

            System.out.println("Put : " + value);

            // 通知消费者
            if(queue.size()==10)
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    // =======================
    // Consumer
    // =======================
    public T take() throws InterruptedException {

        lock.lock();

        try {

            // 队列为空
            while (queue.isEmpty()) {
                notEmpty.await();
            }

            T value = queue.remove();

            System.out.println("Take: " + value);

            // 通知生产者
            notFull.signal();

            return value;

        } finally {
            lock.unlock();
        }
    }

    public List<T> takeBatch() throws InterruptedException {

        lock.lock();

        try {

            // 不到10个继续等
            while (queue.size() < 10) {
                notEmpty.await();
            }

            List<T> batch = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                batch.add(queue.remove());
            }

            notFull.signal();

            return batch;

        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {

        BlockingQueue<Integer> queue =
                new BlockingQueue<>(10);

        // Producer
        new Thread(() -> {

            int i = 1;

            while (true) {

                try {

                    queue.put(i++);

                    Thread.sleep(100);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }).start();


        // Consumer
        new Thread(() -> {

            while (true) {

                try {

                    List l=queue.takeBatch();
                    System.out.println(Thread.currentThread().getName());
                    Stream.of(l).forEach(i->System.out.println(i));
                   // for (int i = 0; i <l.size() ; i++) {
                  //      System.out.println(l.get(i))
                   // }

                    Thread.sleep(200);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }).start();

        new Thread(() -> {

            while (true) {

                try {

                   // queue.takeBatch();
                    List l=queue.takeBatch();
                    System.out.println(Thread.currentThread().getName());
                    Stream.of(l).forEach(i->System.out.println(i));

                    Thread.sleep(200);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }).start();
    }
}