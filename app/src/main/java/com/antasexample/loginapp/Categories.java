package com.antasexample.loginapp;

/**
 * Created by antas on 2016-12-15.
 */

public class Categories {

    private String id, name, description;

    public Categories(String id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



}
