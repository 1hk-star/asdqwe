package com.example.bbarroo.awesome;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity{

    MFF_Main fragment1;
    MSF_Main fragment2;
    MTF_Main fragment3;
    MFOF_Main fragment4;
    MFFF_Main fragment5;
    Toolbar toolbar;
    ActionBar actionBar;
    TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
       // toolbar.setNavigationIcon(R.drawable.go_bulletin);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        toolbar_title.setText("홈");
        /*


        actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 하기 위해 필요
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        ImageButton toolbtn = (ImageButton) findViewById(R.id.toolbar_btn);

        View actionbar = inflater.inflate(R.layout.toolbar, null);
        actionBar.setCustomView(actionbar);
        Toolbar parent = (Toolbar)actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);*/
        /*LayoutInflater inflater1 = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View toolb = inflater1.inflate(R.layout.toolbar, null);*/

        fragment1 = new MFF_Main();
        fragment2 = new MSF_Main();
        fragment3 = new MTF_Main();
        fragment4 = new MFOF_Main();
        fragment5 = new MFFF_Main();
        LinearLayout btn_first = (LinearLayout)findViewById(R.id.button1);
        LinearLayout btn_second = (LinearLayout)findViewById(R.id.button2);
        LinearLayout btn_third = (LinearLayout)findViewById(R.id.button3);
        LinearLayout btn_fourth = (LinearLayout)findViewById(R.id.button4);
        LinearLayout btn_fifth = (LinearLayout)findViewById(R.id.button5);
        final ImageView img1 = (ImageView)findViewById(R.id.firstimg);
        final ImageView img2 = (ImageView)findViewById(R.id.secondimg);
        final ImageView img3 = (ImageView)findViewById(R.id.thirdimg);
        final ImageView img4 = (ImageView)findViewById(R.id.fourthimg);
        final ImageView img5 = (ImageView)findViewById(R.id.fifthimg);

      //  actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        //actionBar.setHomeAsUpIndicator(R.drawable.logo); //뒤로가기 버튼을 본인이 만든 아이콘으로 하기 위해 필요


        getSupportFragmentManager().beginTransaction().add(R.id.fragment,fragment1).commit();
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   TextView tooltext = (TextView)toolb.findViewById(R.id.toolid);
             //   tooltext.setText("홈");
               // actionBar = getSupportActionBar();
                toolbar_title.setText("홈");
               // actionBar.setTitle("홈");
                img1.setImageResource(R.drawable.home_yes);
                img2.setImageResource(R.drawable.activity_none);
                img3.setImageResource(R.drawable.community_none);
                img4.setImageResource(R.drawable.han_none);
                img5.setImageResource(R.drawable.inform_none);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment1).commit(); // 여러개의 명을 만들어서 쓴다
                // 꼭 commit 를 해주어야 실행이 된다. 플래그먼트 매니저가 플래그먼트를 담당 한다.
                // add라고해서 추가를 해주지 않고 replace를 써주는데, 기존에 있던것들을 대체 해 주게 된다.
            }
        });
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     TextView tooltext = (TextView)toolb.findViewById(R.id.toolid);
            //    tooltext.setText("액티비티");
                //actionBar = getSupportActionBar();
                //actionBar.setTitle("액티비티");
                toolbar_title.setText("액티비티");
                img1.setImageResource(R.drawable.home_none);
                img2.setImageResource(R.drawable.activity_yes);
                img3.setImageResource(R.drawable.community_none);
                img4.setImageResource(R.drawable.han_none);
                img5.setImageResource(R.drawable.inform_none);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment2).commit(); // 여러개의 명을 만들어서 쓴다
                // 꼭 commit 를 해주어야 실행이 된다. 플래그먼트 매니저가 플래그먼트를 담당 한다.
                // add라고해서 추가를 해주지 않고 replace를 써주는데, 기존에 있던것들을 대체 해 주게 된다.
            }
        });
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   TextView tooltext = (TextView)toolb.findViewById(R.id.toolid);
              //  tooltext.setText("커뮤니티");
              //  actionBar = getSupportActionBar();
              //  actionBar.setTitle("커뮤니티");
                toolbar_title.setText("커뮤니티");
                img1.setImageResource(R.drawable.home_none);
                img2.setImageResource(R.drawable.activity_none);
                img3.setImageResource(R.drawable.community_yes);
                img4.setImageResource(R.drawable.han_none);
                img5.setImageResource(R.drawable.inform_none);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment3).commit(); // 여러개의 명을 만들어서 쓴다
                // 꼭 commit 를 해주어야 실행이 된다. 플래그먼트 매니저가 플래그먼트를 담당 한다.
                // add라고해서 추가를 해주지 않고 replace를 써주는데, 기존에 있던것들을 대체 해 주게 된다.
            }
        });
        btn_fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  TextView tooltext = (TextView)toolb.findViewById(R.id.toolid);
             //   tooltext.setText("한강 정보");
             //   actionBar = getSupportActionBar();
             //   actionBar.setTitle("한강 정보");
                toolbar_title.setText("한강 정보");
                img1.setImageResource(R.drawable.home_none);
                img2.setImageResource(R.drawable.activity_none);
                img3.setImageResource(R.drawable.community_none);
                img4.setImageResource(R.drawable.han_yes);
                img5.setImageResource(R.drawable.inform_none);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment4).commit(); // 여러개의 명을 만들어서 쓴다
                // 꼭 commit 를 해주어야 실행이 된다. 플래그먼트 매니저가 플래그먼트를 담당 한다.
                // add라고해서 추가를 해주지 않고 replace를 써주는데, 기존에 있던것들을 대체 해 주게 된다.
            }
        });
        btn_fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    TextView tooltext = (TextView)toolb.findViewById(R.id.toolid);
            //    tooltext.setText("내 정보");
                //actionBar = getSupportActionBar();
              //  actionBar.setTitle("내 정보");
                toolbar_title.setText("내 정보");
                img1.setImageResource(R.drawable.home_none);
                img2.setImageResource(R.drawable.activity_none);
                img3.setImageResource(R.drawable.community_none);
                img4.setImageResource(R.drawable.han_none);
                img5.setImageResource(R.drawable.inform_yes);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment5).commit(); // 여러개의 명을 만들어서 쓴다
                // 꼭 commit 를 해주어야 실행이 된다. 플래그먼트 매니저가 플래그먼트를 담당 한다.
                // add라고해서 추가를 해주지 않고 replace를 써주는데, 기존에 있던것들을 대체 해 주게 된다.
            }
        });

    }



}
