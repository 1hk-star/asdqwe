package com.example.bbarroo.awesome;

import android.graphics.drawable.Drawable;

public class MFF_LVI {
    private String picDrawable ;
    private int like ;
    private String name;
    private int _id;

    public void setPic(String icon) {
        picDrawable = icon ;
    }
    public void setLike(int like_) {
        like = like_ ;
    }
    public void setNamee(String name_) { name = name_; }
    public void set_id(int id_) { _id = id_ ; }

    public String getPic() {
        return this.picDrawable ;
    }
    public int getLike() {
        return this.like ;
    }
    public String getNamee() {return this.name;}
    public int get_id() {
        return this._id ;
    }
}
