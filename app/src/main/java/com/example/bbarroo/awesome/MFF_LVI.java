package com.example.bbarroo.awesome;

import android.graphics.drawable.Drawable;

public class MFF_LVI {
    private Drawable picDrawable ;
    private int like ;
    private String name;

    public void setPic(Drawable icon) {
        picDrawable = icon ;
    }
    public void setLike(int like_) {
        like = like_ ;
    }
    public void setNamee(String name_) { name = name_; }

    public Drawable getPic() {
        return this.picDrawable ;
    }
    public int getLike() {
        return this.like ;
    }
    public String getNamee() {return this.name;}
}
