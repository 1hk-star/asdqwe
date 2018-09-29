package com.example.bbarroo.awesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Bulletin_comment_main extends AppCompatActivity {

    int sel;
    TextView btn_comment;
    Bulletin_comment_LVA adapter;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletin_detail);
       ListView listview = findViewById(R.id.comment);
        btn_comment = findViewById(R.id.comment_write);

        Intent intent = getIntent();
        sel = intent.getExtras().getInt("name");

        adapter = new Bulletin_comment_LVA() ;
        listview.setAdapter(adapter);


        // 아이템 추가하는 방법 (제목, 내용, 이름, 시간)
        adapter.addItem("어사화ㅂㅈ더ㅏㅣㅁㄴ으","어사화ㄷㄷ");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");
        adapter.addItem("어서ㅂㅈㄷㅂ와","모두너");

        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent=new Intent(Bulletin_comment_main.this, Bulletin_Main.class);
                intent.putExtra("name",sel);
                startActivity(intent);*/

                adapter.notifyDataSetChanged();
            }
        });
    }
}
