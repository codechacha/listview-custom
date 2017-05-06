package com.example.listview2;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    public Drawable mImage;
    public String mContent;

    public ListViewItem(Drawable image, String content) {
        mImage = image;
        mContent = content;
    }
}
