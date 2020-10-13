package com.yl.handler;

import java.lang.ref.WeakReference;

/**
 * * @Description 控件
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class TextView extends ViewRootImpl{
    public void setText(String content) {
        checkThread();
        System.out.println("修改成功:"+content);
    }
}
