package com.example.bbarroo.bottombar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActivityActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(Html.fromHtml("<u>" + "군고구마 빨리 먹기 대회" + "</u>"));
        ImageButton button1 =(ImageButton)findViewById(R.id.imageView3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
