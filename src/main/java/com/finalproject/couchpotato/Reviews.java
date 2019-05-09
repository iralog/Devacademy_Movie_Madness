//Class coded by Dan Sai

package com.finalproject.couchpotato;

import com.finalproject.couchpotato.service.InitialiseDB;

import java.util.ArrayList;

public class Reviews {

    private  int user_id;
    private int movie_id;
    private int review_id;
    private String username;
    private String review_comment;
    private int review_rating;
    private String review_date;

    InitialiseDB initDB = new InitialiseDB();
    public static ArrayList<Reviews> reviews = new ArrayList<>();

    public Reviews(int user_id, int movie_id, int review_id, String username, String review_comment, int review_rating, String review_date) {
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.review_id = review_id;
        this.username = username;
        this.review_comment = review_comment;
        this.review_rating = review_rating;
        this.review_date = review_date;
    }

    public Reviews(){}

    //Getter and Setter


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
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

    public ArrayList<Reviews> getAllReviews(){reviews = initDB.getReviews(initDB.getDBConnection());
        return reviews;
    }

    //Add and Delete Reviews
    public void addNewReview(Reviews review) {
        initDB.addNewReview(initDB.getDBConnection(), review);
    }

    public void deleteReview(Reviews review) {
        initDB.deleteReview(initDB.getDBConnection(), review);
    }

    public void updateReview(Reviews review) {
        initDB.updateReview(initDB.getDBConnection(), review);
    }
}


