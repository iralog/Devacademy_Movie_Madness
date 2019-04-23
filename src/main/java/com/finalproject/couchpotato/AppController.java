package com.finalproject.couchpotato;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "viewReviews";
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
        return "viewReviews";
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
        return "viewReviews";
    }

    @GetMapping("/viewMovies")
    public String viewMovies(Model model) {
        movie.getAllMovies();
        model.addAttribute("movie", Movies.movies);
        return "viewMovies";
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
        return "viewMovies";
    }


    @GetMapping("/editDeleteMovie")
    public String editDeleteMovie(Model model) {
        model.addAttribute("movie", Movies.movies);
        model.addAttribute("movieEdit", new Movies());
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
        return "viewMovies";
    }

    @PostMapping("/movieDelete")
    public String movieToDelete(@ModelAttribute Movies movie, Model model) {
        Movies m = new Movies();
        for (Movies mv : Movies.movies) {
            if (mv.getMovie_id() == movie.getMovie_id()) {
                m = mv;
            }
        }
        model.addAttribute("movie", m);
        return "movieDelete";
    }

    @PostMapping("/movieDeleted")
    public String movieDeleted(@ModelAttribute Movies movie) {
        movie.deleteMovie(movie);
        return "viewMovies";
    }
}
