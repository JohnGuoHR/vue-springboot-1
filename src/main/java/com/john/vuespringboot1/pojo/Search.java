package com.john.vuespringboot1.pojo;

public class Search {
    String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Search{" +
                "keywords='" + keywords + '\'' +
                '}';
    }
}
