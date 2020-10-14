package com.yl.design.structure;

/**
 * * @Description 桥接模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO 将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现的，从而降低了抽象和实现这两个可变维度的耦合度。
 **/
public class Bridge {
    interface ISystem {
        String systemName();
    }

    public static class Unix implements ISystem {

        @Override
        public String systemName() {
            return "Unix";
        }
    }

    public static class Linux implements ISystem {

        @Override
        public String systemName() {
            return "Linux";
        }
    }

    interface IFileFormat {
        String format();
    }

    public static class AVI implements IFileFormat {

        @Override
        public String format() {
            return "AVI";
        }
    }

    public static class MP4 implements IFileFormat {

        @Override
        public String format() {
            return "MP4";
        }
    }

    public static abstract class MediaPlay {
        protected IFileFormat mIFileFormat;
        protected ISystem mISystem;

        public MediaPlay(IFileFormat format, ISystem system) {
            mIFileFormat = format;
            mISystem = system;
        }

        public abstract String play();
    }

    public static class LYLMediaPlay extends MediaPlay {

        public LYLMediaPlay(IFileFormat format, ISystem system) {
            super(format, system);
        }

        @Override
        public String play() {
            return "当前播放：文件格式：" + mIFileFormat.format() + "；系统类型：" + mISystem.systemName();
        }
    }
}
