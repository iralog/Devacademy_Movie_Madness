package com.finalproject.couchpotato;

import com.finalproject.couchpotato.service.InitialiseDB;

import java.util.ArrayList;

public class ReviewRepo {

    private int movie_id;
    private String username;
    private String review_comment;
    private int review_rating;
    private String review_date;

    InitialiseDB initDB = new InitialiseDB();
    public static ArrayList<ReviewRepo> reviewRepo = new ArrayList<>();

    public ReviewRepo(int movie_id, String username, String review_comment, int review_rating, String review_date) {
        this.movie_id = movie_id;
        this.username = username;
        this.review_comment = review_comment;
        this.review_rating = review_rating;
        this.review_date = review_date;
    }

    public ReviewRepo(){}

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public int getReview_rating() {
        return review_rating;
    }

    public void setReview_rating(int review_rating) {
        this.review_rating = review_rating;
    }

    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
    }

    public ArrayList<ReviewRepo> getReviewRepo() {
        reviewRepo = initDB.getReviewRepo(initDB.getDBConnection());
        return reviewRepo;
    }
}
