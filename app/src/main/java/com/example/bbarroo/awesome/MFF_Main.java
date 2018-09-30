package com.example.bbarroo.awesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MFF_Main extends android.support.v4.app.Fragment {
    public MFF_Main(){}

    MFF_LVA adapter;

    String res;
    JsonParser jp=new JsonParser();

    //retrofit이라는 라이브러리 사용 준비
    Retrofit retrofit;

    //만든 인터페이스 사용
    ApiService apiService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.main_frag_1, container,false);
        ListView listview = view.findViewById(R.id.listview1);
        adapter = new MFF_LVA() ;
        listview.setAdapter(adapter);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.interceptors().add(new AddCookiesInterceptor(getActivity()));
        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor(getActivity()));

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).client(okHttpClient.build()).build();
        apiService = retrofit.create(ApiService.class);

        Call<ResponseBody> comment = apiService.post_act_first();

        comment.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    res = response.body().string();
                    Log.i("출력", res);
                    //Log.i("Test2", res);

                    JSONArray LVIarr=new JSONArray(res);
                    for(int i=0; i<LVIarr.length(); i++){
                        JSONObject lvi=LVIarr.getJSONObject(i);
                        String title=lvi.getString("title");
                        int like=lvi.getInt("likes");
                        int _id=lvi.getInt("_id");

                        adapter.addItem("https://t1.daumcdn.net/cfile/tistory/1946B11A4C5606ED3C",title,like,_id);
                    }

                    adapter.notifyDataSetChanged();



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



        // 아이템 추가하는 방법 (표시하고픈 사진, 이름, 좋아요 수)
        /*adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ttukseom_home),"한강공원 너무 재밌어요~~",15);
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.banpo_home),"반포공원 너무 이뻐요~~",200);
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ttukseom_home),"한강공원 너무 재밌어요~~",15);
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.banpo_home),"반포공원 너무 이뻐요~~",200);*/
        //adapter.getwhere(position).toString()
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), activity_detail.class);
                intent.putExtra("_id",adapter.get_id(position));
                startActivity(intent);
            }
        });

        return view;

    }

}
