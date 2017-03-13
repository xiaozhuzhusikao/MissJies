package com.m520it.missjie.shop.bean;

/**
 * @author gezi
 * @time 2017/2/25  21:23
 * @desc ${TODD}
 */
public class ReturnResultBean {
    /**
     * success : true
     * errorMsg :
     * result : {"total":10,"rows":[{"id":1,"price":15,"name":"卜珂空气巧克力纯可可脂黑巧克力","iconUrl":"/img/p1.jpg","commentCount":1,"favcomRate":12},{"id":2,"price":16,"name":"士力架花生夹心巧克力家庭装460g（加量装随机发送）","iconUrl":"/img/p/lsj1.jpg","commentCount":1,"favcomRate":23},{"id":3,"price":17,"name":"德芙Dove醇黑巧克力66%（碗装）252g","iconUrl":"/img/p/df1.jpg","commentCount":1,"favcomRate":12},{"id":4,"price":19,"name":"歌斐颂 纯可可脂纯黑巧克力盒装320g 休闲零食大礼包糖果礼盒装","iconUrl":"/img/p/g2.jpg","commentCount":1,"favcomRate":23},{"id":5,"price":18,"name":"意大利进口 Ferrero Collection费列罗臻品巧克力礼盒24粒装259.2g","iconUrl":"/img/p/fll1.jpg","commentCount":1,"favcomRate":12},{"id":6,"price":99,"name":"芭喜/Baci 意大利进口婚庆喜糖盒装巧克力 榛仁黑巧克力100颗 年货量贩装 情人节礼物 黑巧","iconUrl":"/img/p/bx1.jpg","commentCount":1,"favcomRate":23},{"id":8,"price":25,"name":"怡浓 78%微苦纯黑巧克力120g礼盒装 纯可可脂浪漫情人节办公室休闲糖果零食品","iconUrl":"/img/p/yn1.jpg","commentCount":1,"favcomRate":23},{"id":9,"price":29,"name":"好时巧珍珠曲奇奶香白巧克力60g","iconUrl":"/img/p/hs1.jpg","commentCount":1,"favcomRate":23},{"id":10,"price":88,"name":"德芙巧克力礼盒320g装 送公仔/玫瑰花 牛奶/黑巧等多口味 节日/情人节礼物","iconUrl":"/img/p/df2.jpg","commentCount":1,"favcomRate":23},{"id":11,"price":78,"name":"怡浓夹心巧克力礼盒浪漫满屋年货礼盒325g纯脂巧克力生日白色浪漫情人节送女友","iconUrl":"/img/p/yn2.jpg","commentCount":1,"favcomRate":23}]}
     */

    private boolean success;
    private String errorMsg;
    private String result;

    @Override
    public String toString() {
        return "ReturnResultBean{" +
                "success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

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
}
