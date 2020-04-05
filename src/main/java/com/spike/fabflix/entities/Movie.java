package com.spike.fabflix.entities;

import java.util.List;

/**
 * @Author spike
 * @Date: 2020-04-01 22:45
 */
public class Movie {
    String id;
    String title;
    int year;
    String director;
    List<Star> stars;
    List<Genre> genres;
    double rating;


    public Movie(String id, String title, int year, String director, double rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", stars=" + stars +
                ", genres=" + genres +
                ", rating=" + rating +
                '}';
    }

    public Movie(String id, String title, int year, String director) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public Movie(String id, String title, int year, String director, List<Star> stars, List<Genre> genres, double rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.stars = stars;
        this.genres = genres;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
