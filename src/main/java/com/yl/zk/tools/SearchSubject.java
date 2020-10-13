package com.yl.zk.tools;

import com.yl.zk.bean.*;

import static com.yl.zk.data.Constants.ALL;
import static com.yl.zk.data.Constants.TITLE;

/**
 * * @Description 搜索
 * * @Author 刘亚林
 * * @CreateDate 2020/10/9
 * * @Version 1.0
 * * @Remark TODO
 **/
public class SearchSubject {
    public static ArrKPointT searchSubject(Subject subject, int type, String key) {
        ArrKPointT result = new ArrKPointT();
        if (key != null && key.length() > 0) {
            ArrChapter chapters = subject.getItems();
            for (Chapter chapter : chapters) {
                ArrKPointT arrKPointT = chapter.getItems();
                for (KPointT kPointT : arrKPointT) {
                    if (contains(type, kPointT, key)) {
                        result.add(kPointT);
                    }
                }
            }
        }
        return result;
    }

    public static boolean contains(int type, KPointT kPointT, String key) {
        if (type == TITLE) {
            if (kPointT.getTitle().contains(key)) {
                return true;
            }
        } else if (type == ALL) {
            if (kPointT.getTitle().contains(key) || (kPointT.getContent() != null && kPointT.getContent().contains(key))) {
                return true;
            }
        }
        return false;
    }
}
