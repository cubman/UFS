package com.api.ufs.ufs.ui.utilResycler;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Анатолий on 30.08.2017.
 */

public class NewsActivity extends AppCompatActivity {
    public static final String ARGUMENT_URL = "argument-url";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        setContentView(webView);
        String url = getIntent().getExtras().getString(ARGUMENT_URL);
        webView.loadUrl(url);
    }
}
