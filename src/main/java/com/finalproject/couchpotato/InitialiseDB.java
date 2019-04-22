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

    protected Connection getDBConnection() {
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

    public boolean updateMovie(Connection con, Movies movie){
        try {
            String updateRecord = "UPDATE tblMovies SET movie_title = ?, movie_summary = ?, movie_duration = ?," +
                    "movie_genre = ?, movie_releaseDate = ?, movie_coverImage = ?, movie_trailer = ? WHERE movie_id = ?";

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

        public void addNewUser(Connection con, Users user) {
        try {
            String addUsers = "INSERT INTO tblUsers (user_username, user_password, user_name, user_age, user_joinDate) VALUES " +
                    "(?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addUsers);
            pst.setString(1, user.getUser_username());
            pst.setString(2, user.getUser_password());
            pst.setString(3, user.getUser_name());
            pst.setInt(4, user.getUser_age());
            pst.setString(5, user.getUser_joinDate());

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

    public boolean updateUserRecord(Connection con, Users user){
        try {
            String updateRecord = "UPDATE tblUsers SET user_ username= ?, user_password = ?, user_name = ?," +
                    "user_age = ?, user_joinDate = ? WHERE user_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, user.getUser_username());
            pst.setString(2, user.getUser_password());
            pst.setString(3, user.getUser_name());
            pst.setInt(4, user.getUser_age());
            pst.setString(5, user.getUser_joinDate());

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

    public boolean deleteUser(Connection con, Users user){
        try {
            String removeUser = "DELETE FROM tblUsers WHERE user_id = ?";
            PreparedStatement pst = con.prepareStatement(removeUser);

            pst.setInt(1, user.getUser_id());
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

    public ArrayList<Users> getUsers(Connection con) {

        ArrayList<Users> users = new ArrayList<Users>();
        Statement stmnt = null;

        try {
            String getUsersQuery = "SELECT * FROM tblUsers";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getUsersQuery);

            while (rs.next()) {
                Users user = new Users();
                user.setUser_username(rs.getString("user_username"));
                user.setUser_password(rs.getString("user_password"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_age(rs.getInt("user_age"));
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

    public void addNewReview(Connection con, Reviews review) {
        try {
            String addReviews = "INSERT INTO tblReviews (review_comment, review_rating, review_date) VALUES " +
                    "(?,?,?)";

            PreparedStatement pst = con.prepareStatement(addReviews);
            pst.setString(1, review.getReview_comment());
            pst.setInt(2, review.getReview_rating());
            pst.setString(3, review.getReview_date());

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

    public boolean deleteReview(Connection con, Reviews review){
        try {
            String removeReview = "DELETE FROM tblREviews WHERE review_id = ?";
            PreparedStatement pst = con.prepareStatement(removeReview);

            pst.setInt(1, review.getReview_id());
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

    public ArrayList<Reviews> getReviews(Connection con) {

        ArrayList<Reviews> reviews = new ArrayList<Reviews>();
        Statement stmnt = null;

        try {
            String getReviewsQuery = "SELECT * FROM tblReviews";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getReviewsQuery);

            while (rs.next()) {
                int review_id = rs.getInt("review_id");
                String review_comment = rs.getString("review_comment");
                int review_rating = rs.getInt("review_date");
                String review_date = rs.getString("review_date");

                Reviews review = new Reviews(review_id, review_comment, review_rating, review_date);
                reviews.add(review);
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
        return reviews;
    }

    public boolean updateReview(Connection con, Reviews review){
        try {
            String updateRecord = "UPDATE tblReviews SET review_comment= ?, review_rating = ?" +
                    "review_date = ?, WHERE review_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, review.getReview_comment());
            pst.setInt(2, review.getReview_rating());
            pst.setString(3, review.getReview_date());

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

    public void addNewActors(Connection con, Actors actor) {
        try {
            String addActors = "INSERT INTO tblActors (actor_age, actor_name, actor_gender, actor_profilePhoto) VALUES " +
                    "(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addActors);
            pst.setInt(1, actor.getActor_age());
            pst.setString(2, actor.getActor_name());
            pst.setString(3, actor.getActor_gender());
            pst.setString(4, actor.getActor_profilePhoto());

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

    public boolean updateActorProfileList (Connection con, Actors actor){
        try {
            String updateRecord = "UPDATE tbActors SET actor_name= ?, actor_age = ?, actor_gender = ?," +
                    "actor_profilePhoto = ? WHERE actor_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, actor.getActor_name());
            pst.setInt(2, actor.getActor_age());
            pst.setString(3, actor.getActor_gender());
            pst.setString(4, actor.getActor_profilePhoto());

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

    public boolean deleteActor(Connection con, Actors actor){
        try {
            String removeActor = "DELETE FROM tblActors WHERE actor_id = ?";
            PreparedStatement pst = con.prepareStatement(removeActor);

            pst.setInt(1, actor.getActor_id());
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

    public boolean updateActorsProfileList(Connection con, Actors actor){
        try {
            String updateRecord = "UPDATE tblActors SET actor_age= ?, actor_name = ?, actor_gender" +
                    "actor_profilePhoto = ?, WHERE actor_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, actor.getActor_name());
            pst.setInt(2, actor.getActor_age());
            pst.setString(3, actor.getActor_gender());
            pst.setString(4, actor.getActor_profilePhoto());

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

    public ArrayList<Actors> getActors(Connection con) {

        ArrayList<Actors> actors = new ArrayList<Actors>();
        Statement stmnt = null;

        try {
            String getActorsQuery = "SELECT * FROM tblActors";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getActorsQuery);

            while (rs.next()) {
                int actor_id = rs.getInt("actor_id");
                String actor_name = rs.getString("actor_name");
                int actor_age = rs.getInt("actor_age");
                String actor_gender = rs.getString("actor_gender");
                String actor_profilePhoto = rs.getString("actor_profilePhoto");

                Actors actor = new Actors(actor_id, actor_age, actor_name, actor_gender, actor_profilePhoto);
                actors.add(actor);
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
        return actors;
    }
}
