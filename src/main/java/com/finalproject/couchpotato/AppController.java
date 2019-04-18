package com.finalproject.couchpotato;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/Duplicates/
@Controller
public class AppController {

    Movies movie = new Movies();
    Actors actor = new Actors();
    Reviews review = new Reviews();
    Users user = new Users();

    @GetMapping("/viewMovies")
    public String viewMovies(Model model){
        movie.getAllMovies();
        model.addAttribute("movie", Movies.movies);
        return "viewMovies";
    }

    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        int nextID = Movies.movies.size() + 1;
        System.out.println(nextID);


    @GetMapping("/movieAdded")

    @GetMapping("/editDeleteMovie")

    @GetMapping("/bookSaved")

    @GetMapping("/bookDelete")

    @GetMapping("/bookDeleted")

}

