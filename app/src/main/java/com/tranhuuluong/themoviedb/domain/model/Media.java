package com.tranhuuluong.themoviedb.domain.model;

/**
 * Created by luongtran on 9/26/18.
 */

public class Media {
    private int id;
    private double rating;
    private String title;
    private String posterPath;
    private String backdropPath;

    public Media(int id, double rating, String title, String posterPath, String backdropPath) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }


}
