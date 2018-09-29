package com.example.bbarroo.awesome;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MSF_LVA extends BaseAdapter{

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<MSF_LVI> listViewItemList = new ArrayList<MSF_LVI>() ;

    // MFF_LVA 생성자
    public MSF_LVA() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "main_frag_1_lvi" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_frag_2_lvi, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView picImageView = (ImageView) convertView.findViewById(R.id.img) ;
        TextView whatTextView = (TextView) convertView.findViewById(R.id.what) ;
        TextView dateTextView = (TextView) convertView.findViewById(R.id.date) ;
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time) ;

        picImageView.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21){
            picImageView.setClipToOutline(true);
        }
        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        MSF_LVI listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        picImageView.setImageDrawable(listViewItem.getPic_());
        whatTextView.setText(listViewItem.getWhat_()+"");
        dateTextView.setText(listViewItem.getDate_()+"");
        timeTextView.setText(listViewItem.getTime_()+"");



        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable pic, String a, String b, String c) {
        MSF_LVI item = new MSF_LVI();

        item.setPic_(pic);
        item.setWhat_(a);
        item.setDate_(b);
        item.setTime_(c);


        listViewItemList.add(item);
    }
}
