package com.finalproject.couchpotato;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {

    Movies movie = new Movies();
    Actors actor = new Actors();
    Reviews review = new Reviews();
    Users user = new Users();

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
