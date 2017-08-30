package com.api.ufs.ufs.ui.utilResycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.api.ufs.ufs.R;


/**
 * Created by vdaron on 19.08.17.
 */

enum ViewType {
    EVENTS {
        @Override
        public RecyclerView.ViewHolder getViewHolder(ViewGroup parent) {
            return new ItemEventsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.events_draw, parent, false));
        }
    },
    NEWS {
        @Override
        public RecyclerView.ViewHolder getViewHolder(ViewGroup parent) {
            return new ItemNewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_draw, parent, false));
        }
    },
    DIVIDER {
        @Override
        public RecyclerView.ViewHolder getViewHolder(ViewGroup parent) {
            return new DividerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_divider, parent, false));
        }
    },
    EMPTY {
        @Override
        public RecyclerView.ViewHolder getViewHolder(ViewGroup parent) {
            return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_middle, parent, false));
        }
    };

    abstract RecyclerView.ViewHolder getViewHolder(ViewGroup parent);
}
