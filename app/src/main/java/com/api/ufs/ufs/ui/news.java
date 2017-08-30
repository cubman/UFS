package com.api.ufs.ufs.ui;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.api.ufs.ufs.R;
import com.api.ufs.ufs.ui.api.MyServiceGenerator;
import com.api.ufs.ufs.ui.api.RestServiceApi;
import com.api.ufs.ufs.ui.models.newsmodel.NewsClicker;
import com.api.ufs.ufs.ui.models.newsmodel.NewsModel;
import com.api.ufs.ufs.ui.utilResycler.MyAdapterNews;
import com.api.ufs.ufs.ui.utilResycler.NewsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class news extends Fragment implements NewsClicker {

    private RecyclerView myRecyclerView;
    private MyAdapterNews myAdapter;
    private ArrayList<NewsModel> listNews = new ArrayList<>();
   // private NewsModel myNews;

    public news() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle(R.string.news);
        final View view = inflater.inflate(R.layout.fragment_news, container, false);

        myRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        final RestServiceApi restServiceApi = MyServiceGenerator.createService(RestServiceApi.class);

        restServiceApi.getNews("news").enqueue(new Callback<ArrayList<NewsModel>>() {
            @Override
            public void onResponse(Call<ArrayList<NewsModel>> call, Response<ArrayList<NewsModel>> response) {
                if (response.isSuccessful()) {
                    listNews = response.body();
                    myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    myAdapter = new MyAdapterNews(listNews, (news)getFragmentManager().findFragmentByTag("NewsTag"));
                    myRecyclerView.setAdapter(myAdapter);
                } else {
                    Log.i("Call API", "it's a not NewsFormat");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<NewsModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "it's fail", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    public void OnClick(NewsModel newsModel) {
        Intent intent = new Intent(getView().getContext(), NewsActivity.class);
        intent.putExtra(NewsActivity.ARGUMENT_URL, "http://ufc-data-api.ufc.com/api/v1/us/news/" + newsModel.getId());
        getView().getContext().startActivity(intent);
    }
}
