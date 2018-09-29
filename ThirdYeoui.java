package com.example.bbarroo.bottombar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class ThirdYeoui extends Fragment{
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.yeoui_3, container, false);
        WebView webview;
        webview = (WebView) view.findViewById(R.id.webView);
        webview.loadUrl("http://hangang.seoul.go.kr/archives/46758");
        return view;

    }
}
