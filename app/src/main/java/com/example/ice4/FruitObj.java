package com.example.ice4;

import android.graphics.Bitmap;

public class FruitObj {
    private String name;
    private String desc;
    private Bitmap ImgBMP;

    public FruitObj(){};

    public FruitObj(String name, String desc, Bitmap img) {
        this.name = name;
        this.desc = desc;
        this.ImgBMP = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Bitmap getImgBMP() {
        return ImgBMP;
    }

    public void setImgBMP(Bitmap imgBMP) {
        ImgBMP = imgBMP;
    }
}
