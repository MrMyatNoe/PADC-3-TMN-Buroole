package com.myanmar.tmn.buroole.network;

import com.google.gson.Gson;
import com.myanmar.tmn.buroole.event.LoadedGuidesEvent;
import com.myanmar.tmn.buroole.event.LoadedPromotionsEvent;
import com.myanmar.tmn.buroole.event.SuccessUserEvent;
import com.myanmar.tmn.buroole.network.responses.GetGuidesResponse;
import com.myanmar.tmn.buroole.network.responses.GetLoginResponse;
import com.myanmar.tmn.buroole.network.responses.GetPromotionsResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgent implements GuidesDataAgent,PromotionDataAgent, LoginDataAgent{

    private static RetrofitDataAgent sObjectInstance;

    private GuidesApi guidesApi;

    private PromotionsApi promotionsApi;

    private LoginApi loginApi;

    public static RetrofitDataAgent getsObjectInstance() {
        if (sObjectInstance == null){
            sObjectInstance = new RetrofitDataAgent();
        }
        return sObjectInstance;
    }

    private RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        guidesApi = retrofit.create(GuidesApi.class);

        promotionsApi = retrofit.create(PromotionsApi.class);
    }

    @Override
    public void loadGuides() {
        Call<GetGuidesResponse> getGuidesResponseCall = guidesApi
                .getGuides(1,"b002c7e1a528b7cb460933fc2875e916");
        getGuidesResponseCall.enqueue(new Callback<GetGuidesResponse>() {
            @Override
            public void onResponse(Call<GetGuidesResponse> call, Response<GetGuidesResponse> response) {
                GetGuidesResponse getGuidesResponse = response.body();
                if (getGuidesResponse != null){
                    EventBus.getDefault().post(new LoadedGuidesEvent(getGuidesResponse.getGuides()));
                }

            }

            @Override
            public void onFailure(Call<GetGuidesResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadPromotion() {
        Call<GetPromotionsResponse> getPromotionsResponseCall = promotionsApi
                .getPromotion(1,"b002c7e1a528b7cb460933fc2875e916");
        getPromotionsResponseCall.enqueue(new Callback<GetPromotionsResponse>() {
            @Override
            public void onResponse(Call<GetPromotionsResponse> call, Response<GetPromotionsResponse> response) {
                GetPromotionsResponse getPromotionsResponse = response.body();
                if (getPromotionsResponse != null) {
                    EventBus.getDefault().post(new LoadedPromotionsEvent(getPromotionsResponse.getPromotions()));
                }
            }

            @Override
            public void onFailure(Call<GetPromotionsResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loginUser(String phone, String password) {
        Call<GetLoginResponse> getLoginResponseCall = loginApi.getLogin(phone,
                password);
        getLoginResponseCall.enqueue(new Callback<GetLoginResponse>() {
            @Override
            public void onResponse(Call<GetLoginResponse> call, Response<GetLoginResponse> response) {
                GetLoginResponse getLoginResponse = response.body();
                if (getLoginResponse != null){
                    EventBus.getDefault().post(new SuccessUserEvent(getLoginResponse.getLoginUserVO()));
                }
            }

            @Override
            public void onFailure(Call<GetLoginResponse> call, Throwable t) {

            }
        });
    }
}

