package com.example.liquid.Models;

public class SettingsModel {
    int drawableLeft;
    String title;

    public SettingsModel(int drawableLeft, String title) {
        this.drawableLeft = drawableLeft;
        this.title = title;
    }

    public int getDrawableLeft() {
        return drawableLeft;
    }

    public void setDrawableLeft(int drawableLeft) {
        this.drawableLeft = drawableLeft;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
