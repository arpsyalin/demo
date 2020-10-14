package com.yl.design.create;

/**
 * * @Description 抽象工厂
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark 提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。（属于对象创建型模式）
 **/
public class AbstractFactory {
    public final static class DeviceType {
        public final static int N90 = 1;
        public final static int D200 = 2;
    }

    /**
     * * @Description 设备工厂
     * * @Author 刘亚林
     * * @CreateDate 2020/10/13
     * * @Version 1.0
     * * @Remark
     **/
    public static abstract class AbstractDeviceFactory {
        public abstract IDevice getDevice(int deviceType);
    }

    /**
     * * @Description 设备
     * * @Author 刘亚林
     * * @CreateDate 2020/10/13
     * * @Version 1.0
     * * @Remark
     **/
    public interface IDevice {
        String shockAction();
    }

    public static class N90 implements IDevice {

        @Override
        public String shockAction() {
            return "Intent.SHOCK.N90";
        }
    }

    public static class D200 implements IDevice {
        @Override
        public String shockAction() {
            return "Intent.SHOCK.D200";
        }
    }

    public static class D200_1 implements IDevice {
        @Override
        public String shockAction() {
            return "Intent.SHOCK.D200_2";
        }
    }

    public static class DeviceFactory extends AbstractDeviceFactory {

        @Override
        public IDevice getDevice(int deviceType) {
            switch (deviceType) {
                case DeviceType.D200:
                    return new D200();
                case DeviceType.N90:
                    return new N90();
            }
            return null;
        }
    }

    public static class DeviceFactory_1 extends AbstractDeviceFactory {

        @Override
        public IDevice getDevice(int deviceType) {
            switch (deviceType) {
                case DeviceType.D200:
                    return new D200_1();
                case DeviceType.N90:
                    return new N90();
            }
            return null;
        }
    }


}
