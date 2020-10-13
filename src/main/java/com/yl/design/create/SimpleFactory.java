package com.yl.design.create;

/**
 * * @Description 简单工厂
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class SimpleFactory {
    public static final class Const {
        public static final int ANIMAL_A = 0;
        public static final int ANIMAL_B = 1;
    }

   public interface Animal {
        String name();
    }

    static class Fish implements Animal {

        @Override
        public String name() {
            return "鱼";
        }
    }

    static class Insect implements Animal {

        @Override
        public String name() {
            return "虫子";
        }
    }

    public static Animal grabAnimal(int type) {
        switch (type) {
            case Const.ANIMAL_A:
                return new Insect();
            case Const.ANIMAL_B:
                return new Fish();
        }
        return null;
    }
}
