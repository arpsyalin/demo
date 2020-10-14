package com.yl.design.structure;

import com.yl.Log;

/**
 * * @Description 装饰器模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO 动态地给对象增加一些职责，即增加其额外的功能。
 **/
public class Decorator {
    //假设我们有一个汽车工厂来建造汽车
    public interface ICarFactory {
        void buildCar();
    }

    //BYD负责造了一个汽车
    public static class BYDCarFactory implements ICarFactory {

        @Override
        public void buildCar() {
            Log.d("造了一辆汽车");
        }
    }

    //BYD负责造了一个汽车
    public static class DZCarFactory implements ICarFactory {

        @Override
        public void buildCar() {
            Log.d("造了一辆跑车");
        }
    }

    //BJ4S负责拿到工厂 让工厂给自己造汽车
    public static class BJ4S implements ICarFactory {
        ICarFactory mICarFactory;

        public BJ4S(ICarFactory iCarFactory) {
            mICarFactory = iCarFactory;
        }

        public void buildCar() {
            mICarFactory.buildCar();
        }


    }

    //BJ4S_1 是BJ4S子厂觉得光造汽车不够，想自己贴个牌
    public static class BJ4S_1 extends BJ4S {

        public BJ4S_1(ICarFactory iCarFactory) {
            super(iCarFactory);
        }

        public void buildCar() {
            mICarFactory.buildCar();
            OEM();
        }

        public void OEM() {
            Log.d("贴个牌，我是BJ4S车");
        }
    }
}
