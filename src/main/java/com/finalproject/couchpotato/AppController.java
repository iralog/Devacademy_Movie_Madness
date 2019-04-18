package com.finalproject.couchpotato;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/Duplicates/
@Controller
public class AppController {

    Movies movie = new Movies();
    Actors actor = new Actors();
    Reviews review = new Reviews();
    Users user = new Users();

    @GetMapping("/viewMovies")

    @GetMapping("/addMovie")

    @GetMapping("/movieAdded")

    @GetMapping("/editDeleteMovie")

    @GetMapping("/bookSaved")

    @GetMapping("/bookDelete")

    @GetMapping("/bookDeleted")

}

