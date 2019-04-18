package com.finalproject.couchpotato;

import java.util.ArrayList;

public class Actors {
    private int actor_id;
    private int actor_age;
    private String actor_name;
    private String actor_gender;
    private String actor_profilePhoto;
    InitialiseDB initDB = new InitialiseDB();
    public static ArrayList<Actors> actor = new ArrayList<>();

    public Actors() {

    }

    public Actors(int actor_id, int actor_age, String actor_name, String actor_gender, String actor_profilePhoto) {
        this.actor_id = actor_id;
        this.actor_age = actor_age;
        this.actor_name = actor_name;
        this.actor_gender = actor_gender;
        this.actor_profilePhoto = actor_profilePhoto;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getActor_age() {
        return actor_age;
    }

    public void setActor_age(int actor_age) {
        this.actor_age = actor_age;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public String getActor_gender() {
        return actor_gender;
    }

    public void setActor_gender(String actor_gender) {
        this.actor_gender = actor_gender;
    }

    public String getActor_profilePhoto() {
        return actor_profilePhoto;
    }

    public void setActor_profilePhoto(String actor_profilePhoto) {
        this.actor_profilePhoto = actor_profilePhoto;
    }
    //      Below ready for use. no methods made yet.
//    public ArrayList<Actors>getAllActors(){
//        actor = initDB.getActors(initDB.getDBConnection());
//        return actor;
//    }
//    public void addNewActors(Actors actor) {
//        initDB.addNewActors(initDB.getDBConnection(),actor);
//    }
//    public void updateActorProfileList(Actors actor){
//        initDB.updateActorsProfileList(initDB.getDBConnection(), actor);
//    }
//    public void removeActor(Actors actor){
//        initDB.removeActors(initDB.getDBConnection(), actor);
//    }

}
