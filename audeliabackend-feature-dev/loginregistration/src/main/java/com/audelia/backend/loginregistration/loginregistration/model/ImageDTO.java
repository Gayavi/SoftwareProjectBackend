package com.audelia.backend.loginregistration.loginregistration.model;


import com.audelia.backend.loginregistration.loginregistration.util.enums.ImageType;


public class ImageDTO {

    String file;
    String fileName;
    ImageType imageType;

    public ImageDTO() {
    }

    public ImageDTO(String file, String fileName, ImageType imageType) {
        this.file = file;
        this.fileName = fileName;
        this.imageType = imageType;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }
}
