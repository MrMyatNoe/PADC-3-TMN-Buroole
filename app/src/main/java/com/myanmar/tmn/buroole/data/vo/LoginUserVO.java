package com.myanmar.tmn.buroole.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by msi on 1/26/2018.
 */

public class LoginUserVO {

    @SerializedName("userId")
    private int userId;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("phoneNo")
    private String phoneNo;

    @SerializedName("profileUrl")
    private String profileUrl;

    @SerializedName("coverUrl")
    private String coverUrl;

    private List<FavFoodsVO> favFoods;

    private List<FavFoodPlacesVO> favFoodPlaces;

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public List<FavFoodsVO> getFavFoods() {
        return favFoods;
    }

    public List<FavFoodPlacesVO> getFavFoodPlaces() {
        return favFoodPlaces;
    }
}
