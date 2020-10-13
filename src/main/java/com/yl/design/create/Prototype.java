package com.yl.design.create;

import com.yl.Log;

/**
 * * @Description 原型模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark 将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。（属于对象创建型模式）
 **/
public class Prototype {

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
}
