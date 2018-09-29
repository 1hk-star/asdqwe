package com.example.bbarroo.bottombar;

import android.graphics.drawable.Drawable;

public class ListViewItem_Community {
    private String what_ ;
    private String when_ ;
    private String where_ ;

    public void setWhat(String what) {
        what_ = what ;
    }
    public void setWhen(String when) {
        when_ = when ;
    }
    public void setWhere(String where){
        where_ = where;
    }

    public String getWhat() {
        return this.what_;
    }
    public String getWhen() {
        return this.when_;
    }
    public String getWhere(){return this.where_;}

}
