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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MTF_Main extends Fragment {
    MTF_LVA adapter;
    int sel;
    public MTF_Main(){}
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.main_frag_3, container,false);
        ListView listview = view.findViewById(R.id.listview1);
        adapter = new MTF_LVA() ;
        listview.setAdapter(adapter);

        // 아이템 추가하는 방법 (제목, 내용, 이름, 시간)
        adapter.addItem("강서");
        adapter.addItem("광나루");
        adapter.addItem("난지");
        adapter.addItem("뚝섬");
        adapter.addItem("망원");
        adapter.addItem("반포");
        adapter.addItem("양화");
        adapter.addItem("여의도");
        adapter.addItem("이촌");
        adapter.addItem("잠실");
        adapter.addItem("잠원");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity() ,adapter.getwhere(position).toString(),Toast.LENGTH_LONG).show();

                String[] hangang_list = {"강서", "광나루","난지", "뚝섬", "반포", "망원", "양화", "여의도", "이촌", "잠실", "잠원"};
                String name="";

                for(int i =0; i<11; i++)
                    if(adapter.getwhere(position).toString().equals(hangang_list[i]))
                        sel = i+1;

                Intent intent = new Intent(getActivity(), Bulletin_Main.class);
                intent.putExtra("name",sel);
                startActivity(intent);

                /*if(position == 0) {
                    Intent intent = new Intent(getActivity(), Bulletin_Main.class);
                    startActivity(intent);
                }*/
            }
        });


        return view;

    }
}
