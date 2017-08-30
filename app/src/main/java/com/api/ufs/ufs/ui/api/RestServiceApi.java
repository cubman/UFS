package com.api.ufs.ufs.ui.api;

import com.api.ufs.ufs.ui.models.newsmodel.EventsModel;
import com.api.ufs.ufs.ui.models.newsmodel.NewsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vdaron on 12.08.17.
 */

public interface RestServiceApi {

@GET("api/v1/us/{api_path}")
    Call<ArrayList<NewsModel>> getNews(@Path("api_path") String apiPath);

    @GET("api/v1/us/{api_path}")
    Call<ArrayList<EventsModel>> getEvents(@Path("api_path") String apiPath);
}
