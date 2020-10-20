package com.yl.design.structure;

import com.yl.Log;

import java.util.ArrayList;

/**
 * * @Description 组合
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO 将对象组合成树状层次结构，使用户对单个对象和组合对象具有一致的访问性。
 **/
public class Composite {
    public interface IParts {
        float calc();

        void show();
    }

    public static class ComputerParts implements IParts {
        String mName;
        private int mQuantity;    //数量
        private float mUnitPrice; //单价

        public ComputerParts(String name, int quantity, float unitPrice) {
            this.mName = name;
            this.mQuantity = quantity;
            this.mUnitPrice = unitPrice;
        }

        @Override
        public float calc() {
            return mQuantity * mUnitPrice;
        }

        @Override
        public void show() {
            Log.d(mName + "(数量：" + mQuantity + "，单价：" + mUnitPrice + "元)");
        }

    }

    public static class Computer implements IParts {
        ArrayList<IParts> mComputerPartsList = new ArrayList<>();

        public Computer() {
        }

        public Computer addParts(IParts... parts) {
            for (IParts iParts : parts) {
                if (!mComputerPartsList.contains(iParts)) {
                    Log.d("添加配件成功");
                    mComputerPartsList.add(iParts);
                } else {
                    Log.d("已有添加配件失败");
                }
            }
            return this;
        }


        public Computer removeParts(IParts parts) {
            if (mComputerPartsList.contains(parts)) {
                Log.d("移除配件成功");
                mComputerPartsList.remove(parts);
            } else {
                Log.d("移除配件失败");
            }
            return this;
        }

        @Override
        public float calc() {
            float sum = 0;
            for (IParts iParts : mComputerPartsList) {
                sum += iParts.calc();
            }
            Log.d("总价：" + sum);
            return sum;
        }

        @Override
        public void show() {
            for (IParts iParts : mComputerPartsList) {
                iParts.show();
            }
        }
    }
}
