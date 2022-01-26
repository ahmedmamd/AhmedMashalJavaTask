package com.example.javatask.pojo;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("login")
    String login;
    @SerializedName("id")
    int id;
    @SerializedName("node_id")
    String node_id;
    @SerializedName("avatar_url")
    String avatar_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
