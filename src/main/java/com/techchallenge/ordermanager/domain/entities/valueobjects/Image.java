package com.techchallenge.ordermanager.domain.entities.valueobjects;

public class Image {

    public String urlPath;
    public Image(String urlPath) {
        this.urlPath = urlPath;
    }


    @Override
    public String toString() {
        return urlPath;
    }
}
