package com.example.javatask.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PopularStare {
    @SerializedName("total_count")
    int total_count;
    @SerializedName("incomplete_results")
    Boolean incomplete_results;
    @SerializedName("total_pages")
    int total_pages;
    @SerializedName("items")
    ArrayList<Items> items =new ArrayList<>();

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(Boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
}
