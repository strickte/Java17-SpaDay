package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.launchcode.data.UserData;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (!user.getPassword().equals(verify)) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error", "Passwords do not match");
            return "/user/add";
        }
        UserData.add(user);
        model.addAttribute("user", user);
        model.addAttribute("users", UserData.getAll());
        return "/user/index";
    }

    @GetMapping("/details/{id}")
    public String displayUserDetails(@PathVariable int id, Model model) {
        model.addAttribute("user", UserData.getById(id));
        return "/user/details";
    }

}
