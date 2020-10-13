package com.yl.zk.bean;

import com.sun.tools.javac.util.List;

import java.io.Serializable;

/**
 * * @Description 知识点或题目
 * * @Author 刘亚林
 * * @CreateDate 2020/10/9
 * * @Version 1.0
 * * @Remark TODO
 **/
public class KPointT implements Serializable {
    String title;
    String content = null;
    int type = 0;
    List<String> select = null;
    int key = -1;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getSelect() {
        return select;
    }

    public void setSelect(List<String> select) {
        this.select = select;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
