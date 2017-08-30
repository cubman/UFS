package com.api.ufs.ufs.ui;

import android.content.Context;
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
import com.api.ufs.ufs.ui.models.newsmodel.EventsModel;
import com.api.ufs.ufs.ui.utilResycler.MyAdapterEvents;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class events extends Fragment {

    private RecyclerView myRecyclerView;
    private MyAdapterEvents myAdapter;
    private ArrayList<EventsModel> listEvents = new ArrayList<>();

    public events() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle(R.string.events);
        final View view = inflater.inflate(R.layout.fragment_events, container, false);

        myRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view_enents);

        final RestServiceApi restServiceApi = MyServiceGenerator.createService(RestServiceApi.class);

        restServiceApi.getEvents("events").enqueue(new Callback<ArrayList<EventsModel>>() {
            @Override
            public void onResponse(Call<ArrayList<EventsModel>> call, Response<ArrayList<EventsModel>> response) {
                if (response.isSuccessful()) {
                    listEvents = response.body();
                    myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    myAdapter = new MyAdapterEvents(listEvents);
                    myRecyclerView.setAdapter(myAdapter);
                } else {
                    Log.i("Call API", "it's a not NewsFormat");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EventsModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "it's fail", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}