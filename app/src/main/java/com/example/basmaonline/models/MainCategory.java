package com.example.basmaonline.models;

public class MainCategory {
    private long name;
    private long id;
    private String image;
    private String description;

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
