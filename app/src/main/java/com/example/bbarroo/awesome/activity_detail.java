package com.example.bbarroo.awesome;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class activity_detail extends AppCompatActivity {

    int _id;
    //retrofit이라는 라이브러리 사용 준비
    Retrofit retrofit;
    //만든 인터페이스 사용
    ApiService apiService;

    TextView title;
    TextView when;
    TextView where;
    TextView content;
    String v_pic;
    ImageView img;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = findViewById(R.id.title2);
        when = findViewById(R.id.when);
        where = findViewById(R.id.where);
        content = findViewById(R.id.content);
        img = findViewById(R.id.img);

        Intent intent = getIntent();
        _id = intent.getExtras().getInt("_id");

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.interceptors().add(new AddCookiesInterceptor(activity_detail.this));
        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor(activity_detail.this));

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).client(okHttpClient.build()).build();
        apiService = retrofit.create(ApiService.class);

        Call<ResponseBody> comment = apiService.get_act_detail(_id);

        comment.enqueue(new Callback<ResponseBody>(){
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res = response.body().string();
                    Log.i("Test2", res);

                  //  JSONArray LVIarr=new JSONArray(res);
                    JSONObject lvi = new JSONObject(res);
                        String v_title=lvi.getString("title");
                        String v_where=lvi.getString("locate");
                        String v_content=lvi.getString("content");
                        String v_when=lvi.getString("date");
                        //v_pic = lvi.getString("pic");
                        v_pic = "https://t1.daumcdn.net/cfile/tistory/1946B11A4C5606ED3C";

                          new Thread() {
            public void run() {
                try {
                   /* String url = v_pic;
                    Log.i("thread", url);
                    InputStream is = (InputStream) new URL(url).getContent();
                    Bitmap bmp = BitmapFactory.decodeStream(is);
                    iconImageView.setImageBitmap(bmp);//Bitmap을 ImageView에 저장*/

                   URL url = new URL(v_pic);

                    URLConnection conn =

                            url.openConnection();

                    conn.connect();

                    BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

                    Bitmap bm = BitmapFactory.decodeStream(bis);
                    bis.close();

                    img.setImageBitmap(bm);

                } catch (Exception e) {
                }
            }
        }.start();

                        title.setText(v_title);
                        content.setText(v_content);
                        when.setText(v_when);
                        where.setText(v_where);

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
    }
}
