package com.yl.design.structure;

import com.yl.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * * @Description 享元模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO 运用共享技术来有效地支持大量细粒度对象的复用。
 **/
public class Flyweight {
    //参加比赛的选手
    public static class Person {
        private String mName;

        public Person(String name) {
            this.mName = name;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            this.mName = name;
        }
    }

    //运动类接口需要实现哪些人比赛
    public interface ISport {
        void match(Person... person);
    }

    //运动类
    public static class Sport implements ISport {
        String mKey;

        public Sport(String key) {
            this.mKey = key;
        }

        //打印比赛人的实现
        @Override
        public void match(Person... persons) {
            String personListStr = "";
            for (Person person : persons) {
                personListStr += " " + person.getName() + " ";
            }
            Log.d("参加本场：" + mKey + "；比赛的是：" + personListStr);
        }
    }


    //运动会
    public static class SportMeeting {
        //运动项目
        private Map<String, ISport> mSportHashMap = new HashMap();

        //获取运动项目
        public ISport getSport(String key) {
            ISport sport = mSportHashMap.get(key);
            if (sport != null) {
                Log.d("具体享元运动项目类：" + key + "已经存在，被成功获取！");
            } else {
                sport = new Flyweight.Sport(key);
                mSportHashMap.put(key, sport);
                Log.d("具体享元运动项目类：" + key + "不存在，被创建！");
            }
            return sport;
        }
    }


}
