package com.finalproject.couchpotato.controller;

import com.finalproject.couchpotato.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    Users user = new Users();

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

    @GetMapping("/editDeleteUser")
    public String editDeleteUser(Model model) {
        user.getAllUsers();
        model.addAttribute("user", Users.users);
        model.addAttribute("userEdit", new Users());
        return "editDeleteUser";
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
        return "editDeleteUser";
    }

    @PostMapping("/userSaved")
    public String userSaved(@ModelAttribute Users user) {
        user.updateUserRecord(user);
        return "editDeleteUser";
    }


    @GetMapping("/userProfile")
    public String userProfile(@RequestParam(value = "user_id", required = false,
            defaultValue = "1") int user_id, Model model) {
        Users u = new Users();

        for (Users ur : Users.users) {
            if (ur.getUser_id() == user_id) {
                u = ur;
            }
        }
        model.addAttribute("user", u);
        return "userProfile";
    }

}
