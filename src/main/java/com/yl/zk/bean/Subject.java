package com.yl.zk.bean;


import com.sun.tools.javac.util.List;

import java.io.Serializable;

/**
 * * @Description 科目
 * * @Author 刘亚林
 * * @CreateDate 2020/10/9
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Subject implements Serializable {
    String title;
    ArrChapter items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrChapter getItems() {
        return items;
    }

    public void setItems(ArrChapter items) {
        this.items = items;
    }
}
