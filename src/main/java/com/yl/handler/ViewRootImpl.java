package com.yl.handler;

/**
 * * @Description View基础类
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class ViewRootImpl {
    private Thread mThread;

    public ViewRootImpl() {
        mThread = Thread.currentThread();
    }

    void checkThread() {
        if (mThread != Thread.currentThread()) {
            throw new RuntimeException(
                    "Only the original thread that created a view hierarchy can touch its views.");
        }
    }
}
