package com.it.hungvt.dagger2.model;

/**
 * Created by Administrator on 11/7/2017.
 */

public class Repository {
    String name;

    String fullName;

    String description;

    public Repository(String name, String fullName, String description) {
        this.name = name;
        this.fullName = fullName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }
}
