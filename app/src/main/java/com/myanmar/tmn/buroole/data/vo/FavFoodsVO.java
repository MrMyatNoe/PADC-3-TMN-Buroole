package com.myanmar.tmn.buroole.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by msi on 1/26/2018.
 */

public class FavFoodsVO {

    @SerializedName("favorite_food_id")
    private int favFoodId;

    @SerializedName("title")
    private String title;

    @SerializedName("photoUrl")
    private String photoUrl;

    public int getFavFoodId() {
        return favFoodId;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
