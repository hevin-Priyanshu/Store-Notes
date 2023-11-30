package com.demo.storenotesusingjava;

import androidx.annotation.StringRes;

public class ModelClass {

    private final String name;

    private final String notes ;

    public ModelClass(String name, String notes) {
        this.name = name;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }
}
