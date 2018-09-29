package com.example.bbarroo.awesome;

import android.graphics.drawable.Drawable;

public class MSF_LVI {
    private Drawable pic;
    private String what;
    private String who;
    private String when;
    public void setPic_(Drawable dra){pic = dra;}
    public void setWhat_(String str){what= str;}
    public void setDate_(String str){who = str;}
    public void setTime_(String str){when = str;}
    public Drawable getPic_(){return this.pic;}
    public String getWhat_(){return this.what;}
    public String getDate_(){return this.who;}
    public String getTime_(){return this.when;}
}

