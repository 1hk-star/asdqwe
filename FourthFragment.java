package com.example.bbarroo.bottombar;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Bbarroo on 2018-08-03.
 */

public class FourthFragment extends Fragment{

    public FourthFragment(){}
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_4, container, false);
        ImageButton river = (ImageButton) layout.findViewById(R.id.han_river);
        river.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(((MainActivity)getActivity()), YeouiActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);
            }
        });
        return layout;
    }
}