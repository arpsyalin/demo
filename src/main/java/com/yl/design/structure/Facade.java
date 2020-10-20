package com.yl.design.structure;

import com.yl.Log;

/**
 * * @Description 外观模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO 为多个复杂的子系统提供一个一致的接口，使这些子系统更加容易被访问。
 **/
public class Facade {
    public interface IFactory {
        void assemble();
    }

    public interface ICar {
        void buy();
    }

    public interface IWheel {
        void buildWheel();
    }

    public interface IMirror {
        void buildMirror();
    }

    public static class HCar implements ICar {
        @Override
        public void buy() {
            Log.d("买一个本田汽车准备开始组装配饰");
        }
    }

    public static class PLLWheel implements IWheel {
        @Override
        public void buildWheel() {
            Log.d("换一个耐倍力轮胎");
        }
    }

    public static class RearViewMirror implements IMirror {

        @Override
        public void buildMirror() {
            Log.d("换一个纽曼智能后视镜");
        }
    }

    public static class CarFactory implements IFactory {
        IWheel mWheel;
        IMirror mMirror;
        ICar mICar;

        public CarFactory(ICar car, IWheel wheel, IMirror mirror) {
            this.mICar = car;
            this.mWheel = wheel;
            this.mMirror = mirror;
        }

        @Override
        public void assemble() {
            mICar.buy();
            mWheel.buildWheel();
            mMirror.buildMirror();
            Log.d("组装完成");
        }
    }
}
