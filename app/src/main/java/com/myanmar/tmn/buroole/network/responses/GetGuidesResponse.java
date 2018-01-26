package com.myanmar.tmn.buroole.network.responses;

import com.google.gson.annotations.SerializedName;
import com.myanmar.tmn.buroole.data.vo.GuidesVO;

import java.util.List;

/**
 * Created by msi on 1/14/2018.
 */

public class GetGuidesResponse {

    private int code;

    private String message;

    private String apiVersion;

    private String page;

    @SerializedName("featured")
    private List<GuidesVO> guides;

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

    public List<GuidesVO> getGuides() {
        return guides;
    }
}
