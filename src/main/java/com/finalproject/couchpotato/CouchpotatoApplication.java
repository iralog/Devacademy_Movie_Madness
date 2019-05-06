package com.finalproject.couchpotato;

import com.finalproject.couchpotato.service.InitialiseDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouchpotatoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouchpotatoApplication.class, args);
        InitialiseDB initDB = new InitialiseDB();
        initDB.connectDB();
    }
}
