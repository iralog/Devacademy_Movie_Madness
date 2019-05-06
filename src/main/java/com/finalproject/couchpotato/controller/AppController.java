package com.finalproject.couchpotato.controller;

import com.finalproject.couchpotato.Actors;
import com.finalproject.couchpotato.Movies;
import com.finalproject.couchpotato.Reviews;
import com.finalproject.couchpotato.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Work of Team Hakunas
@SuppressWarnings("Duplicates")
@Controller
public class AppController {

    Movies movie = new Movies();
    Actors actor = new Actors();
    Reviews review = new Reviews();
    Users user = new Users();

    //--- VIEW CONTROLLERS ---
    @GetMapping("/viewMovies")
    public String viewMoviesByUser(Model model) {
        movie.getAllMovies();
        review.getAllReviews();
        model.addAttribute("movie", Movies.movies);
        model.addAttribute("aMovie", new Movies());
        return "viewMovies";
    }

    @GetMapping("/editDeleteMovie")
    public String editDeleteMovie(Model model) {
        movie.getAllMovies();
        model.addAttribute("movie", Movies.movies);
        model.addAttribute("movieEdit", new Movies());
        model.addAttribute("movieDelete", new Movies());
        return "editDeleteMovie";
    }

    @GetMapping("/editDeleteActor")
    public String editDeleteActor(Model model) {
        actor.getAllActors();
        model.addAttribute("actor", Actors.actors);
        model.addAttribute("actorEdit", new Actors());
        return "editDeleteActor";
    }

    @GetMapping("/editDeleteReview")
    public String editDeleteReview(Model model) {
        review.getAllReviews();
        model.addAttribute("review", Reviews.reviews);
        model.addAttribute("reviewEdit", new Reviews());
        return "editDeleteReview";
    }

    @GetMapping("/editDeleteUser")
    public String editDeleteUser(Model model) {
        user.getAllUsers();
        model.addAttribute("user", Users.users);
        model.addAttribute("userEdit", new Users());
        return "editDeleteUser";
    }


    //--- END OF VIEW CONTROLLERS ---


    //--- VIEW DETAILS CONTROLLERS ---
    @GetMapping("/viewMovieDetails")
    public String viewAMovie(@RequestParam(value = "move_id", required = false,
            defaultValue = "1") int movie_id, @ModelAttribute Movies movie, Model model) {
        Movies m = new Movies();
        ArrayList<Reviews> reviewList = new ArrayList<>();
        for (Movies mv : Movies.movies) {
            if (mv.getMovie_id() == movie.getMovie_id()) {
                m = mv;
            }
        }
        for (Reviews rv : Reviews.reviews) {
            if (rv.getReviewMovie_id() == movie.getMovie_id()) {
                reviewList.add(rv);
            }
        }
        model.addAttribute("reviews", reviewList);
        model.addAttribute("movie", m);
        return "viewMovieDetails";
    }

    //--- END OF VIEW DETAILS CONTROLLERS ---



    // --- EDIT CONTROLLERS ---
    @GetMapping("/editMovie")
    public String movieToEdit(@RequestParam(value = "move_id", required = false,
            defaultValue = "1") int movie_id, @ModelAttribute Movies movie, Model model) {
        Movies m = new Movies();
        for (Movies mv : Movies.movies) {
            if (mv.getMovie_id() == movie.getMovie_id()) {
                m = mv;
            }
        }
        model.addAttribute("movie", m);
        return "editMovie";
    }

    @GetMapping("/editActor")
    public String actorToEdit(@RequestParam(value = "move_id", required = false,
            defaultValue = "1") int actor_id, @ModelAttribute Actors actor, Model model) {
        Actors a = new Actors();
        for (Actors ac : Actors.actors) {
            if (ac.getActor_id() == actor.getActor_id()) {
                a = ac;
            }
        }
        model.addAttribute("actor", a);
        return "editActor";
    }

    @GetMapping("/editUser")
    public String userToEdit(@RequestParam(value = "move_id", required = false,
            defaultValue = "1") int user_id, @ModelAttribute Users user, Model model) {
        Users u = new Users();
        for (Users usr : Users.users) {
            if (usr.getUser_id() == user.getUser_id()) {
                u = usr;
            }
        }
        model.addAttribute("user", u);
        return "editUser";
    }
    //--- END EDIT CONTROLLERS ---


    // --- DELETE CONTROLLERS ---
    @GetMapping("/deleteMovie")
    public String movieToDelete(@RequestParam(value = "move_id", required = false,
            defaultValue = "1") int movie_id, @ModelAttribute Movies movie, Model model) {
        Movies m = new Movies();
        for (Movies mv : Movies.movies) {
            if (mv.getMovie_id() == movie.getMovie_id()) {
                m = mv;
            }
        }
        model.addAttribute("movie", m);
        movie.deleteMovie(movie);
        return "editDeleteMovie";
    }

    @GetMapping("/deleteActor")
    public String actorToDelete(@RequestParam(value = "actor_id", required = false,
            defaultValue = "1") int actor_id, @ModelAttribute Actors actor, Model model) {
        Actors u = new Actors();
        for (Actors usr : Actors.actors) {
            if (usr.getActor_id() == actor.getActor_id()) {
                u = usr;
            }
        }
        model.addAttribute("actor", u);
        actor.deleteActor(actor);
        return "editDeleteActor";
    }

    @GetMapping("/deleteReview")
    public String reviewToDelete(@RequestParam(value = "review_id", required = false,
            defaultValue = "1") int review_id, @ModelAttribute Reviews review, Model model) {
        Reviews r = new Reviews();
        for (Reviews rev : Reviews.reviews) {
            if (rev.getReview_id() == review.getReview_id()) {
                r = rev;
            }
        }
        model.addAttribute("review", r);
        review.deleteReview(review);
        return "editDeleteReview";
    }

    @GetMapping("/deleteUser")
    public String userToDelete(@RequestParam(value = "user_id", required = false,
            defaultValue = "1") int user_id, @ModelAttribute Users user, Model model) {
        Users u = new Users();
        for (Users usr : Users.users) {
            if (usr.getUser_id() == user.getUser_id()) {
                u = usr;
            }
        }
        model.addAttribute("user", u);
        user.deleteUser(user);
        return "editDeleteUser";
    }


    //-- END OF DELETE CONTROLLERS --

    //-- ADD CONTROLLERS --
    @GetMapping("/addMovie")
    public String movieToAdd(Model model) {
        int nextID = Movies.movies.size() + 1;
        System.out.println(nextID);
        Movies movie = new Movies();
        movie.setMovie_id(nextID);
        model.addAttribute("movie", movie);
        return "addMovie";
    }

    @PostMapping("/addingMovie")
    public String movieAdded(@ModelAttribute Movies movie) {
        movie.addNewMovie(movie);
        return "admin";
    }

    @PostMapping("/movieSaved")
    public String movieSaved(@ModelAttribute Movies movie) {
        movie.updateMovie(movie);
        return "admin";
    }

    @GetMapping("/addActor")
    public String actorToAdd(Model model) {
        int nextID = Actors.actors.size() + 1;
        System.out.println(nextID);
        Actors actor = new Actors();
        actor.setActor_id(nextID);
        model.addAttribute("actor", actor);
        return "addActor";
    }

    @PostMapping("/addingActor")
    public String actorAdded(@ModelAttribute Actors actor) {
        actor.addNewActors(actor);
        return "admin";
    }

    @PostMapping("/actorSaved")
    public String actorSaved(@ModelAttribute Actors actor) {
        actor.updateActorProfileList(actor);
        return "admin";
    }


    @GetMapping("/addReview")
    public String reviewToAdd(Model model) {
        int nextID = Reviews.reviews.size() + 1;
        System.out.println(nextID);
        Reviews review = new Reviews();
        review.setReview_id(nextID);
        model.addAttribute("review", review);
        return "admin";
    }

    @PostMapping("/addingReview")
    public String reviewAdded(@ModelAttribute Reviews review) {
        review.addNewReview(review);
        return "admin";
    }

    @GetMapping("/addUser")
    public String userToAdd(Model model) {
        int nextID = Users.users.size() + 1;
        System.out.println(nextID);
        Users user = new Users();
        user.setUser_id(nextID);
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/addingUser")
    public String userAdded(@ModelAttribute Users user) {
        user.addNewUser(user);
        return "admin";
    }

    @PostMapping("/userSaved")
    public String userSaved(@ModelAttribute Users user) {
        user.updateUserRecord(user);
        return "admin";
    }

    //-- END OF ADD CONTROLLERS --

    //-- LOGIN CONTROLLERS

    @GetMapping("/LoginPage")
    public String LoginPage(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "LoginPage";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:admin";
    }

    @GetMapping("/SignupPage")
    public String SignupPage(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "SignupPage";
    }

    @GetMapping("/ForgotUserPass")
    public String ForgotUserPass(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "ForgotUserPass";
    }

}
