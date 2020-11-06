package com.ecomerce.model;

import androidx.annotation.NonNull;

public class Image2 {
    public int imageSrc, imageId;
    public String imageDesc, imageDesc1;
    public Image2(@NonNull int imageSrc, int imageId, String imageDesc, String imageDesc1 ) {
        this.imageSrc = imageSrc;
        this.imageId = imageId;
        this.imageDesc = imageDesc;
        this.imageDesc1 = imageDesc1;
    }
}
