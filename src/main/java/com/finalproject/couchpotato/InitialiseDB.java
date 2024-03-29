package com.finalproject.couchpotato;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.sqlite.SQLiteConfig;

@SuppressWarnings("Duplicates")
@Service
public class InitialiseDB {

    public Connection connectDB() {
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            con = DriverManager.getConnection("jdbc:sqlite:" +
                            "./lib/MovieMadnessDB.db",
                    config.toProperties());
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }
        return con;
    }

    public void addNewMovie(Connection con, Movies movie) {
        try {
            String addMovie = "INSERT INTO tblMovies (movie_title, movie_summary," +
                    " movie_duration, movie_genre, movie_release_date, movie_cover_image," +
                    " movie_trailer) VALUES " +
                    "(?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addMovie);
            pst.setString(1, movie.getMovie_title());
            pst.setString(2, movie.getMovie_summary());
            pst.setString(3, movie.getMovie_duration());
            pst.setString(4, movie.getMovie_genre());
            pst.setString(5, movie.getMovie_releaseDate());
            pst.setString(6, movie.getMovie_coverImage());
            pst.setString(7, movie.getMovie_trailer());

            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
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
                movie.setMovie_releaseDate(rs.getString("movie_release_date"));
                movie.setMovie_coverImage(rs.getString("movie_cover_image"));
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

    public boolean updateMovie(Connection con, Movies movie) {
        try {
            String updateMovie = "UPDATE tblMovies SET movie_title = ?, movie_summary = ?, movie_duration = ?," +
                    "movie_genre = ?, movie_release_date = ?, movie_cover_image = ?, movie_trailer = ? WHERE movie_id = ?";

            PreparedStatement pst = con.prepareStatement(updateMovie);

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
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean deleteMovie(Connection con, Movies movie) {
        try {
            String deleteMovie = "DELETE FROM tblMovies WHERE movie_id = ?";
            PreparedStatement pst = con.prepareStatement(deleteMovie);

            pst.setInt(1, movie.getMovie_id());
            pst.executeUpdate();

            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        } finally {
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
            String addUsers = "INSERT INTO tblUsers (username, password, user_name, user_age,user_email," +
                    " user_join_date) VALUES " +
                    "(?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addUsers);
            pst.setString(1, user.getUser_username());
            pst.setString(2, user.getUser_password());
            pst.setString(3, user.getUser_name());
            pst.setInt(4, user.getUser_age());
            pst.setString(5, user.getUser_email());
            pst.setString(6, user.getUser_joinDate());

            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean updateUserRecord(Connection con, Users user) {
        try {
            String updateRecord = "UPDATE tblUsers SET username= ?, password = ?, user_name = ?," +
                    "user_age = ?, user_email = ?, user_join_date = ? WHERE user_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, user.getUser_username());
            pst.setString(2, user.getUser_password());
            pst.setString(3, user.getUser_name());
            pst.setInt(4, user.getUser_age());
            pst.setString(5, user.getUser_email());
            pst.setString(6, user.getUser_joinDate());

            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean deleteUser(Connection con, Users user) {
        try {
            String removeUser = "DELETE FROM tblUsers WHERE user_id = ?";
            PreparedStatement pst = con.prepareStatement(removeUser);

            pst.setInt(1, user.getUser_id());
            pst.executeUpdate();

            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        } finally {
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
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_username(rs.getString("username"));
                user.setUser_password(rs.getString("password"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_age(rs.getInt("user_age"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_joinDate(rs.getString("user_join_date"));

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
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean deleteReview(Connection con, Reviews review) {
        try {
            String removeReview = "DELETE FROM tblReviews WHERE review_id = ?";
            PreparedStatement pst = con.prepareStatement(removeReview);

            pst.setInt(1, review.getReview_id());
            pst.executeUpdate();

            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        } finally {
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
                int user_id=rs.getInt("user_id");
                int movie_id=rs.getInt("movie_id");
                String review_comment = rs.getString("review_comment");
                int review_rating = rs.getInt("review_rating");
                String review_date = rs.getString("review_date");

                Reviews review = new Reviews(review_id,user_id,movie_id,review_comment, review_rating, review_date);
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

    public boolean updateReview(Connection con, Reviews review) {
        try {
            String updateRecord = "UPDATE tblReviews SET review_comment= ?, review_rating = ?" +
                    "review_date = ?, WHERE review_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, review.getReview_comment());
            pst.setInt(2, review.getReview_rating());
            pst.setString(3, review.getReview_date());

            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        } finally {
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
            String addActors = "INSERT INTO tblActors (actor_age, actor_name, actor_gender, actor_profile_image) VALUES " +
                    "(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addActors);
            pst.setInt(1, actor.getActor_age());
            pst.setString(2, actor.getActor_name());
            pst.setString(3, actor.getActor_gender());
            pst.setString(4, actor.getActor_profilePhoto());

            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean deleteActor(Connection con, Actors actor) {
        try {
            String removeActor = "DELETE FROM tblActors WHERE actor_id = ?";
            PreparedStatement pst = con.prepareStatement(removeActor);

            pst.setInt(1, actor.getActor_id());
            pst.executeUpdate();

            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean updateActorsProfileList(Connection con, Actors actor) {
        try {
            String updateRecord = "UPDATE tblActors SET actor_age= ?, actor_name = ?, actor_gender" +
                    "actor_profile_image = ?, WHERE actor_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, actor.getActor_name());
            pst.setInt(2, actor.getActor_age());
            pst.setString(3, actor.getActor_gender());
            pst.setString(4, actor.getActor_profilePhoto());

            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        } finally {
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
                String actor_profilePhoto = rs.getString("actor_profile_image");

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

    public ArrayList<CastRepo> getCastRepo(Connection con) {

        ArrayList<CastRepo> castRepo = new ArrayList<CastRepo>();
        Statement stmnt = null;

        try {
            String getCastRepoQuery =
                    "SELECT tm.movie_id, tmc.movie_cast_id, ta.actor_name, ta.actor_profile_image FROM tblMovieCast tmc JOIN tblMovies tm USING (movie_id) JOIN tblActors ta USING (actor_id) ORDER BY tmc.movie_id;";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getCastRepoQuery);

            while (rs.next()) {
                CastRepo cast = new CastRepo();
                cast.setMovie_id(rs.getInt("movie_id"));
                cast.setCast_id(rs.getInt("cast_id"));
                cast.setActor_name(rs.getString("actor_name"));
                cast.setActor_profilePhoto(rs.getString("actor_profilePhoto"));

                castRepo.add(cast);
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
        return castRepo;
    }

    public ArrayList<ReviewRepo> getReviewRepo(Connection con) {

        ArrayList<ReviewRepo> reviewRepo = new ArrayList<ReviewRepo>();
        Statement stmnt = null;

        try {
            String getReviewRepoQuery =
                    "SELECT tm.movie_id,tu.username,tr.review_rating,tr.review_comment,tr.review_date  FROM tblReviews tr JOIN tblMovies tm USING (movie_id) JOIN tblUsers tu USING (user_id) ORDER BY tm.movie_id;";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getReviewRepoQuery);

            while (rs.next()) {
                ReviewRepo review = new ReviewRepo();
                review.setMovie_id(rs.getInt("movie_id"));
                review.setUsername(rs.getString("username"));
                review.setReview_rating(rs.getInt("review_rating"));
                review.setReview_comment(rs.getString("review_comment"));
                review.setReview_date(rs.getString("review_date"));

                reviewRepo.add(review);
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
        return reviewRepo;
    }

    public Connection getDBConnection() {
        Connection con = connectDB();
        return con;
    }
}