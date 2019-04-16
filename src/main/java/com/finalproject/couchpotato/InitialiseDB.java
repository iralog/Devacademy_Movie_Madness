package com.finalproject.couchpotato;

import java.sql.*;
import java.util.ArrayList;

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
                                "../../../lib/MovieMadnessDB.db",
                        config.toProperties());
            } catch (Exception ex) {
                System.out.println(ex.getClass());
                ex.printStackTrace();
            }
            return con;
        }

    private void createTables(Connection con) {

        try {
            Statement stmnt = con.createStatement();
            String createMoviesTable = "CREATE TABLE IF NOT EXISTS tblMovies " +
                    "(movie_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " movie_title TEXT NOT NULL," +
                    " movie_summary TEXT NOT NULL," +
                    " movie_duration TEXT NOT NULL," +
                    " movie_genre TEXT NOT NULL," +
                    " movie_releaseDate TEXT NOT NULL)" +
                    " movie_coverImage TEXT NOT NULL)" +
                    " movie_trailer TEXT NOT NULL)";

            stmnt.executeUpdate(createMoviesTable);
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }
    }

    public void addNewMovie(Connection con, Movies movie) {
        try {
            String addMovies = "INSERT INTO tblMovies (movie_title, movie_summary, movie_duration, movie_genre, movie_releaseDate, movie_coverImage, movie_trailer) VALUES " +
                    "(?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addMovies);
            pst.setString(1, movie.getMovieTitle());
            pst.setString(2, movie.getMovieSummary());
            pst.setString(3, movie.getMovieDuration());
            pst.setString(4, movie.getMovieGenre());
            pst.setString(5, movie.getReleaseDate());
            pst.setString(6, movie.getCoverImage());
            pst.setString(7, movie.getTrailer());

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
            String getBooksQuery = "SELECT * FROM tblMovies";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getBooksQuery);

            while (rs.next()) {
                Movies movie = new Movies();
                movie.setMovieID(rs.getInt("movie_id"));
                movie.setMovieTitle(rs.getString("movie_title"));
                movie.setMovieSummary(rs.getString("movie_summary"));
                movie.setMovieDuration(rs.getString("movie_duration"));
                movie.setBookGenre(rs.getString("movie_genre"));
                movie.setReleaseDate(rs.getString("movie_releaseDate"));
                movie.setCoverImage(rs.getString("movie_coverImage"));
                movie.setTrailer(rs.getString("movie_Trailer"));

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

    public boolean updateMovieRecord(Connection con, Movies movie){
        try {
            String updateRecord = "UPDATE tblMovies SET movie_title = ?, movie_summary = ?, movie_duration = ?," +
                    "movie_genre = ?, movie_releaseDate = ?, movie_coverImage, movie_trailer WHERE movie_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, movie.getMovieTitle());
            pst.setString(2, movie.getMovieSummary());
            pst.setString(3, movie.getMovieDuration());
            pst.setString(4, movie.getMovieGenre());
            pst.setString(5, movie.getMovieReleaseDate());
            pst.setString(6, movie.getMovieCoverImage());
            pst.setString(7, movie.getMovieTrailer());

            pst.setInt(8, movie.getMovieID());

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
    public boolean removeMovie(Connection con, Movies movie){
        try {
            String removeMovie = "DELETE FROM tblMovies WHERE movie_id = ?";
            PreparedStatement pst = con.prepareStatement(removeMovie);

            pst.setInt(1, movie.getMovieID());
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

    public Connection getDBConnetion() {
        Connection con = connectDB();
        createTables(con);
        return con;
    }
}

