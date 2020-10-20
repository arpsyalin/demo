package com.yl.design.create;

import com.yl.Log;

/**
 * * @Description 单例
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark 单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。（属于对象创建型模式）
 **/
public class Singleton<I> {
    /**
     * * @Description 懒汉单例
     * * @Author 刘亚林
     * * @CreateDate 2020/10/13
     * * @Version 1.0
     * * @Remark
     */
    public static class LazySingleton {
        //加volatile为了防止代码重排序引发的执行顺序逻辑错误
        private static volatile LazySingleton instance;
        //private不能直接new LazySingleton()创建。
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
            //经典双重判断第一重判断为了已经创建就不需要再进入synchronized提高调用的性能
            if (instance == null) {
                //加synchronized是为了防止多线程并发穿透instance == null
                synchronized (LazySingleton.class) {
                    //第二重判断主要是为了没有初始化就初始化，已初始化就直接返回
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


