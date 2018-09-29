package com.example.bbarroo.awesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MFOF_del extends AppCompatActivity{
    Toolbar toolbar;
    int sel;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frag_4_del);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        TextView call_text = (TextView) findViewById(R.id.call_text);

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
        toolbar_title.setText("한강 배달");
        // getSupportActionBar().setTitle(name);
        //  actionBar.setTitle(name);


    }
}
