package web.Spring_Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.Spring_Rest.service.UserService;

import java.security.Principal;


@Controller
public class UsersController {

    private final UserService service;


    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public String userInfo(Principal principal, Model model) {
        model.addAttribute("user", service.getByUsername(principal.getName()));

        return "user";
    }
}
