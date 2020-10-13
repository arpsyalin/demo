package com.yl.handler;

/**
 * * @Description 消息队列
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class MessageQueue {
    public Message mMessages;

    public boolean enqueueMessage(Message msg, long when) {
        synchronized (this) {
            msg.when = when;
            Message p = mMessages;
            //如果
            // 1.当前等待的消息为空
            // 2.或者进来的消息时间执行时间0
            // 3.或者当前的消息执行的时间比当前等待消息晚晚
            if (p == null || when == 0 || when < p.when) {
                //把当前等待的消息放在进来的消息后
                msg.next = p;
                //把进来的消息当成等待执行的消息
                mMessages = msg;
            } else {
                Message prev;
                //遍历链表获取到当前进来消息应该放在哪里
                for (; ; ) {
                    prev = p;
                    p = p.next;
                    //如果下一个消息为空了（链尾）
                    //或者是进来的消息应该在当前循环的消息之前执行
                    if (p == null || when < p.when) {
                        break;
                    }
                }
                //将循环出来的消息放在下一个执行
                msg.next = p;
                //设置上一消息的下一个是进来消息
                prev.next = msg;
            }
        }
        return true;
    }

    public Message next() {
        int pendingIdleHandlerCount = -1;
        for (; ; ) {
            synchronized (this) {
                final long now = System.currentTimeMillis();
                Message prevMsg = null;
                Message msg = mMessages;
                //如果消息的Handler为空了
                if (msg != null && msg.target == null) {
                    do {
                        prevMsg = msg;
                        msg = msg.next;
                    } while (msg != null);
                }
                if (msg != null) {
                    if (now < msg.when) {
                        //还没到时间执行
                    } else {
                        if (prevMsg != null) {
                            prevMsg.next = msg.next;
                        } else {
                            mMessages = msg.next;
                        }
                        msg.next = null;
                        return msg;
                    }
                } else {
                }
                if (pendingIdleHandlerCount <= 0) {
                    continue;
                }
            }
        }
    }
}
