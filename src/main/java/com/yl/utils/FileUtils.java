package com.yl.utils;

import java.io.*;

/**
 * * @Description 文件工具
 * * @Author 刘亚林
 * * @CreateDate 2020/10/9
 * * @Version 1.0
 * * @Remark TODO
 **/
public class FileUtils {

    public static String readFileToString(File jsonFile) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(jsonFile));
            String tmpRead = "";

            while ((tmpRead = bufferedReader.readLine()) != null) {
                stringBuffer.append(tmpRead);
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
