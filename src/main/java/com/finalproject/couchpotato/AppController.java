package com.finalproject.couchpotato;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//Original Completed by Selina
@SuppressWarnings("Duplicates")
@Controller
public class AppController {

    Movies movie = new Movies();
    Actors actor = new Actors();
    Reviews review = new Reviews();
    Users user = new Users();


    @GetMapping("/viewReviews")
    public String viewReviews(Model model) {
        review.getAllReviews();
        model.addAttribute("review", Reviews.reviews);
        return "viewReviews";
    }

    @GetMapping("/addReview")
    public String reviewToAdd(Model model) {
        int nextID = Reviews.reviews.size() + 1;
        System.out.println(nextID);
        Reviews review = new Reviews();
        review.setReview_id(nextID);
        model.addAttribute("review", review);
        return "addReview";
    }

    @PostMapping("/addingReview")
    public String reviewAdded(@ModelAttribute Reviews review) {
        review.addNewReview(review);
        return "index";
    }

    @GetMapping("/editDeleteReview")
    public String editDeleteReview(Model model) {
        model.addAttribute("review", Reviews.reviews);
        model.addAttribute("reviewEdit", new Reviews());
        return "editDeleteReview";
    }

    @PostMapping("/editReview")
    public String reviewToEdit(@ModelAttribute Reviews review, Model model) {
        Reviews r = new Reviews();
        for (Reviews rev : Reviews.reviews) {
            if (rev.getReview_id() == review.getReview_id()) {
                r = rev;
            }
        }
        model.addAttribute("review", r);
        return "editReview";
    }

    @PostMapping("/reviewSaved")
    public String reviewSaved(@ModelAttribute Reviews review) {
        review.updateReview(review);
        return "index";
    }

    @PostMapping("/reviewDelete")
    public String reviewToDelete(@ModelAttribute Reviews review, Model model) {
        Reviews r = new Reviews();
        for (Reviews rev : Reviews.reviews) {
            if (rev.getReview_id() == review.getReview_id()) {
                r = rev;
            }
        }
        model.addAttribute("review", r);
        return "reviewDelete";
    }

    @PostMapping("/reviewDeleted")
    public String reviewDeleted(@ModelAttribute Reviews review) {
        review.deleteReview(review);
        return "index";
    }

    @GetMapping("/viewMovies")
    public String viewMovies(Model model) {
        movie.getAllMovies();
        model.addAttribute("movie", Movies.movies);
        return "viewMovies";
    }

    @GetMapping("/viewMoviesByUser")
    public String viewMoviesByUser(Model model) {
        movie.getAllMovies();
        model.addAttribute("movie", Movies.movies);
        model.addAttribute("aMovie", new Movies());
        return "viewMoviesByUser";
    }

    @GetMapping("/viewMovieDetails")
    public String viewMovieDetails(Model model) {
        movie.getAllMovies();
        model.addAttribute("movie", Movies.movies);
        model.addAttribute("aMovie", new Movies());
        return "viewMovieDetails";
    }
    
    @PostMapping("/selectedMovieDetails")
    public String selectedMovieDetails(@ModelAttribute Movies movie, Model model) {
        Movies userSelectedMovie = new Movies();
        for (Movies mv : Movies.movies) {
            if (mv.getMovie_id() == movie.getMovie_id()) {
                userSelectedMovie = mv;
            }
        }
        model.addAttribute("movie", userSelectedMovie);
        return "selectedMovieDetails";
    }

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
        return "index";
    }

    @GetMapping("/editDeleteMovie")
    public String editDeleteMovie(Model model) {
        model.addAttribute("movie", Movies.movies);
        model.addAttribute("movieEdit", new Movies());
        model.addAttribute("movieDelete", new Movies());
        return "editDeleteMovie";
    }

    @PostMapping("/editMovie")
    public String movieToEdit(@ModelAttribute Movies movie, Model model) {
        Movies m = new Movies();
        for (Movies mv : Movies.movies) {
            if (mv.getMovie_id() == movie.getMovie_id()) {
                m = mv;
            }
        }
        model.addAttribute("movie", m);
        return "editMovie";
    }

    @PostMapping("/movieSaved")
    public String movieSaved(@ModelAttribute Movies movie) {
        movie.updateMovie(movie);
        return "index";
    }

    @PostMapping("/deleteMovie")
    public String movieToDelete(@ModelAttribute Movies movie, Model model) {
        Movies m = new Movies();
        for (Movies mv : Movies.movies) {
            if (mv.getMovie_id() == movie.getMovie_id()) {
                m = mv;
            }
        }
        model.addAttribute("movie", m);
        return "deleteMovie";
    }

    @PostMapping("/movieDeleted")
    public String movieDeleted(@ModelAttribute Movies movie) {
        movie.deleteMovie(movie);
        return "index";
    }

    @GetMapping("/viewActors")
    public String viewActors(Model model) {
        actor.getAllActors();
        model.addAttribute("actor", Actors.actors);
        return "viewActors";
    }

    @GetMapping("/listActors")
    public String listActors(Model model) {
        actor.getAllActors();
        model.addAttribute("actor", Actors.actors);
        return "listActors";
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
        return "index";
    }

    @GetMapping("/editDeleteActor")
    public String editDeleteActor(Model model) {
        model.addAttribute("actor", Actors.actors);
        model.addAttribute("actorEdit", new Actors());
        return "editDeleteActor";
    }

    @PostMapping("/editActor")
    public String actorToEdit(@ModelAttribute Actors actor, Model model) {
        Actors a = new Actors();
        for (Actors ac : Actors.actors) {
            if (ac.getActor_id() == actor.getActor_id()) {
                a = ac;
            }
        }
        model.addAttribute("actor", a);
        return "editActor";
    }

    @PostMapping("/actorSaved")
    public String actorSaved(@ModelAttribute Actors actor) {
        actor.updateActorProfileList(actor);
        return "index";
    }

    @PostMapping("/actorDelete")
    public String actorToDelete(@ModelAttribute Actors actor, Model model) {
        Actors a = new Actors();
        for (Actors ac : Actors.actors) {
            if (ac.getActor_id() == actor.getActor_id()) {
                a = ac;
            }
        }
        model.addAttribute("actor", a);
        return "actorDelete";
    }

    @PostMapping("/actorDeleted")
    public String actorDeleted(@ModelAttribute Actors actor) {
        actor.deleteActor(actor);
        return "index";
    }

    @GetMapping("/testpage")
    public String testpage(Model model) {
        return "testpage";
    }

    @GetMapping("/viewUsers")
    public String viewUsers(Model model) {
        user.getAllUsers();
        model.addAttribute("user", Users.users);
        return "viewUsers";
    }

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        user.getAllUsers();
        model.addAttribute("user", Users.users);
        return "listUsers";
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
        return "index";
    }


    @GetMapping("/editDeleteUser")
    public String editDeleteUser(Model model) {
        model.addAttribute("user", Users.users);
        model.addAttribute("userEdit", new Users());
        return "editDeleteUser";
    }

    @PostMapping("/editUser")
    public String userToEdit(@ModelAttribute Users user, Model model) {
        Users u = new Users();
        for (Users usr : Users.users) {
            if (usr.getUser_id() == user.getUser_id()) {
                u = usr;
            }
        }
        model.addAttribute("user", u);
        return "editUser";
    }

    @PostMapping("/userSaved")
    public String userSaved(@ModelAttribute Users user) {
        user.updateUserRecord(user);
        return "index";
    }

    @PostMapping("/userDelete")
    public String userToDelete(@ModelAttribute Users user, Model model) {
        Users u = new Users();
        for (Users usr : Users.users) {
            if (usr.getUser_id() == user.getUser_id()) {
                u = usr;
            }
        }
        model.addAttribute("user", u);
        return "userDelete";
    }

    @PostMapping("/userDeleted")
    public String userDeleted(@ModelAttribute Users user) {
        user.deleteUser(user);
        return "index";
    }

}


