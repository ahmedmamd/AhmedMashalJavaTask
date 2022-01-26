package com.example.javatask.pojo;

import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("id")
    int id ;
    @SerializedName("node_id")
    String node_id ;
    @SerializedName("name")
    String name ;
    @SerializedName("full_name")
    String full_name ;
    @SerializedName("language")
    String language ;
    @SerializedName("owner")
    Owner owner=new Owner();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
