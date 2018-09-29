package com.example.bbarroo.awesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MSF_Main extends Fragment {
    public MSF_Main(){}
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.main_frag_2, container,false);
        ListView listview = view.findViewById(R.id.listview1);
        MSF_LVA adapter = new MSF_LVA() ;
        listview.setAdapter(adapter);

        // 아이템 추가하는 방법 (제목, 내용, 이름, 시간)
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.banpo_home),"한강 어른이 놀이터(여의도)","08.11.토 ~ 08.12.일","15:00 ~ 21:00");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ttukseom_home),"한강몽땅 종이배경주대회(잠실)","08.10.금 ~ 08. 12.일","09:00~16:30");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.banpo_home),"한강 어른이 놀이터(여의도)","08.11.토 ~ 08.12.일","15:00 ~ 21:00");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ttukseom_home),"한강몽땅 종이배경주대회(잠실)","08.10.금 ~ 08. 12.일","09:00~16:30");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.banpo_home),"한강 어른이 놀이터(여의도)","08.11.토 ~ 08.12.일","15:00 ~ 21:00");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ttukseom_home),"한강몽땅 종이배경주대회(잠실)","08.10.금 ~ 08. 12.일","09:00~16:30");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.banpo_home),"한강 어른이 놀이터(여의도)","08.11.토 ~ 08.12.일","15:00 ~ 21:00");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ttukseom_home),"한강몽땅 종이배경주대회(잠실)","08.10.금 ~ 08. 12.일","09:00~16:30");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.banpo_home),"한강 어른이 놀이터(여의도)","08.11.토 ~ 08.12.일","15:00 ~ 21:00");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ttukseom_home),"한강몽땅 종이배경주대회(잠실)","08.10.금 ~ 08. 12.일","09:00~16:30");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), activity_detail.class);
                startActivity(intent);

            }
        });

        return view;

    }
}
