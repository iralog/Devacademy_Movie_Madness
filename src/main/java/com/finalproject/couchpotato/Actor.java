package com.finalproject.couchpotato;

import java.util.ArrayList;

public class Actor {
    private int actorId;
    private int actorAge;
    private String actorName;
    private String actorGender;
    private String actorProfilePhoto;
    InitialiseDB initDB = new InitialiseDB();
    public static ArrayList<Actor> actors = new ArrayList<>();

    public Actor(){

    }

    public Actor(int actorId, int actorAge, String actorName, String actorGender, String actorProfilePhoto) {
        this.actorId = actorId;
        this.actorAge = actorAge;
        this.actorName = actorName;
        this.actorGender = actorGender;
        this.actorProfilePhoto = actorProfilePhoto;
    }

    public ArrayList<Actor>getAllActors(){
        actors = initDB.getActors(initDB.getDBConnection());
        return actors;
    }
    public void addNewActor(Actor actors) {
        initDB.addNewActor(initDB.getDBConnection(),actors);
    }
    public void updateActorProfileList(Actor actors){
        initDB.updateActorProfileList(initDB.getDBConnection(), actors);
    }
    public void removeActor(Actor actors){
        initDB.removeActor(initDB.getDBConnection(), actors);
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getActorAge() {
        return actorAge;
    }

    public void setActorAge(int actorAge) {
        this.actorAge = actorAge;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorGender() {
        return actorGender;
    }

    public void setActorGender(String actorGender) {
        this.actorGender = actorGender;
    }

    public String getActorProfilePhoto() {
        return actorProfilePhoto;
    }

    public void setActorProfilePhoto(String actorProfilePhoto) {
        this.actorProfilePhoto = actorProfilePhoto;
    }

    public InitialiseDB getInitDB() {
        return initDB;
    }

    public void setInitDB(InitialiseDB initDB) {
        this.initDB = initDB;
    }
}


