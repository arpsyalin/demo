package com.yl.design;

import com.yl.JsonFileFactory;
import com.yl.Log;
import com.yl.design.bean.Design;
import com.yl.design.bean.Principle;
import com.yl.design.behavior.Strategy;
import com.yl.design.behavior.Template;
import com.yl.design.constant.Constants;
import com.yl.design.create.*;
import com.yl.design.structure.*;

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
            //浅拷贝
            Prototype.ImageFile imageFile = new Prototype.ImageFile("d:", "1111122222");
            Prototype.ImageFile imageFile1 = (Prototype.ImageFile) imageFile.clone();
            imageFile1.setPath("c:");
            Log.d("是否同一个对象：" + (imageFile == imageFile1));
            Log.d(imageFile.toString());
            Log.d(imageFile1.toString());

            //深拷贝示例
            int[] data = {1, 2, 3};
            Prototype.User user = new Prototype.User("ddddd", data);
            Prototype.User user1 = (Prototype.User) user.clone();
            Log.d("是否同一个对象：" + (user == user1));
            Log.d(user.toString());
            Log.d(user1.toString());
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

        //装饰器模式
        Log.d("");
        Decorator.BYDCarFactory bydCarFactory = new Decorator.BYDCarFactory();
        Decorator.BJ4S_1 bj4S_1 = new Decorator.BJ4S_1(bydCarFactory);
        bj4S_1.buildCar();
        Decorator.DZCarFactory dzCarFactory = new Decorator.DZCarFactory();
        Decorator.BJ4S_1 bj4S_2 = new Decorator.BJ4S_1(dzCarFactory);
        bj4S_2.buildCar();

        //外观模式
        Log.d("");
        Facade.ICar car = new Facade.HCar();
        Facade.IWheel wheel = new Facade.PLLWheel();
        Facade.IMirror mirror = new Facade.RearViewMirror();
        Facade.CarFactory carFactory = new Facade.CarFactory(car, wheel, mirror);
        carFactory.assemble();

        //享元模式
        Log.d("");
        Flyweight.Person zs = new Flyweight.Person("张三");
        Flyweight.Person ls = new Flyweight.Person("李四");
        Flyweight.Person ww = new Flyweight.Person("王武");

        Flyweight.SportMeeting sportMeeting = new Flyweight.SportMeeting();
        Flyweight.ISport sport200 = sportMeeting.getSport("200米跑步");
        Flyweight.ISport sport400 = sportMeeting.getSport("400米跑步");
        Flyweight.ISport sport2001 = sportMeeting.getSport("200米跑步");
        Flyweight.ISport sport4001 = sportMeeting.getSport("400米跑步");
        Flyweight.ISport sportJump = sportMeeting.getSport("跳高");
        Flyweight.ISport sportJump2 = sportMeeting.getSport("跳高");
        sport2001.match(zs, ls, ww);
        sport4001.match(zs, ww);
        sport200.match(zs, ls);
        sport400.match(zs, ls, ww);
        sportJump.match(zs, ls, ww);
        sportJump2.match(zs, ww);

        //组合模式
        Log.d("");
        Composite.ComputerParts cpu = new Composite.ComputerParts("cpu", 1, 1200);
        Composite.ComputerParts rom = new Composite.ComputerParts("内存条", 2, 290);
        Composite.ComputerParts card = new Composite.ComputerParts("卡", 2, 290);
        Composite.Computer computer = new Composite.Computer();
        computer.addParts(card, cpu).addParts(rom);
        computer.show();
        computer.calc();

        //行为模式
        //模版模式
        Log.d("");
        Template.BydAssembleCar bydAssembleCar = new Template.BydAssembleCar();
        bydAssembleCar.assembleCar();
        Template.HAssembleCar hAssembleCar = new Template.HAssembleCar();
        hAssembleCar.assembleCar();

        //策略模式
        Log.d("");
        Strategy.AirMode airMode = new Strategy.AirMode();
        Strategy.CarMode carMode = new Strategy.CarMode();
        Strategy.TrainMode trainMode = new Strategy.TrainMode();
        Strategy.GoTravel goTravel = new Strategy.GoTravel();
        goTravel.setITransportation(airMode);
        goTravel.goTravel();
        goTravel.setITransportation(carMode);
        goTravel.goTravel();
        goTravel.setITransportation(trainMode);
        goTravel.goTravel();

        //
    }

}
