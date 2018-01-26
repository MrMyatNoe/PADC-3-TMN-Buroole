package com.myanmar.tmn.buroole.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by msi on 1/13/2018.
 */

public class PromotionShopVO {

    private String buppleShopId;

    @SerializedName("burpple-shop-name")
    private String buppleShopName;

    @SerializedName("burpple-shop-area")
    private String burppleShopArea;

    public String getBuppleShopId() {
        return buppleShopId;
    }

    public String getBuppleShopName() {
        return buppleShopName;
    }

    public String getBurppleShopArea() {
        return burppleShopArea;
    }
}
