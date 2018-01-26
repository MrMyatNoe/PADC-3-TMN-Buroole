package com.myanmar.tmn.buroole.network;

import com.google.gson.Gson;
import com.myanmar.tmn.buroole.event.LoadedPromotionsEvent;
import com.myanmar.tmn.buroole.network.responses.GetPromotionsResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by msi on 1/13/2018.
 */


public class PromotionsRetrofitDataAgent implements PromotionDataAgent {

    private static PromotionsRetrofitDataAgent sObjectInstance;

    private PromotionsApi  promotionsApi;

    public static PromotionsRetrofitDataAgent getsObjectInstance() {
        if (sObjectInstance == null){
            sObjectInstance = new PromotionsRetrofitDataAgent();
        }
        return sObjectInstance;
    }

    private PromotionsRetrofitDataAgent() {
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

        promotionsApi = retrofit.create(PromotionsApi.class);
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
}
