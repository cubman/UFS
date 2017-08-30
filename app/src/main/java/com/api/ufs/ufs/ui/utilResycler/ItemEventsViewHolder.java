package com.api.ufs.ufs.ui.utilResycler;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.ufs.ufs.R;
import com.api.ufs.ufs.ui.ShareActivity;
import com.api.ufs.ufs.ui.models.newsmodel.EventsModel;
import com.api.ufs.ufs.ui.models.newsmodel.NewsModel;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vdaron on 19.08.17.
 */

public class ItemEventsViewHolder extends RecyclerView.ViewHolder {

    private TextView titleEvent;
    private TextView dateEvent;
    private TextView arenaEvent;
    private TextView arenaLocation;

    private Button button;

    public ItemEventsViewHolder(View itemView) {
        super(itemView);
        titleEvent = (TextView) itemView.findViewById(R.id.title_event);
        dateEvent = (TextView) itemView.findViewById(R.id.time_event);
        arenaEvent = (TextView) itemView.findViewById(R.id.arena_event);
        arenaLocation = (TextView) itemView.findViewById(R.id.location_event);
        button = (Button)itemView.findViewById(R.id.buttonShare);
    }

    void bind(EventsModel eventsModel) {
        titleEvent.setText(eventsModel.getTitle_tag_line());
        arenaEvent.setText(String.valueOf(eventsModel.getArena()));
        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
        dateEvent.setText(formatter.format(eventsModel.getEvent_dategmt()));
        arenaLocation.setText(String.valueOf(eventsModel.getLocation()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShareActivity.class);
                intent.putExtra(ShareActivity.ARGUMENT, String.format("%s\n%s: %s\n%s: %s\n%s: %s",
                        titleEvent.getText(),
                        view.getContext().getResources().getString(R.string.date), dateEvent.getText(),
                        view.getContext().getResources().getString(R.string.arena), arenaEvent.getText(),
                        view.getContext().getResources().getString(R.string.location), arenaLocation.getText()));
                view.getContext().startActivity(intent);
            }
        });
    }
}
