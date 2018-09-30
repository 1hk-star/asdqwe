package com.example.bbarroo.awesome;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MFF_LVA extends BaseAdapter {
    MFF_LVI listViewItem;
    ImageView iconImageView;

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<MFF_LVI> listViewItemList = new ArrayList<MFF_LVI>() ;

    // MFF_LVA 생성자
    public MFF_LVA() {

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
            convertView = inflater.inflate(R.layout.main_frag_1_lvi, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        iconImageView = (ImageView) convertView.findViewById(R.id.img) ;
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name) ;
        TextView likeTextView = (TextView) convertView.findViewById(R.id.like) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        listViewItem = listViewItemList.get(position);

        new Thread() {
            public void run() {
                try {
                   /* String url = listViewItem.getPic();
                    Log.i("thread", url);
                    InputStream is = (InputStream) new URL(url).getContent();
                    Bitmap bmp = BitmapFactory.decodeStream(is);
                    iconImageView.setImageBitmap(bmp);//Bitmap을 ImageView에 저장*/

                    URL url = new URL(listViewItem.getPic());

                    URLConnection conn =

                            url.openConnection();

                    conn.connect();

                    BufferedInputStream  bis = new BufferedInputStream(conn.getInputStream());

                    Bitmap bm = BitmapFactory.decodeStream(bis);
                    bis.close();

                    iconImageView.setImageBitmap(bm);

                } catch (Exception e) {
                }
            }
        }.start();

        // 아이템 내 각 위젯에 데이터 반영
       // iconImageView.setImageDrawable(listViewItem.getPic());
        nameTextView.setText(listViewItem.getNamee()+"");
        likeTextView.setText("♥ "+listViewItem.getLike()+"");

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }
    public int get_id(int position) {
        return listViewItemList.get(position).get_id();
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String pic, String namee,int cnt, int _id) {
        MFF_LVI item = new MFF_LVI();

        item.setPic(pic);
        item.setLike(cnt);
        item.setNamee(namee);
        item.set_id(_id);

        listViewItemList.add(item);
    }

}
