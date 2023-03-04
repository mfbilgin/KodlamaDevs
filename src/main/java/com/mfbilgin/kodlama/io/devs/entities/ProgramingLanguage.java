package com.mfbilgin.kodlama.io.devs.entities;

public class ProgramingLanguage {
    int id;
    String name;

    public ProgramingLanguage() {
    }

    public ProgramingLanguage(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
