package com.example.bbarroo.bottombar;

import android.graphics.drawable.Drawable;

public class ListViewItem_Activity {
    private Drawable picDrawable;

    public void setPic(Drawable icon) {
        picDrawable = icon ;
    }


    public Drawable getPic() {
        return this.picDrawable ;
    }
}
