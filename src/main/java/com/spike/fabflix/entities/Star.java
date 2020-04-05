package com.spike.fabflix.entities;

import java.util.List;

/**
 * @Author spike
 * @Date: 2020-04-01 22:42
 */
public class Star {
    String id;
    String name;
    int birthYear;
    List<Movie> movies;

    @Override
    public String toString() {
        return "Star{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", movies=" + movies +
                '}';
    }

    public Star() {}

    public Star(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Star(String id, String name, int birthYear, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.movies = movies;
    }

    public Star(String id, String name, int birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
