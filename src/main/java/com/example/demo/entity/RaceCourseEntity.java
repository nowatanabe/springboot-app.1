package com.example.demo.entity;

public class RaceCourseEntity {
    private final String id;
    private final String name;

    public RaceCourseEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
