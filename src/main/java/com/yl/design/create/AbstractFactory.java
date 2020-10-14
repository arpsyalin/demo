package com.yl.design.create;

/**
 * * @Description 抽象工厂
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark 提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。（属于对象创建型模式）
 **/
public class AbstractFactory {
    public interface IFactory {
        IMouse getMouse();

        IKeyBroad getKeyBroad();
    }

    public interface IMouse {
        String mouseBrandName();
    }

    public interface IKeyBroad {
        String keyBroadBrandName();
    }

    public static class HPMouse implements IMouse {
        @Override
        public String mouseBrandName() {
            return "惠普的鼠标";
        }
    }

    public static class HPKeyBroad implements IKeyBroad {
        @Override
        public String keyBroadBrandName() {
            return "惠普的键盘";
        }
    }

    public static class LXMouse implements IMouse {
        @Override
        public String mouseBrandName() {
            return "联想的鼠标";
        }
    }

    public static class LXKeyBroad implements IKeyBroad {
        @Override
        public String keyBroadBrandName() {
            return "联想的键盘";
        }
    }

    public static class XMFactory implements IFactory {

        @Override
        public IMouse getMouse() {
            return new HPMouse();
        }

        @Override
        public IKeyBroad getKeyBroad() {
            return new LXKeyBroad();
        }
    }

    public static class HWFactory implements IFactory {

        @Override
        public IMouse getMouse() {
            return new LXMouse();
        }

        @Override
        public IKeyBroad getKeyBroad() {
            return new LXKeyBroad();
        }
    }
}
