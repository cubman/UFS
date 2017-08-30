package com.api.ufs.ufs.ui.utilResycler;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.ufs.ufs.R;
import com.api.ufs.ufs.ui.ShareActivity;
import com.api.ufs.ufs.ui.models.newsmodel.NewsClicker;
import com.api.ufs.ufs.ui.models.newsmodel.NewsModel;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static java.security.AccessController.getContext;

/**
 * Created by vdaron on 19.08.17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView titleNews;
    private TextView titleIdNews;
    private ImageView imageNews;
    private TextView timeNews;

    private NewsClicker clickListener;
    private NewsModel newsModel;

    public ItemNewsViewHolder(View itemView) {
        super(itemView);
        titleNews = (TextView) itemView.findViewById(R.id.title_news);
        titleIdNews = (TextView) itemView.findViewById(R.id.idNews);
        imageNews = (ImageView) itemView.findViewById(R.id.image_news);
        timeNews = (TextView) itemView.findViewById(R.id.time_news);
        itemView.setOnClickListener(this);

    }

    void bind(NewsModel newsModel, NewsClicker clickListener) {
        this.clickListener = clickListener;
        this.newsModel = newsModel;

        titleNews.setText(newsModel.getTitle());
        titleIdNews.setText(String.valueOf(newsModel.getId()));
        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
        timeNews.setText(formatter.format(newsModel.getPublished_start_date()));


        try {
            if (newsModel.getThumbnail() != null && !newsModel.getThumbnail().equals("")) {
                imageNews.setVisibility(View.VISIBLE);
                Picasso.with(itemView.getContext())
                        .load(newsModel.getThumbnail())
                        .resize(500, 400)
                        .centerCrop()
                        .into(imageNews);
            } else {
                imageNews.setVisibility(View.GONE);
            }
        }
        catch (Exception e){
            imageNews.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        if (clickListener != null && newsModel != null) {
            clickListener.OnClick(newsModel);
        }

    }
}
