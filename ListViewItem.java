package com.example.bbarroo.bottombar;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable picDrawable ;
    private int cntInt ;

    public void setPic(Drawable icon) {
        picDrawable = icon ;
    }
    public void setCnt(int cnt) {
        cntInt = cnt ;
    }

    public Drawable getPic() {
        return this.picDrawable ;
    }
    public int getCnt() {
        return this.cntInt ;
    }

}
