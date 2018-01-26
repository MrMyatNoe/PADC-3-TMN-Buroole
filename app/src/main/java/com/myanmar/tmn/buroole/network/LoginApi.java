package com.myanmar.tmn.buroole.network;

import com.myanmar.tmn.buroole.network.responses.GetLoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by msi on 1/26/2018.
 */

public interface LoginApi {

    @FormUrlEncoded
    @POST("login.php")
    Call<GetLoginResponse> getLogin(@Field("phoneNo") String phone,@Field("password") String password);
}
