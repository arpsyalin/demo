package com.yl.design.behavior;

import com.yl.Log;

/**
 * * @Description 模版模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/20
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Template {

    public static abstract class AssembleCar {
        public void assembleCar() {
            Log.d("开始组装汽车---------------");
            buildFrame();
            buildEngine();
            buildTransmission();
            routing();
            addMirrors();
            addVehicle();
            Log.d("结束组装汽车---------------");
            Log.d("");
        }

        void buildEngine() {
            Log.d("安装发动机");
        }

        void buildTransmission() {
            Log.d("安装变速器");
        }

        void buildFrame() {
            Log.d("安装车架");
        }

        void routing() {
            Log.d("走线");
        }

        abstract void addMirrors();

        abstract void addVehicle();
    }

    public static class BydAssembleCar extends AssembleCar {

        @Override
        void addMirrors() {
            Log.d("安装大牌后视镜");
        }

        @Override
        void addVehicle() {

            Log.d("安装大牌车机");
        }
    }


    public static class HAssembleCar extends AssembleCar {

        @Override
        void addMirrors() {
            Log.d("安装超级大牌后视镜");
        }

        @Override
        void addVehicle() {
            Log.d("安装超级大牌车机");
        }
    }
}
