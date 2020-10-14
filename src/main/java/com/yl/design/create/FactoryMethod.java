package com.yl.design.create;

/**
 * * @Description 工厂方法
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark 定义一个用于创建产品的接口，由子类决定生产什么产品。（属于类创建型模式）
 **/
public class FactoryMethod {
    /**
     * * @Description 设备工厂
     * * @Author 刘亚林
     * * @CreateDate 2020/10/13
     * * @Version 1.0
     * * @Remark
     **/
    public interface IDeviceFactory {
        IDevice getDevice();
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

    public static class DeviceFactory implements IDeviceFactory {

        @Override
        public IDevice getDevice() {
            return new D200();
        }
    }

    public static class DeviceFactory_1 implements IDeviceFactory {

        @Override
        public IDevice getDevice() {
            return new D200_1();
        }
    }
}
