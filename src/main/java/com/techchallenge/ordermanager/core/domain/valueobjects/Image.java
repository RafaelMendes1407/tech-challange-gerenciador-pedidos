package com.techchallenge.ordermanager.core.domain.valueobjects;

public class Image {
    public Image(String urlPath) {
        this.urlPath = urlPath;
    }

    public String urlPath;

    @Override
    public String toString() {
        return urlPath;
    }
}
