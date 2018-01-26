package com.myanmar.tmn.buroole.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by msi on 1/14/2018.
 */

public class GuidesVO {

    private String burppleGuideId;

    @SerializedName("img_burpple_guide_background")
    private String burppleGuideImage;

    @SerializedName("burpple-guide-title")
    private String burppleGuideTitle;

    private String burppleGuidedescription;


    public String getBurppleGuideId() {
        return burppleGuideId;
    }

    public String getBurppleGuideImage() {
        return burppleGuideImage;
    }

    public String getBurppleGuideTitle() {
        return burppleGuideTitle;
    }

    public String getBurppleGuidedescription() {
        return burppleGuidedescription;
    }
}
