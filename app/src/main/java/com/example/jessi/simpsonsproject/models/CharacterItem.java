package com.example.jessi.simpsonsproject.models;

public class CharacterItem {
    private String name;
    private String description;
    private String imageUrl;
    private boolean isFavorite = false;
    private int quantity = 0;

    public CharacterItem() {
    }

    public CharacterItem(String description, String imageUrl) {
        this.name = prepareCharacterName(description);
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String prepareCharacterName(String temp)
    {
        String result = "";

        for(int i = 0; i< temp.length(); i++)
        {
            if (temp.charAt(i) == '-')
                break;
            else
            result += temp.charAt(i);
        }
        return result;
    }
}
