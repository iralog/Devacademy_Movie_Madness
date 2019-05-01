package com.finalproject.couchpotato;

import java.util.ArrayList;
//by Irina
public class Movies {

    private int movie_id;
    private String movie_title;
    private String movie_summary;
    private String movie_duration;
    private String movie_genre;
    private String movie_releaseDate;
    private String movie_coverImage;
    private String movie_trailer;
    InitialiseDB initDB = new InitialiseDB();
    public static ArrayList<Movies> movies = new ArrayList<>();


    public Movies(int movie_id, String movie_title, String movie_summary,
                  String movie_duration, String movie_genre,
                  String movie_releaseDate, String movie_coverImage,
                  String movie_trailer) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_summary = movie_summary;
        this.movie_duration = movie_duration;
        this.movie_genre = movie_genre;
        this.movie_releaseDate = movie_releaseDate;
        this.movie_coverImage = movie_coverImage;
        this.movie_trailer = movie_trailer;
    }

    public Movies(){}

    //Getters and Setters
    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_summary() {
        return movie_summary;
    }

    public void setMovie_summary(String movie_summary) {
        this.movie_summary = movie_summary;
    }

    public String getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(String movie_duration) {
        this.movie_duration = movie_duration;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovie_releaseDate() {
        return movie_releaseDate;
    }

    public void setMovie_releaseDate(String movie_releaseDate) {
        this.movie_releaseDate = movie_releaseDate;
    }

    public String getMovie_coverImage() {
        return movie_coverImage;
    }

    public void setMovie_coverImage(String movie_coverImage) {
        this.movie_coverImage = movie_coverImage;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public ArrayList<Movies>getAllMovies(){movies = initDB.getMovies(initDB.getDBConnection());
        return movies;}

    //Methods (Add, Update and Remove movie)
    public void addNewMovie(Movies movie){
        initDB.addNewMovie(initDB.getDBConnection(),movie);
    }

    public void updateMovie(Movies movie){
        initDB.updateMovie(initDB.getDBConnection(),movie);
    }

    public void deleteMovie(Movies movie){ initDB.deleteMovie(initDB.getDBConnection(),movie);

    }
}