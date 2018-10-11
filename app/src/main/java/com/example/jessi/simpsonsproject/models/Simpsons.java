package com.example.jessi.simpsonsproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Simpsons {

    @SerializedName("RelatedTopics")
    List<RelatedTopics> relatedTopicsList;

    public Simpsons(List<RelatedTopics> relatedTopicsList) {
        this.relatedTopicsList = relatedTopicsList;
    }

    public List<RelatedTopics> getRelatedTopicsList() {
        return relatedTopicsList;
    }

    public void setRelatedTopicsList(List<RelatedTopics> relatedTopicsList) {
        this.relatedTopicsList = relatedTopicsList;
    }
}
