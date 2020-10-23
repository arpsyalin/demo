package com.yl.thread;

/**
 * * @Description 原子性
 * * @Author 刘亚林
 * * @CreateDate 2020/10/23
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Atomicity {
    public static int count = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronized (Atomicity.class) {
                        count++;
                    }
                }
            });
            threads[i].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
