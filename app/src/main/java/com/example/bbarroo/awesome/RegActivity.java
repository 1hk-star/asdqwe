package com.example.bbarroo.awesome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.w3c.dom.Text;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegActivity extends AppCompatActivity {

    TextView id;
    TextView pw;
    TextView nick;

    //retrofit이라는 라이브러리 사용 준비
    Retrofit retrofit;

    //만든 인터페이스 사용
    ApiService apiService;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        id = findViewById(R.id.id);
        pw = findViewById(R.id.pw);
        nick = findViewById(R.id.nick);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.interceptors().add(new AddCookiesInterceptor(this));
        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor(this));

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).client(okHttpClient.build()).build();
        apiService = retrofit.create(ApiService.class);

        RelativeLayout btn1 = (RelativeLayout)findViewById(R.id.goMain);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id_val = id.getText().toString();
                String pw_val = pw.getText().toString();
                String nick_val = nick.getText().toString();

                Call<ResponseBody> comment = apiService.post_regist(id_val,pw_val,nick_val);

                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            String res = response.body().string();
                            Log.i("Test2", res);

                            if(res.equals("2")||res.equals("3"))
                                Toast.makeText(RegActivity.this, "회원가입 실패!, 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                            else{
                                Toast.makeText(RegActivity.this, "회원가입 성공!", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(RegActivity.this,LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }


                        } catch (Exception e){
                            e.printStackTrace();
                            Log.i("Test1", "fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

              /*  Intent intent=new Intent(RegActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();*/
            }
        });

    }
}
