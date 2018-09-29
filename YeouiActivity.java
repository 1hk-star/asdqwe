package com.example.bbarroo.bottombar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class YeouiActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    private ImageButton btnShowNavigationDrawer;

    //ActionBarDrawerToggle 요녀석 android.support.v7꺼 써야한다.
    //android.support.v4는 이제 사용 안하니까... deprecated대써...
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Fragment fragment = new FirstYeoui();
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeoui);

        //Style에서 NoActionBar로 ActionBar를 Disable 시켰으니
        //우리가 ActionBar처럼 사용 할 toolbar를 ActionBar처럼
        //사용하기위해 setSupportActionBar에 설정해준다.
        //주의 할 점은 xml에 <include>의 id를 가져와서 설정하는것에 유의
        toolbar = (Toolbar) findViewById(R.id.toolbarInclude);
        toolbar.setBackgroundColor(Color.rgb(140,220,255));
        setSupportActionBar(toolbar);

        //여기서 setContentView로 설정되어있는건 activity_main이므로
        //toolbar에 구현해둔 컴포넌트를 findViewById로 가져오기위해
        //toolbar.findViewById로 찾아준다
        btnShowNavigationDrawer = (ImageButton) toolbar.findViewById(R.id.btnShowNavigationDrawer);
        btnShowNavigationDrawer.setOnClickListener(onClickListener);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = setUpActionBarToggle();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        setUpDrawerContent(navigationView);

        fragmentTransaction.add( R.id.fragment_place, fragment );
        fragmentTransaction.commit();

    }


    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnShowNavigationDrawer:
                    drawerLayout.openDrawer(GravityCompat.START);
                    break;
            }
        }
    };


    private void setUpDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.goback:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.first_navigation_item:
                        fragment = new FirstYeoui();
                        break;
                    case R.id.second_navigation_item:
                        fragment = new SecondYeoui();
                        break;
                    case R.id.third_navigation_item:
                        fragment = new ThirdYeoui();
                        break;
                    case R.id.fourth_navigation_item:
                        Intent intent = new Intent(YeouiActivity.this, FourthYeoui.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent);
                        break;
                }
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace( R.id.fragment_place, fragment);
                fragmentTransaction.commit();
                return false;
            }
        });
    }

    private ActionBarDrawerToggle setUpActionBarToggle(){
        return new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    }


}
