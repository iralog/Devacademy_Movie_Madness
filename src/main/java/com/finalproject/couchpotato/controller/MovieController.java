package com.finalproject.couchpotato.controller;

import com.finalproject.couchpotato.Movies;
import com.finalproject.couchpotato.Reviews;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MovieController {
    Movies movie = new Movies();
    Reviews review = new Reviews();

    @GetMapping("/viewMovies")
    public String viewMovies(Model model) {
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
            if (rv.getMovie_id() == movie.getMovie_id()) {
                reviewList.add(rv);
            }
        }
        model.addAttribute("reviews", reviewList);
        model.addAttribute("movie", m);
        return "viewMovieDetails";
    }

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
        return "editDeleteMovie";
    }

    @PostMapping("/movieSaved")
    public String movieSaved(@ModelAttribute Movies movie) {
        movie.updateMovie(movie);
        return "editDeleteMovie";
    }
}
