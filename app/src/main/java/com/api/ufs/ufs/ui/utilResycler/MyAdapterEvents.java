package com.api.ufs.ufs.ui.utilResycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.api.ufs.ufs.ui.models.newsmodel.EventsModel;
import com.api.ufs.ufs.ui.models.newsmodel.NewsModel;

import java.util.ArrayList;
import java.util.List;


public class MyAdapterEvents extends RecyclerView.Adapter {

    private List<EventsModel> listNews;
    private List<Item> items = new ArrayList<>();

    public MyAdapterEvents(List<EventsModel> listNews) {
        this.listNews = listNews;
        buildAdapter();
    }

    private void buildAdapter() {
        items.clear();

        for (int i = 0; i < listNews.size(); i++) {
            EventsModel article = listNews.get(i);

                items.add(new Item(ViewType.EMPTY));
                items.add(new Item(ViewType.EVENTS, article));

        }
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewType.values()[viewType].getViewHolder(parent);
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).viewType.ordinal();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = items.get(position);
        switch (item.viewType) {

            case EVENTS:
                ((ItemEventsViewHolder) holder).bind((EventsModel) item.object);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class Item {
        private ViewType viewType;
        private Object object;

        public Item(ViewType vt, Object o) {
            this.viewType = vt;
            this.object = o;
        }

        public Item(ViewType vt) {
            this.viewType = vt;
        }
    }
}
