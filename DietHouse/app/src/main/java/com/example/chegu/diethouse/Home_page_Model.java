package com.example.chegu.diethouse;

import java.io.Serializable;

/**
 * Created by chegu on 15/10/16.
 * Test comment for demo
 */
public class Home_page_Model implements Serializable {
    private String title,message;
    private int imageId;

    Home_page_Model(String title,int imageId, String message)
    {
        this.setTitle(title);
        this.setImageId(imageId);
        this.setMessage(message);

    }

    public String getTitle() {
        return title;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message) { this.message = message;}

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
