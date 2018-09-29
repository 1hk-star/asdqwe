package com.example.bbarroo.awesome;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MFFF_Main extends Fragment {

    //retrofit이라는 라이브러리 사용 준비
    Retrofit retrofit;

    //만든 인터페이스 사용
    ApiService apiService;
    TextView nick;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.main_frag_5, container,false);
        TextView btn_logout = (TextView) view.findViewById(R.id.textView_logout);
        nick = view.findViewById(R.id.nick);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.interceptors().add(new AddCookiesInterceptor(getActivity()));
        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor(getActivity()));

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).client(okHttpClient.build()).build();
        apiService = retrofit.create(ApiService.class);

        Call<ResponseBody> comment = apiService.get_nick();

        comment.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                   try {
                       String res = response.body().string();
                       Log.i("Test2", res);

                       if (!res.equals(""))
                           nick.setText(res);
                       else
                           nick.setText("비로그인");

                       ///Intent intent=new Intent(getActivity(),MainActivity.class);
                       //  startActivity(intent);
                   }
                   catch (Exception e){

                   }
                }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }
}
