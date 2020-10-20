package com.yl.design.structure;

import com.yl.Log;

import java.util.HashMap;

/**
 * * @Description 享元模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO 运用共享技术来有效地支持大量细粒度对象的复用。
 **/
public class Flyweight {
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

    public interface ISport {
        void match(Person... person);
    }


    public static class Sport implements ISport {
        String mKey;

        public Sport(String key) {
            this.mKey = key;
        }

        @Override
        public void match(Person... persons) {
            for (Person person : persons) {
                Log.d("参加" + mKey + "比赛的是：" + person.getName());
            }
        }
    }


    //运动会
    public static class SportMeeting {
        private HashMap<String, ISport> mSportHashMap = new HashMap<String, ISport>();

        public ISport getSport(String key) {
            ISport sport = mSportHashMap.get(key);
            if (sport != null) {
                System.out.println("具体享元" + key + "已经存在，被成功获取！");
            } else {
                sport = new Flyweight.Sport(key);
                mSportHashMap.put(key, sport);
            }
            return sport;
        }
    }


}
