package com.myanmar.tmn.buroole.network;

import com.myanmar.tmn.buroole.network.responses.GetGuidesResponse;
import com.myanmar.tmn.buroole.network.responses.GetPromotionsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by msi on 1/13/2018.
 */

public interface GuidesApi {

    @FormUrlEncoded
    @POST("getGuides.php")
    Call<GetGuidesResponse> getGuides(@Field("page") int page,
                                               @Field("access_token") String accessToken);
}
