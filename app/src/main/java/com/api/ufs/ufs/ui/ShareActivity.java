package com.api.ufs.ufs.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Анатолий on 29.08.2017.
 */

public class ShareActivity extends AppCompatActivity {

    public static final String ARGUMENT = "argument-url";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String arg = getIntent().getExtras().getString(ARGUMENT);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, arg);
        startActivity(sharingIntent);
    }
}
