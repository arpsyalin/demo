package com.yl.design.create;

/**
 * * @Description 建造者模式
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark 将一个复杂对象分解成多个相对简单的部分，然后根据不同需要分别创建它们，最后构建成该复杂对象。（属于对象创建型模式）
 **/
public class Builder {
    /**
     * * @Description 房间装修报价
     * * @Author 刘亚林
     * * @CreateDate 2020/10/14
     * * @Version 1.0
     * * @Remark 比如房间里需要放很多东西，如：沙发，电视，茶几
     **/
    public static class HouseDecoration {
        String sofa;
        String tv;
        String tea;

        public String getSofa() {
            return sofa;
        }

        public void setSofa(String sofa) {
            this.sofa = sofa;
        }

        public String getTv() {
            return tv;
        }

        public void setTv(String tv) {
            this.tv = tv;
        }

        public String getTea() {
            return tea;
        }

        public void setTea(String tea) {
            this.tea = tea;
        }

        @Override
        public String toString() {
            return "HouseDecoration{" +
                    "sofa='" + sofa + '\'' +
                    ", tv='" + tv + '\'' +
                    ", tea='" + tea + '\'' +
                    '}';
        }
    }

    /**
     * * @Description 整体报价
     * * @Author 刘亚林
     * * @CreateDate 2020/10/14
     * * @Version 1.0
     * * @Remark 比如房间里需要放很多东西，如：沙发，电视，茶几
     **/
    public static abstract class WholeOffer {
        HouseDecoration houseDecoration = new HouseDecoration();

        public abstract void offSofa();

        public abstract void offTV();

        public abstract void offTea();

        //返回报价
        HouseDecoration getHouseDecoration() {
            return houseDecoration;
        }
    }

    public static class PTSWholeOffer extends WholeOffer {

        @Override
        public void offSofa() {
            houseDecoration.setSofa("沙发,3200");
        }

        @Override
        public void offTV() {
            houseDecoration.setTv("电视,6200");
        }

        @Override
        public void offTea() {
            houseDecoration.setTea("茶几,1200");
        }
    }

    public static class MJWholeOffer extends WholeOffer {

        @Override
        public void offSofa() {
            houseDecoration.setSofa("沙发,6200");
        }

        @Override
        public void offTV() {
            houseDecoration.setTv("电视,5200");
        }

        @Override
        public void offTea() {
            houseDecoration.setTea("茶几,2200");
        }
    }

    //管理建造者的报价
    public static class HouseDecorationManager {
        private WholeOffer builder;

        public HouseDecorationManager(WholeOffer builder) {
            this.builder = builder;
        }

        //报价
        public HouseDecoration build() {
            builder.offSofa();
            builder.offTea();
            builder.offTV();
            return builder.getHouseDecoration();
        }
    }

    //链式反应调用
    public static class Request {
        String mMethod;
        String mUrl;

        public Request(String method, String url) {
            mMethod = method;
            mUrl = url;
        }

        public static class RequestBuilder {
            String method;
            String url;

            public RequestBuilder get() {
                method = "get";
                return this;
            }

            public RequestBuilder post() {
                method = "post";
                return this;
            }

            public RequestBuilder url(String u) {
                url = u;
                return this;
            }

            public Request build() {
                return new Request(method, url);
            }
        }

        @Override
        public String toString() {
            return "Request{" +
                    "mMethod='" + mMethod + '\'' +
                    ", mUrl='" + mUrl + '\'' +
                    '}';
        }
    }
}
