package com.example.bbarroo.awesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MFOF_detail extends AppCompatActivity {
    Toolbar toolbar;
    int sel;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frag_4_detail);

        ImageView img_main = (ImageView) findViewById(R.id.detail_image);
        ImageView img_com = (ImageView)findViewById(R.id.imageView_community);
        ImageView img_act = (ImageView)findViewById(R.id.imageView_activity);
        ImageView img_bad = (ImageView)findViewById(R.id.imageView_badal);
        ImageView img_map = (ImageView)findViewById(R.id.imageView_map);
        ImageView img_call = (ImageView)findViewById(R.id.imageView_call);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title = (TextView) findViewById(R.id.toolbar_title);


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
        //getSupportActionBar().setTitle(name);
        title.setText(name);

        if(name.equals("강서"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.gangseo_home));
        else if(name.equals("광나루"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.gwangnaru_home));
        else if(name.equals("난지"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.nanji_home));
        else if(name.equals("뚝섬"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.ttukseom_home));
        else if(name.equals("반포"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.banpo_home));
        else if(name.equals("망원"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.mangwon_home));
        else if(name.equals("양화"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.yanghwa_home));
        else if(name.equals("여의도"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.yeouido_home));
        else if(name.equals("이촌"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.leechon_home));
        else if(name.equals("잠실"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.jamsil_home));
        else if(name.equals("잠원"))
            img_main.setBackground(ContextCompat.getDrawable(this, R.drawable.jamwon_home));

        img_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MFOF_detail.this,Bulletin_Main.class);
                intent.putExtra("name", sel);
                startActivity(intent);
            }
        });
        img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MFOF_detail.this,MFOF_call.class);
                intent.putExtra("name", sel);
                startActivity(intent);
            }
        });
        img_bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MFOF_detail.this,MFOF_del.class);
                intent.putExtra("name", sel);
                startActivity(intent);
            }
        });
       /* img_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MFOF_detail.this, MFOF_map.class);
                intent.putExtra("name", sel);
                startActivity(intent);
            }
        });*/

    }
}
