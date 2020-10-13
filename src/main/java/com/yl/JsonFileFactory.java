package com.yl;

import com.alibaba.fastjson.JSONObject;
import com.yl.utils.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * * @Description 数据工厂
 * * @Author 刘亚林
 * * @CreateDate 2020/10/9
 * * @Version 1.0
 * * @Remark TODO
 **/
public class JsonFileFactory {
    static JsonFileFactory instance = new JsonFileFactory();

    private JsonFileFactory() {

    }

    public static JsonFileFactory getInstance() {
        return instance;
    }

    public <T> T loadSubject(String path, Class<T> clazz) {
        try {
            File jsonFile = ResourceUtils.getFile("classpath:" + path);
            String json = FileUtils.readFileToString(jsonFile);
            return JSONObject.parseObject(json, clazz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
