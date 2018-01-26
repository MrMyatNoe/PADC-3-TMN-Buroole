package com.myanmar.tmn.buroole.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by msi on 1/13/2018.
 */

public class PromotionsVO {

    private String promotionId;

    private String promotionImage;

    @SerializedName("burpple-promotion-title")
    private String promotionTitle;

    @SerializedName("burpple-promotion-until")
    private String promotionUntil;

    @SerializedName("burpple-promotion-shop")
    private PromotionShopVO promotionShopVO;

    private boolean isBurppleExclusive;

    private List<String> burpplePromotionItems;

    public String getPromotionId() {
        return promotionId;
    }

    public String getPromotionImage() {
        return promotionImage;
    }

    public String getPromotionTitle() {
        return promotionTitle;
    }

    public String getPromotionUntil() {
        return promotionUntil;
    }

    public PromotionShopVO getPromotionShopVO() {
        return promotionShopVO;
    }

    public boolean isBurppleExclusive() {
        return isBurppleExclusive;
    }

    public List<String> getBurpplePromotionItems() {
        return burpplePromotionItems;
    }
}
