package com.example.jessi.simpsonsproject.models;

import java.util.ArrayList;
import java.util.List;

public class AllCharacters {

    List<CharacterItem> characterItemList;


    public AllCharacters() {
        characterItemList = new ArrayList<>();
    }

    public List<CharacterItem> getCharacterItemList() {
        return characterItemList;
    }

    public void setCharacterItemList(List<CharacterItem> characterItemList) {
        this.characterItemList = characterItemList;
    }

    public void addCharacter(CharacterItem characterItem) {
        characterItemList.add(characterItem);
    }
}
