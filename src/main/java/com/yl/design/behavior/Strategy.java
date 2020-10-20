package com.yl.design.behavior;

import com.yl.Log;

/**
 * * @Description 策略
 * * @Author 刘亚林
 * * @CreateDate 2020/10/20
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Strategy {
    public interface ITransportation {
        void mode();
    }

    public static class AirMode implements ITransportation {

        @Override
        public void mode() {
            Log.d("坐飞机去");
        }
    }

    public static class CarMode implements ITransportation {

        @Override
        public void mode() {
            Log.d("坐汽车去");
        }
    }

    public static class TrainMode implements ITransportation {

        @Override
        public void mode() {
            Log.d("坐火车去");
        }
    }

    //旅游
    public static class GoTravel {
        ITransportation mITransportation;

        public ITransportation getITransportation() {
            return mITransportation;
        }

        public void setITransportation(ITransportation mITransportation) {
            this.mITransportation = mITransportation;
        }

        public void goTravel() {
            Log.d("我们怎么去旅游？");
            if (mITransportation != null) mITransportation.mode();
        }
    }
}
