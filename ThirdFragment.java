package com.example.bbarroo.bottombar;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by Bbarroo on 2018-08-03.
 */

public class ThirdFragment extends Fragment{

    public ThirdFragment(){}
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_3, container,false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.rgb(0,0,0));

        ListView listview = view.findViewById(R.id.listview3);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_3,container,false);
        ListViewAdapter_C adapter = new ListViewAdapter_C() ;
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem("여의도","시원해요","18:40") ;
        // 두 번째 아이템 추가.
        adapter.addItem("뚝섬","좋아요","15:42") ;
        // 세 번째 아이템 추가.
        adapter.addItem("김포","대한민국의 베니스","07:07") ;

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(getActivity(), FourthYeoui.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}