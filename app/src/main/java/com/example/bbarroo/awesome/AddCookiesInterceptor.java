package com.example.bbarroo.awesome;

import android.app.DownloadManager;
import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor{

    SharedPreferenceBase mSharedPreferenceBase;

    public AddCookiesInterceptor (Context context) {
        mSharedPreferenceBase = SharedPreferenceBase.getInstanceOf(context);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        //Preference에서 cookies를 가져오는 작업을 수행
        HashSet<String> cookies = (HashSet<String>) mSharedPreferenceBase.getSharedPreferences(
                SharedPreferenceBase.SHARED_PREFERENCE_NAME_COOKIE,new HashSet<String>());

        for(String cookie : cookies) {
            builder.addHeader("Cookie", cookie);
        }

        //Web, Android, ios 구분을 위해 User-Agent세팅
        builder.removeHeader("User-Agent").addHeader("User-Agent","Android");

        return chain.proceed(builder.build());
    }

}
