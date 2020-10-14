package com.yl.design;

import com.yl.JsonFileFactory;
import com.yl.Log;
import com.yl.design.bean.Design;
import com.yl.design.bean.Principle;
import com.yl.design.constant.Constants;
import com.yl.design.create.*;
import com.yl.design.structure.Adapter;
import com.yl.design.structure.Bridge;
import com.yl.design.structure.Proxy;

/**
 * * @Description 设计模式测试
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class DesignTest {
    public static void main(String[] args) {
        Design design = JsonFileFactory.getInstance().loadSubject(Constants.DESIGN, Design.class);
        if (design != null && design.getItems() != null) {
            Log.d(design.getTitle());
            Log.d("");
            for (Principle principle : design.getItems()) {
                Log.d(principle.getTitle());
                Log.d(principle.getUrl());
                Log.d(principle.getInterpretation());
                Log.d(principle.getRealization());
                Log.d("");
            }
            Log.d(design.getRemark());
        }
        //单例模式
        Singleton.LazySingleton.getInstance().log();
        Singleton.LazySingleton.getInstance().log();
        Singleton.HungrySingleton.getInstance().log();
        Singleton.HungrySingleton.getInstance().log();

        //原型模式
        try {
            Prototype.ImageFile imageFile = new Prototype.ImageFile("d:", "1111122222");
            Prototype.ImageFile imageFile1 = (Prototype.ImageFile) imageFile.clone();
            imageFile1.setPath("c:");
            Log.d("是否同一个对象：" + (imageFile == imageFile1));
            Log.d(imageFile.toString());
            Log.d(imageFile1.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //简单工厂模式
        Log.d(SimpleFactory.grabAnimal(SimpleFactory.Const.ANIMAL_A).name());
        Log.d(SimpleFactory.grabAnimal(SimpleFactory.Const.ANIMAL_B).name());

        Log.d("");
        //工厂方法模式
        Log.d(new FactoryMethod.DeviceFactory().getDevice().shockAction());
        Log.d(new FactoryMethod.DeviceFactory_1().getDevice().shockAction());

        Log.d("");
        //抽象工厂
        AbstractFactory.XMFactory xmFactory = new AbstractFactory.XMFactory();
        Log.d("xmFactory   鼠标：" + xmFactory.getMouse().mouseBrandName() + "；键盘：" + xmFactory.getKeyBroad().keyBroadBrandName());

        AbstractFactory.HWFactory hwFactory = new AbstractFactory.HWFactory();
        Log.d("hwFactory   鼠标：" + hwFactory.getMouse().mouseBrandName() + "；键盘：" + hwFactory.getKeyBroad().keyBroadBrandName());

        Log.d("");
        //建造者模式
        Log.d("菩提树报价：" + new Builder.HouseDecorationManager(new Builder.PTSWholeOffer()).build().toString());
        Log.d("名匠报价：" + new Builder.HouseDecorationManager(new Builder.MJWholeOffer()).build().toString());
        //建造者模式 链式调用
        Builder.Request request = new Builder.Request.RequestBuilder().get().url("http://www.baidu.com/").build();
        Log.d(request.toString());


        Log.d("");
        //AMS代理模式尝试
        Log.d(new AMS.ActivityManager().getService());
        Log.d(new AMS.ActivityManager().getRunningService());
        //代理模式
        Log.d(new Proxy.ServerProxy().requestAddress());


        Log.d("");
        //适配器模式
        Adapter.Voltage10 voltage10 = new Adapter.Voltage10();
        new Adapter.PowerAdapter(voltage10).charge();
        Adapter.Voltage15 voltage15 = new Adapter.Voltage15();
        new Adapter.PowerAdapter(voltage15).charge();

        Log.d("");
        //桥接模式
        Bridge.AVI avi = new Bridge.AVI();
        Bridge.MP4 mp4 = new Bridge.MP4();
        Bridge.Linux linux = new Bridge.Linux();
        Bridge.Unix unix = new Bridge.Unix();

        Log.d(new Bridge.LYLMediaPlay(mp4, unix).play());
        Log.d(new Bridge.LYLMediaPlay(avi, linux).play());
    }


}
