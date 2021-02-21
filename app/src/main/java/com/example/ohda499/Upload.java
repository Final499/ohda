package com.example.ohda499;

public class Upload {

    private String mSpinner,ImageUrl,mImageUrl2,mImageUrl3, description , filename;

    public Upload() {
            //empty constructor needed
        }

        public Upload(String imageUrl, String description , String filename ) {



            this.ImageUrl = imageUrl;
            this.description=description;
            this.filename = filename;


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


}

