package com.example.bbarroo.awesome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    TextView btn_email;
    TextView btn_pw;

    //retrofit이라는 라이브러리 사용 준비
    Retrofit retrofit;

    //만든 인터페이스 사용
    ApiService apiService;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        RelativeLayout btn1 = (RelativeLayout)findViewById(R.id.goMain);
        TextView btn2 = (TextView)findViewById(R.id.textView4);
        btn_email = findViewById(R.id.email);
        btn_pw = findViewById(R.id.pw);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.interceptors().add(new AddCookiesInterceptor(this));
        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor(this));

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).client(okHttpClient.build()).build();
        apiService = retrofit.create(ApiService.class);


        //로그인버튼
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email_val = btn_email.getText().toString();
                String pw_val = btn_pw.getText().toString();
                Call<ResponseBody> comment = apiService.post_login(email_val,pw_val);

                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            String res = response.body().string();
                            Log.i("Test2", res);

                            if(res.equals("fail"))
                                Toast.makeText(LoginActivity.this, "로그인 실패!, 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                            else{
                                Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
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

            }
        });

        //회원가입창 이동
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
