package com.yl.design.structure;

/**
 * * @Description 代理模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO 为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。
 **/
public class Proxy {

    //服务代理类
    public static class ServerProxy implements IIP {
        RealIP mRealIP;

        @Override
        public String requestAddress() {
            if (mRealIP == null) {
                mRealIP = new RealIP();
            }
            System.out.println("访问到了：192.168.1.1");
            return mRealIP.requestAddress();
        }
    }

    interface IIP {
        String requestAddress();
    }

    public static class RealIP implements IIP {

        @Override
        public String requestAddress() {
            return "访问到了：192.168.1.2";
        }
    }

}
