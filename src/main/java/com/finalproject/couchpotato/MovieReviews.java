package com.finalproject.couchpotato;

public class MovieReviews {

    private int reviewID;
    private String reviewComment;
    private int reviewRating;
    private String reviewDate;

    public MovieReviews(int reviewID, String reviewComment, int reviewRating, String reviewDate) {
        this.reviewID = reviewID;
        this.reviewComment = reviewComment;
        this.reviewRating = reviewRating;
        this.reviewDate = reviewDate;
    }

    public MovieReviews(){}

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    //Methods (Add, Update and Remove Movie Reviews)
    public void addNewMovieReview(MovieReviews movieReview) {initDB.addNewMovieReview(initDB.getDBConnection(), movieReview);}

    public void updateMovieReviewRecord(MovieReviews movieReview) {initDB.updateMovieReviewRecord(initDB.getDBConnection(), movieReview);}

    public void deleteMovieReview(MovieReviews movieReview) {initDB.deleteMovieReview(initDB.getDBConnection(), movieReview);}
}

