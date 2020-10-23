package com.yl.thread;

import com.yl.Log;

/**
 * * @Description 可见性
 * * @Author 刘亚林
 * * @CreateDate 2020/10/23
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Visibility {
    public static boolean isTrue = false;
    public static  void main(String[] args) {
        new Thread(() -> {
            Log.d("thread start");
            while ( !isTrue) {
            }
            Log.d("thread end");
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            Log.d("thread1 start");
            isTrue = true;
            Log.d("thread1 end");
        }).start();

    }
}
