package com.yl.zk.data;

import com.alibaba.fastjson.JSONObject;
import com.yl.JsonFileFactory;
import com.yl.zk.bean.ArrKPointT;
import com.yl.zk.bean.Subject;
import com.yl.zk.tools.SearchSubject;

/**
 * * @Description 测试
 * * @Author 刘亚林
 * * @CreateDate 2020/10/9
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Test {
    public static void main(String[] args) {
        Subject subject = JsonFileFactory.getInstance().loadSubject(Constants.MKS, Subject.class);
        ArrKPointT result = SearchSubject.searchSubject(subject, Constants.ALL, "学习马克思主义的目的");
        System.out.println(JSONObject.toJSONString(result));
    }
}
