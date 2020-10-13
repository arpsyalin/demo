package com.yl.handler;

/**
 * * @Description 主线程通讯
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Handler {
    MessageQueue mQueue;
    public Handler() {
        Looper looper = Looper.myLooper();

        if(looper == null){
            throw new RuntimeException(
                    "Can't create handler inside thread that has not called Looper.prepare()");
        }

        mQueue= looper.mQueue;
    }
    public void handleMessage(Message msg) {

    }

    public void sendMessage(Message message) {
        sendMessageDelay(message, 0);
    }

    public final boolean sendMessageDelay(Message message, long delayMillis) {
        if (delayMillis < 0) {
            delayMillis = 0;
        }
        return sendMessageAtTime(message, System.currentTimeMillis() + delayMillis);
    }

    public final boolean sendMessageAtTime(Message message, long delayMillis) {
        MessageQueue queue = mQueue;
        return enqueueMessage(queue, message, delayMillis);
    }

    private boolean enqueueMessage(MessageQueue queue, Message message, long delayMillis) {
        message.target = this;
        return queue.enqueueMessage(message, delayMillis);
    }
}
