package com.example.ohda499;

public class Upload {

    private String mSpinner,mImageUrl,mImageUrl2,mImageUrl3,mDescription;

    public Upload() {
            //empty constructor needed
        }

        public Upload(String name,String Description, String imageUrl,String imageUrl2,String imageUrl3) {
            if (name.trim().equals("")) {
                name = "No Name";
            }

            mSpinner = name;
            mDescription=Description;
            mImageUrl = imageUrl;
            mImageUrl2 = imageUrl2;
            mImageUrl3= imageUrl3;

        }


    public String getmSpinner() {
        return mSpinner;
    }

    public void setmSpinner(String mSpinner) {
        this.mSpinner = mSpinner;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmImageUrl2() {
        return mImageUrl2;
    }

    public void setmImageUrl2(String mImageUrl2) {
        this.mImageUrl2 = mImageUrl2;
    }

    public String getmImageUrl3() {
        return mImageUrl3;
    }

    public void setmImageUrl3(String mImageUrl3) {
        this.mImageUrl3 = mImageUrl3;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}

