package com.example.jessi.simpsonsproject.models;

import com.google.gson.annotations.SerializedName;

public class RelatedTopics {

    @SerializedName("Text")
    private String text;
    @SerializedName("Icon")
    private Icons icons;

    public RelatedTopics() {

    }

    public RelatedTopics(String text, Icons icons) {
        this.text = text;
        this.icons = icons;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Icons getIcons() {
        return icons;
    }

    public void setIcons(Icons icons) {
        this.icons = icons;
    }
}
