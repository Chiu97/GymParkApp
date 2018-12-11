package com.example.a97rea.gymparkapp;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.Resource;

public class News {
    String title;
    int imageID;
    public News(String title,int image){
        this.title=title;
        imageID=image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return imageID;
    }

    public void setImage(int image) {
        imageID = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
