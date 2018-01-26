package com.myanmar.tmn.buroole.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by msi on 1/26/2018.
 */

public class FavFoodPlacesVO {

    @SerializedName("favorite_food_place_id")
    private int favouriteId;

    @SerializedName("title")
    private String title;

    @SerializedName("address")
    private String address;

    @SerializedName("photoUrl")
    private String photoUrl;

    public int getFavouriteId() {
        return favouriteId;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
