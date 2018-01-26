package com.myanmar.tmn.buroole.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.myanmar.tmn.buroole.BurooleApp;
import com.myanmar.tmn.buroole.event.LoadedGuidesEvent;
import com.myanmar.tmn.buroole.event.LoadedPromotionsEvent;
import com.myanmar.tmn.buroole.network.responses.GetGuidesResponse;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by msi on 1/14/2018.
 */

public class OKHttpGuidesDataAgent implements GuidesDataAgent {

    private static OKHttpGuidesDataAgent sObjectInstance;

    public OKHttpGuidesDataAgent() {
    }

    public static OKHttpGuidesDataAgent getsObjectInstance() {
        if (sObjectInstance == null) {
            sObjectInstance = new OKHttpGuidesDataAgent();
        }
        return sObjectInstance;
    }

    @Override
    public void loadGuides() {
        new LoadNewsTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getGuides.php");
    }

    private static class LoadNewsTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String url = urls[0];

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder()
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder() //3
                    .url(url)
                    .post(formBody)
                    .build();

            String responseString = null;
            try {
                Response response = httpClient.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null) {
                    responseString = response.body().string();
                }
            } catch (IOException e) {
                Log.e(BurooleApp.LOG_CAT, e.getMessage());
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            //build gson object
            Gson gson = new Gson();

            GetGuidesResponse getGuidesResponse = gson.fromJson(response, GetGuidesResponse.class);
            Log.d(BurooleApp.LOG_CAT, " size " + getGuidesResponse.getGuides().size());
            EventBus.getDefault().post(new LoadedGuidesEvent(getGuidesResponse.getGuides()));
        }
    }
}
