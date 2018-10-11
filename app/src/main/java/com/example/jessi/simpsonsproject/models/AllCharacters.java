package com.example.jessi.simpsonsproject.models;

import com.example.jessi.simpsonsproject.models.Character;

import java.util.ArrayList;
import java.util.List;

public class AllCharacters {

    List<Character> characterList;


    public AllCharacters() {
        characterList = new ArrayList<>();
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public void addCharacter(Character character) {
        characterList.add(character);
    }
}
