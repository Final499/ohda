package com.example.ohda499;

public class Upload {

    private String mSpinner,ImageUrl,mImageUrl2,mImageUrl3, description , filename , catagory,phoneid , type;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String imageUrl, String description , String filename ,String catagory, String phoneid, String type) {


        this.phoneid=phoneid;
        this.ImageUrl = imageUrl;
        this.description=description;
        this.filename = filename;
        this.catagory = catagory;
        this.type = type;


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getmImageUrl() {
        return ImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
}

