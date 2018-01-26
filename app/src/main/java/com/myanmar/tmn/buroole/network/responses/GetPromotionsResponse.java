package com.myanmar.tmn.buroole.network.responses;

import com.google.gson.annotations.SerializedName;
import com.myanmar.tmn.buroole.data.vo.PromotionsVO;

import java.util.List;

/**
 * Created by msi on 1/13/2018.
 */

public class GetPromotionsResponse {

    private int code;

    private String message;

    private String apiVersion;

    private String page;

    @SerializedName("promotions")
    private List<PromotionsVO> promotions;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<PromotionsVO> getPromotions() {
        return promotions;
    }
}
