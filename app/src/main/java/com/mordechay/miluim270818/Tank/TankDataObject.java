package com.mordechay.miluim270818.Tank;

public class TankDataObject {
    private int mText1;
    private int mText2;
    private int img;

    public TankDataObject(int mText1, int mText2, int img) {
        this.mText1 = mText1;
        this.mText2 = mText2;
        this.img = img;
    }

    public int getmText1() {
        return mText1;
    }

    public void setmText1(int mText1) {
        this.mText1 = mText1;
    }

    public int getmText2() {
        return mText2;
    }

    public void setmText2(int mText2) {
        this.mText2 = mText2;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
