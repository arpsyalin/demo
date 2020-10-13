package com.yl.handler;

/**
 * * @Description 循环
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Looper {
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    public MessageQueue mQueue;

    public static void prepare() {
        sThreadLocal.set(new Looper());
    }

    public Looper() {
        mQueue = new MessageQueue();
    }

    public static void loop() {
        Looper looper = myLooper();
        for (; ; ) {
            MessageQueue queue = looper.mQueue;
            Message message = queue.next();
            if (message == null) {
                return;
            }
            message.target.handleMessage(message);
        }
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }
}
