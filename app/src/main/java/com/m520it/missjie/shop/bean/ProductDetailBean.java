package com.m520it.missjie.shop.bean;

import java.util.List;

/**
 * @author gezi
 * @time 2017/3/8  21:42
 * @desc ${TODD}
 */
public class ProductDetailBean {

    /**
     * success : true
     * errorMsg :
     * result : {"id":10,"imgUrls":["/img/p/df2.jpg","/img/info/pp1.jpg","/img/info/pp2.jpg","/img/info/pp3.jpg"],"price":88,"ifSaleOneself":true,"name":"德芙巧克力礼盒320g装 送公仔/玫瑰花 牛奶/黑巧等多口味 节日/情人节礼物","timeLeft":40,"recomProductId":"2","stockCount":525570,"commentCount":1,"typeList":["麦片巧克力","8口\u200b味速融巧克力松露形"],"favcomRate":23,"recomProduct":"2"}
     */

    private boolean success;
    private String errorMsg;
    private String result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ProductDetailBean{" +
                "success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public static class ResultBean {
        /**
         * id : 10
         * imgUrls : ["/img/p/df2.jpg","/img/info/pp1.jpg","/img/info/pp2.jpg","/img/info/pp3.jpg"]
         * price : 88
         * ifSaleOneself : true
         * name : 德芙巧克力礼盒320g装 送公仔/玫瑰花 牛奶/黑巧等多口味 节日/情人节礼物
         * timeLeft : 40
         * recomProductId : 2
         * stockCount : 525570
         * commentCount : 1
         * typeList : ["麦片巧克力","8口\u200b味速融巧克力松露形"]
         * favcomRate : 23
         * recomProduct : 2
         */

        private long id;
        private double price;
        private boolean ifSaleOneself;
        private String name;
        private int timeLeft;
        private String recomProductId;
        private int stockCount;
        private int commentCount;
        private double favcomRate;
        private String recomProduct;
        private List<String> imgUrls;
        private List<String> typeList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "id=" + id +
                    ", price=" + price +
                    ", ifSaleOneself=" + ifSaleOneself +
                    ", name='" + name + '\'' +
                    ", timeLeft=" + timeLeft +
                    ", recomProductId='" + recomProductId + '\'' +
                    ", stockCount=" + stockCount +
                    ", commentCount=" + commentCount +
                    ", favcomRate=" + favcomRate +
                    ", recomProduct='" + recomProduct + '\'' +
                    ", imgUrls=" + imgUrls +
                    ", typeList=" + typeList +
                    '}';
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isIfSaleOneself() {
            return ifSaleOneself;
        }

        public void setIfSaleOneself(boolean ifSaleOneself) {
            this.ifSaleOneself = ifSaleOneself;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTimeLeft() {
            return timeLeft;
        }

        public void setTimeLeft(int timeLeft) {
            this.timeLeft = timeLeft;
        }

        public String getRecomProductId() {
            return recomProductId;
        }

        public void setRecomProductId(String recomProductId) {
            this.recomProductId = recomProductId;
        }

        public int getStockCount() {
            return stockCount;
        }

        public void setStockCount(int stockCount) {
            this.stockCount = stockCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public double getFavcomRate() {
            return favcomRate;
        }

        public void setFavcomRate(double favcomRate) {
            this.favcomRate = favcomRate;
        }

        public String getRecomProduct() {
            return recomProduct;
        }

        public void setRecomProduct(String recomProduct) {
            this.recomProduct = recomProduct;
        }

        public List<String> getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(List<String> imgUrls) {
            this.imgUrls = imgUrls;
        }

        public List<String> getTypeList() {
            return typeList;
        }

        public void setTypeList(List<String> typeList) {
            this.typeList = typeList;
        }
    }
}
