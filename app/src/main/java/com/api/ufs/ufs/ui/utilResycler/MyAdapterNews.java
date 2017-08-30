package com.api.ufs.ufs.ui.utilResycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.api.ufs.ufs.ui.models.newsmodel.NewsClicker;
import com.api.ufs.ufs.ui.models.newsmodel.NewsModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MyAdapterNews extends RecyclerView.Adapter {

    private List<NewsModel> listNews;
    private List<Item> items = new ArrayList<>();
    private NewsClicker newsClicker;

    public MyAdapterNews(List<NewsModel> listNews, NewsClicker newsClicker) {
        this.listNews = listNews;
        this.newsClicker = newsClicker;
        buildAdapter();
    }

    private void buildAdapter() {
        items.clear();

        for (int i = 0; i < listNews.size(); i++) {
            NewsModel article = listNews.get(i);

                items.add(new Item(ViewType.EMPTY));
                items.add(new Item(ViewType.NEWS, article));

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

            case NEWS:
                ((ItemNewsViewHolder) holder).bind((NewsModel) item.object, newsClicker);
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
