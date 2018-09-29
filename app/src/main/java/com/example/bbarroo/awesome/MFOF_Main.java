package com.example.bbarroo.awesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MFOF_Main extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.main_frag_4, container,false);

        TextView sel_1 = (TextView) view.findViewById(R.id.sel_1);
        TextView sel_2 = (TextView) view.findViewById(R.id.sel_2);
        TextView sel_3 = (TextView) view.findViewById(R.id.sel_3);
        TextView sel_4 = (TextView) view.findViewById(R.id.sel_4);
        TextView sel_5 = (TextView) view.findViewById(R.id.sel_5);
        TextView sel_6 = (TextView) view.findViewById(R.id.sel_6);
        TextView sel_7 = (TextView) view.findViewById(R.id.sel_7);
        TextView sel_8 = (TextView) view.findViewById(R.id.sel_8);
        TextView sel_9 = (TextView) view.findViewById(R.id.sel_9);
        TextView sel_10 = (TextView) view.findViewById(R.id.sel_10);
        TextView sel_11 = (TextView) view.findViewById(R.id.sel_11);

        sel_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",1);
                startActivity(intent);
            }
        });
        sel_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",2);
                startActivity(intent);
            }
        });
        sel_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",3);
                startActivity(intent);
            }
        });
        sel_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",4);
                startActivity(intent);
            }
        });
        sel_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",5);
                startActivity(intent);
            }
        });
        sel_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",6);
                startActivity(intent);
            }
        });
        sel_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",7);
                startActivity(intent);
            }
        });
        sel_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",8);
                startActivity(intent);
            }
        });
        sel_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",9);
                startActivity(intent);
            }
        });
        sel_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",10);
                startActivity(intent);
            }
        });
        sel_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MFOF_detail.class);
                intent.putExtra("name",11);
                startActivity(intent);
            }
        });
        return view;

    }
}
