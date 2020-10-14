package com.yl.design.structure;

/**
 * * @Description 适配器模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 **/
public class Adapter {
    /**
     * * @Description 电源适配器
     * * @Author 刘亚林
     * * @CreateDate 2020/10/14
     * * @Version 1.0
     * * @Remark TODO 假设我们只有一个15V和10V的充电电压，但是充电只有输入5V才可以就用适配器转换成5V
     **/
    public static class PowerAdapter {
        Voltage mVoltage;

        public PowerAdapter(Voltage voltage) {
            mVoltage = voltage;
        }

        public void charge() {
            System.out.println("输入的电压为：" + mVoltage.v());
            System.out.println("将电压转换成：5V后输出,开始充电");
        }
    }

    interface Voltage {
        int v();
    }

    public static class Voltage15 implements Voltage {

        @Override
        public int v() {
            return 15;
        }
    }

    public static class Voltage10 implements Voltage {

        @Override
        public int v() {
            return 10;
        }
    }
}
