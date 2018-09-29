package com.example.bbarroo.awesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Bulletin_write  extends AppCompatActivity {

    Toolbar toolbar;
    Button btn_write;
    ActionBar actionBar;
    int sel;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletin_wirte);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btn_write = (Button) findViewById(R.id.btn_write);
        TextView title = (TextView) findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setTitle(name);
        title.setText("새 글 작성");
        //actionBar.setTitle("새 글 작성");

        Intent intent = getIntent();
        sel = intent.getExtras().getInt("name");

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Bulletin_write.this, Bulletin_Main.class);
                intent.putExtra("name",sel);
                startActivity(intent);
            }
        });

    }
}
