package com.example.bbarroo.bottombar;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

public class FourthYeoui extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeoui_4);
        ListView listview ;
        Yeoui_LVAdapter_C adapter;

        adapter = new Yeoui_LVAdapter_C() ;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.rgb(140,220,255));
        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem("졸려","언제끝나",12,24) ;
        // 두 번째 아이템 추가.
        adapter.addItem("창밖을 보면","비는 오는데 괜시리 맘만 울적해~ 공허한 맘을 달래줄 사람 없네 잠도 오지 않는 밤메에에",24,48) ;
        // 세 번째 아이템 추가.
        adapter.addItem("내가 셋 셀테니 딱 넌 넘어와","원트뚜리",12445,7);
    }

}
