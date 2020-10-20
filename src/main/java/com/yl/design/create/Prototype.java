package com.yl.design.create;

import com.yl.Log;

import java.util.Arrays;

/**
 * * @Description 原型模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark 将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。（属于对象创建型模式）
 **/
public class Prototype {
    //浅拷贝
    //主要是implements Cloneable接口
    public static class ImageFile implements Cloneable {
        String mPath;
        String mImageRes;

        public String getPath() {
            return mPath;
        }

        public void setPath(String path) {
            this.mPath = path;
        }

        public ImageFile(String path, String imageRes) {
            mPath = path;
            mImageRes = imageRes;
            Log.d("Create ImageFile");
        }

        //并且实现clone方法
        @Override
        public Object clone() throws CloneNotSupportedException {
            Log.d("clone ImageFile");
            return super.clone();
        }

        @Override
        public String toString() {
            return "ImageFile{" +
                    "mPath='" + mPath + '\'' +
                    ", mImageRes='" + mImageRes + '\'' +
                    '}';
        }
    }

    //深拷贝示例
    public static class User implements Cloneable {
        String mName;
        int[] mData;

        public User(String mName, int[] mData) {
            this.mName = mName;
            this.mData = mData;
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public int[] getmData() {
            return mData;
        }

        public void setmData(int[] mData) {
            this.mData = mData;
        }

        //并且实现clone方法
        @Override
        public Object clone() throws CloneNotSupportedException {
            Log.d("clone User");
            int[] data = new int[this.mData.length];
            System.arraycopy(this.mData, 0, data, 0, data.length);
            return new User(mName, data);
        }

        @Override
        public String toString() {
            return "User{" +
                    "mName='" + mName + '\'' +
                    ", mData=" + Arrays.toString(mData) +
                    '}';
        }
    }
}
