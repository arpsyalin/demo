package com.yl.thread;

/**
 * * @Description 有序性
 * * @Author 刘亚林
 * * @CreateDate 2020/10/24
 * * @Version 1.0
 * * @Remark TODO
 **/
public class Orderliness {
    static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            Thread one = new Thread(() -> {
                a = x;
                y = 1;
            });

            Thread other = new Thread(() -> {
                b = y;
                x = 1;
            });
            one.start();
            other.start();
            one.join();
            other.join();
            if (a == 0 && b == 1) { //机率最高
//                System.out.println("one先执行了.");
            } else if (a == 1 && b == 0) {//机率第二
//                System.out.println("other先执行了.");
            } else if (a == 0 && b == 0) {//机率很小
//                System.out.println("两个竟然相同应该是并行了.");
            } else {//机率更小
                System.out.println("重排序了，one先执行并且重排序了先执行y=1,other先执行重排序了执行了x=1");
            }
        }
    }
}
