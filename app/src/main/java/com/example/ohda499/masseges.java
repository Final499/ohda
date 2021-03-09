package com.example.ohda499;

public class masseges {
    String filename ;
    String description ;
    String catagory ;
    String mImageUrl;
    String phoneid;
    String type;

    public masseges() {

    }

    public masseges(String filename, String description, String catagory, String mImageUrl,String phoneid,String type) {

        this.filename = filename;
        this.description = description;
        this.catagory = catagory;
        this.mImageUrl = mImageUrl;
        this.phoneid = phoneid;
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
