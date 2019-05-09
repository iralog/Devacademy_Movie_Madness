package com.finalproject.couchpotato.controller;

import com.finalproject.couchpotato.Actors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActorController {
    Actors actor = new Actors();

    @GetMapping("/editDeleteActor")
    public String editDeleteActor(Model model) {
        actor.getAllActors();
        model.addAttribute("actor", Actors.actors);
        model.addAttribute("actorEdit", new Actors());
        return "editDeleteActor";
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
        return "editDeleteActor";
    }

    @PostMapping("/actorSaved")
    public String actorSaved(@ModelAttribute Actors actor) {
        actor.updateActorProfileList(actor);
        return "editDeleteActor";
    }
}
