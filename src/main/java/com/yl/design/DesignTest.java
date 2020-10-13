package com.yl.design;

import com.yl.JsonFileFactory;
import com.yl.Log;
import com.yl.design.bean.Design;
import com.yl.design.bean.Principle;
import com.yl.design.constant.Constants;
import com.yl.design.create.Prototype;
import com.yl.design.create.SimpleFactory;
import com.yl.design.create.Singleton;

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

        //工厂方法模式
            
    }


}
