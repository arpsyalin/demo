package com.yl.zk.data;

import com.alibaba.fastjson.JSONObject;
import com.yl.zk.bean.Subject;
import com.yl.zk.utils.FileUtils;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

import static com.yl.zk.data.Constants.MKS;

/**
 * * @Description 数据工厂
 * * @Author 刘亚林
 * * @CreateDate 2020/10/9
 * * @Version 1.0
 * * @Remark TODO
 **/
public class ZKDataFactory {
    static ZKDataFactory instance = new ZKDataFactory();

    private ZKDataFactory() {

    }

    public static ZKDataFactory getInstance() {
        return instance;
    }

    public Subject loadSubject(String path) {
        try {
            File jsonFile = ResourceUtils.getFile("classpath:" + path);
            String json = FileUtils.readFileToString(jsonFile);
            return JSONObject.parseObject(json, Subject.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
