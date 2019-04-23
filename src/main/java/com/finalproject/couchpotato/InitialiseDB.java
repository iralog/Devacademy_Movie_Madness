package com.finalproject.couchpotato;

import java.sql.*;
import java.util.ArrayList;

import org.sqlite.SQLiteConfig;

@SuppressWarnings("Duplicates") //this @notation was missing (Danillo)
public class InitialiseDB {

    //this main block was missing (Danillo)
   public static void main(String[] args) {
        InitialiseDB initDB = new InitialiseDB();
    }

    private Connection connectDB() {
            Connection con = null;

            try {
                Class.forName("org.sqlite.JDBC");
                SQLiteConfig config = new SQLiteConfig();
                config.enforceForeignKeys(true);
                con = DriverManager.getConnection("jdbc:sqlite:" +
                                "../../../lib/MovieMadnessDB.db",
                        config.toProperties());
            } catch (Exception ex) {
                System.out.println(ex.getClass());
                ex.printStackTrace();
            }
            return con;
        }
    //TODO (It creates only the table Movies)(Danillo)
    // Missing tables Users, MovieReviews, Actors and MovieCast
    // Double check field names & table names
    //created the methods for Users table (Irina)

    public void addNewMovie(Connection con, Movies movie) {
        try {
            String addMovies = "INSERT INTO tblMovies (movie_title, movie_summary, movie_duration, movie_genre, movie_releaseDate, movie_coverImage, movie_trailer) VALUES " +
                    "(?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addMovies);
            pst.setString(1, movie.getMovie_title());
            pst.setString(2, movie.getMovie_summary());
            pst.setString(3, movie.getMovie_duration());
            pst.setString(4, movie.getMovie_genre());
            pst.setString(5, movie.getMovie_releaseDate());
            pst.setString(6, movie.getMovie_coverImage());
            pst.setString(7, movie.getMovie_trailer());

            pst.executeUpdate();
            pst.close();
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void addNewUser(Connection con, Users user) {
        try {
            String addUsers = "INSERT INTO tblUsers (user_username, user_password\n" +
                    "user_name,user_age,user_email,user_joinDate) VALUES " +
                    "(?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addUsers);
            pst.setString(1, user.getUser_username());
            pst.setString(2, user.getUser_password());
            pst.setString(3, user.getUser_name());
            pst.setInt(4, user.getUser_age());
            pst.setString(5, user.getUser_email());
            pst.setString(6, user.getUser_joinDate());

            pst.executeUpdate();
            pst.close();
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Movies> getMovies(Connection con) {

        ArrayList<Movies> movies = new ArrayList<Movies>();
        Statement stmnt = null;

        try {
            String getMoviesQuery = "SELECT * FROM tblMovies";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getMoviesQuery);

            while (rs.next()) {
                Movies movie = new Movies();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_title(rs.getString("movie_title"));
                movie.setMovie_summary(rs.getString("movie_summary"));
                movie.setMovie_duration(rs.getString("movie_duration"));
                movie.setMovie_genre(rs.getString("movie_genre"));
                movie.setMovie_releaseDate(rs.getString("movie_releaseDate"));
                movie.setMovie_coverImage(rs.getString("movie_coverImage"));
                movie.setMovie_trailer(rs.getString("movie_Trailer"));

                movies.add(movie);
            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmnt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

    public ArrayList<Users> getUsers(Connection con) {

        ArrayList<Users> users = new ArrayList<Users>();
        Statement stmnt = null;

        try {
            String getMoviesQuery = "SELECT * FROM tblUsers";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getMoviesQuery);

            while (rs.next()) {
               Users user=new Users();
                user.setUser_id(rs.getInt("user_id"));
              user.setUser_username(rs.getString("user_username"));
               user.setUser_password(rs.getString("user_password"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_age(rs.getInt("user_age"));
               user.setUser_email(rs.getString("user_email"));
               user.setUser_joinDate(rs.getString("user_joinDate"));

               users.add(user);
            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmnt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public boolean updateMovie(Connection con, Movies movie){
        try {
            String updateRecord = "UPDATE tblMovies SET movie_title = ?, movie_summary = ?, movie_duration = ?," +
                    "movie_genre = ?, movie_releaseDate = ?, movie_coverImage, movie_trailer WHERE movie_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, movie.getMovie_title());
            pst.setString(2, movie.getMovie_summary());
            pst.setString(3, movie.getMovie_duration());
            pst.setString(4, movie.getMovie_genre());
            pst.setString(5, movie.getMovie_releaseDate());
            pst.setString(6, movie.getMovie_coverImage());
            pst.setString(7, movie.getMovie_trailer());

            pst.setInt(8, movie.getMovie_id());

            pst.executeUpdate();
            pst.close();
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    public boolean deleteMovie(Connection con, Movies movie){
        try {
            String removeMovie = "DELETE FROM tblMovies WHERE movie_id = ?";
            PreparedStatement pst = con.prepareStatement(removeMovie);

            pst.setInt(1, movie.getMovie_id());
            pst.executeUpdate();

            pst.close();
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }




    public Connection getDBConnection() {
        Connection con = connectDB();
        return con;
    }
}

