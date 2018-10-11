package com.example.jessi.simpsonsproject.models;

import java.util.List;

public class Simpsons {

    List<RelatedTopics> relatedTopicsList;

    public Simpsons() {
    }

    public List<RelatedTopics> getRelatedTopicsList() {
        return relatedTopicsList;
    }

    public void setRelatedTopicsList(List<RelatedTopics> relatedTopicsList) {
        this.relatedTopicsList = relatedTopicsList;
    }
}
