package com.example.bbarroo.bottombar;

public class Yeoui_LVitem_C {
    private String title_ ;
    private String what_ ;
    private int heart_;
    private int comment_;

    public void setWhat(String what) {
        what_ = what ;
    }
    public void setTitle(String title) {
        title_ = title ;
    }
    public void setHeart(int heart){
        heart_ = heart;
    }
    public void setComment(int comment){ comment_ = comment;}

    public String getWhat() {
        return this.what_;
    }
    public String getTitle() {
        return this.title_;
    }
    public int getHeart(){return this.heart_;}
    public int getComment(){return this.comment_;}
}
