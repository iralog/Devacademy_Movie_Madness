package com.finalproject.couchpotato;

import com.finalproject.couchpotato.service.InitialiseDB;

import java.util.ArrayList;

public class CastRepo {

    private int cast_id;
    private int movie_id;
    private String actor_name;
    private String actor_profilePhoto;

    InitialiseDB initDB = new InitialiseDB();
    public static ArrayList<CastRepo> castRepo = new ArrayList<>();

    public CastRepo(int cast_id, int movie_id, String actor_name, String actor_profilePhoto) {
        this.cast_id = cast_id;
        this.movie_id = movie_id;
        this.actor_name = actor_name;
        this.actor_profilePhoto = actor_profilePhoto;
    }

    public CastRepo() {}

    public int getCast_id() {
        return cast_id;
    }

    public void setCast_id(int cast_id) {
        this.cast_id = cast_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public String getActor_profilePhoto() {
        return actor_profilePhoto;
    }

    public void setActor_profilePhoto(String actor_profilePhoto) {
        this.actor_profilePhoto = actor_profilePhoto;
    }

    public ArrayList<CastRepo> getCastRepo() {
        castRepo = initDB.getCastRepo(initDB.getDBConnection());
        return castRepo;
    }
}
