package com.yl.zk.bean;

import com.sun.tools.javac.util.List;

import java.io.Serializable;

/**
 * * @Description 章节
 * * @Author 刘亚林
 * * @CreateDate 2020/10/9
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Chapter implements Serializable {
    String title;
    ArrKPointT items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrKPointT getItems() {
        return items;
    }

    public void setItems(ArrKPointT items) {
        this.items = items;
    }
}
