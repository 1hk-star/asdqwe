package com.example.bbarroo.bottombar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

public class SecondYeoui extends Fragment{
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.yeoui_2, container,false);
        ListView listview = view.findViewById(R.id.listview1);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.yeoui_2,container,false);
        ListViewAdapter_A adapter = new ListViewAdapter_A() ;
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.baseline_favorite_black_24)) ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.baseline_location_on_black_18dp)) ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.baseline_motorcycle_black_18dp)) ;
        return view;

    }
}
