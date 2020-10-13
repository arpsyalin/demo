package com.yl.design.create;

import com.yl.Log;

/**
 * * @Description 单例
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark 单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。（属于对象创建型模式）
 **/
public class Singleton {
    /**
     * * @Description 懒汉单例
     * * @Author 刘亚林
     * * @CreateDate 2020/10/13
     * * @Version 1.0
     * * @Remark
     */
    public static class LazySingleton {
        private static volatile LazySingleton instance;

        private LazySingleton() {
            if (instance != null) {
                throw new RuntimeException("can't newInstance");
            }
        }

        /**
         * * @MethodName getInstance
         * * @Description
         * * @Author 刘亚林
         * * @CreateDate 2020/10/13
         * * @Version 1.0
         * * @Remark 工厂模式入口
         * * @Param []
         * * @Return com.yl.design.create.Singleton.LazySingleton
         **/
        public static LazySingleton getInstance() {
            if (instance == null) {
                synchronized (LazySingleton.class) {
                    if (instance == null) {
                        instance = new LazySingleton();
                        return instance;
                    }
                }
            }
            return instance;
        }

        public int log() {
            Log.d("LazySingleton hashCode:" + this.hashCode());
            return this.hashCode();
        }
    }

    /**
     * * @Description 饿汉单例
     * * @Author 刘亚林
     * * @CreateDate 2020/10/13
     * * @Version 1.0
     * * @Remark
     */
    public static class HungrySingleton {
        private static HungrySingleton instance = new HungrySingleton();

        private HungrySingleton() {
            if (instance != null) {
                throw new RuntimeException("can't newInstance");
            }
        }

        /**
         * * @MethodName getInstance
         * * @Description
         * * @Author 刘亚林
         * * @CreateDate 2020/10/13
         * * @Version 1.0
         * * @Remark 工厂模式入口
         * * @Param []
         * * @Return com.yl.design.create.Singleton.HungrySingleton
         **/
        public static HungrySingleton getInstance() {
            return instance;
        }

        public int log() {
            Log.d("HungrySingleton hashCode:" + this.hashCode());
            return this.hashCode();
        }
    }

}


