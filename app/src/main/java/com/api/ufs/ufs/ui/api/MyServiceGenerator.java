package com.api.ufs.ufs.ui.api;

import android.support.mediacompat.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Анатолий on 28.08.2017.
 */

public class MyServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    public static final String API_URL = "http://ufc-data-api.ufc.com/";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_URL)
            .client(getClientLogger().build())
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    private static OkHttpClient.Builder getClientLogger() {
        HttpLoggingInterceptor loger = new HttpLoggingInterceptor();
        loger.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(loger);
        return httpClient;
    }
}