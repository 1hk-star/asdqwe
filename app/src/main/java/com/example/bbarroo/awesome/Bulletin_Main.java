package com.example.bbarroo.awesome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Bulletin_Main extends AppCompatActivity {
    public Bulletin_Main(){}
    Toolbar toolbar;
    int sel;
    Button btn_write;

    //retrofit이라는 라이브러리 사용 준비
    Retrofit retrofit;

    //만든 인터페이스 사용
    ApiService apiService;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletin_main);

        ListView listview = findViewById(R.id.listview1);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btn_write = (Button) findViewById(R.id.btn_write);
        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_title);

        Intent intent = getIntent();
        sel = intent.getExtras().getInt("name");
        String[] hangang_list = {"강서", "광나루","난지", "뚝섬", "반포", "망원", "양화", "여의도", "이촌", "잠실", "잠원"};
        String name="";

        for(int i =0; i<11; i++)
            if(sel==(i+1))
                name = hangang_list[i];

        //메뉴 이름 바꾸기
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar_title.setText(name);
       // getSupportActionBar().setTitle(name);
      //  actionBar.setTitle(name);


        Bulletin_LVA adapter = new Bulletin_LVA();
        listview.setAdapter(adapter);


        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.interceptors().add(new AddCookiesInterceptor(Bulletin_Main.this));
        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor(Bulletin_Main.this));

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).client(okHttpClient.build()).build();
        apiService = retrofit.create(ApiService.class);

        Call<ResponseBody> comment = apiService.get_board_list(sel,1);

        comment.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res = response.body().string();
                    Log.i("Test2", res);


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



        // 아이템 추가하는 방법 (제목, 내용, 이름, 시간)
       /* adapter.addItem("오늘 날씨 더워요","끈적끈적끈적 힘들어요","어사화","PM 07:15");
        adapter.addItem("핫섬머","집밖으로 안나오는게 승자","뀨뀨","PM 07:34");
        adapter.addItem("오늘 날씨 더워요","끈적끈적끈적 힘들어요","어사화","PM 07:15");
        adapter.addItem("핫섬머","집밖으로 안나오는게 승자","뀨뀨","PM 07:34");
        adapter.addItem("오늘 날씨 더워요","끈적끈적끈적 힘들어요","어사화","PM 07:15");
        adapter.addItem("핫섬머","집밖으로 안나오는게 승자","뀨뀨","PM 07:34");
        adapter.addItem("오늘 날씨 더워요","끈적끈적끈적 힘들어요","어사화","PM 07:15");
        adapter.addItem("핫섬머","집밖으로 안나오는게 승자","뀨뀨","PM 07:34");*/

       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Bulletin_Main.this, Bulletin_comment_main.class);
                intent.putExtra("name",sel);
                startActivity(intent);
            }
        });

       btn_write.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(Bulletin_Main.this, Bulletin_write.class);
               intent.putExtra("name",sel);
               startActivity(intent);
           }
       });
    }
}
