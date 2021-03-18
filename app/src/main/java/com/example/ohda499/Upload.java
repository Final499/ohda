package com.example.ohda499;

public class Upload {

    private String mSpinner,ImageUrl,mImageUrl2,mImageUrl3, description , filename , catagory,phoneid , userAdress ,type2;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String imageUrl, String description , String filename ,String catagory, String phoneid, String userAdress, String type2) {


        this.phoneid=phoneid;
        this.ImageUrl = imageUrl;
        this.description=description;
        this.filename = filename;
        this.catagory = catagory;
        this.userAdress = userAdress;
        this.type2 = type2;


    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
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

