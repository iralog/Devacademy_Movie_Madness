package com.finalproject.couchpotato;

import java.sql.*;
import org.sqlite.SQLiteConfig;


public class InitialiseDB {


    @SuppressWarnings("Duplicates")

        public static void main(String[] args) {
            InitialiseDB initDB = new InitialiseDB();
           // initDB.createTables(initDB.connectDB());
        }

        private Connection connectDB() {
            Connection con = null;

            try {
                Class.forName("org.sqlite.JDBC");
                SQLiteConfig config = new SQLiteConfig();
                config.enforceForeignKeys(true);
                con = DriverManager.getConnection("jdbc:sqlite:" +
                                "../../../lib/MovieDatabase.db",
                        config.toProperties());
            } catch (Exception ex) {
                System.out.println(ex.getClass());
                ex.printStackTrace();
            }
            return con;
        }

}
