package com.example.bbarroo.awesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MFOF_call extends AppCompatActivity {
    Toolbar toolbar;
    int sel;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frag_4_call);

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
        toolbar_title.setText(name);
        // getSupportActionBar().setTitle(name);
        //  actionBar.setTitle(name);

        if(name.equals("강서"))
            call_text.setText("강서 안내센터 02-3780-0621~3");
        else if(name.equals("광나루"))
            call_text.setText("광나루 안내센터 02)3780-0501");
        else if(name.equals("난지"))
            call_text.setText("난지 안내센터 02)3780-0611~2");
        else if(name.equals("뚝섬"))
            call_text.setText("뚝섬 안내센터 02)3780-0521");
        else if(name.equals("반포"))
            call_text.setText("반포 안내센터 02)591-5943");
        else if(name.equals("망원"))
            call_text.setText("망원 안내센터 02)3780-0601");
        else if(name.equals("양화"))
            call_text.setText("양화 안내센터 02)3780-0581");
        else if(name.equals("여의도"))
            call_text.setText("여의도 안내센터 02)3780-0561");
        else if(name.equals("이촌"))
            call_text.setText("이촌 안내센터 02)3780-0551");
        else if(name.equals("잠실"))
            call_text.setText("잠실 안내센터 02)3780-0511");
        else if(name.equals("잠원"))
            call_text.setText("잠원 안내센터 02)3780-0531");
    }
}
