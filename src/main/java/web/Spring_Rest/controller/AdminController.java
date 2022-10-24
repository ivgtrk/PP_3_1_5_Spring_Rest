package web.Spring_Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Spring_Rest.model.Role;
import web.Spring_Rest.model.User;
import web.Spring_Rest.service.UserService;

import java.security.Principal;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService service;


    @Autowired
    public AdminController(UserService service) {
        this.service = service;

    }

    @GetMapping("/users")
    public String showAllUsers(Principal principal, Model model,@ModelAttribute("user") User user) {
        model.addAttribute("users", service.getAllUsers());
        model.addAttribute("roles", Role.values());
        model.addAttribute("currentUser", service.getByUsername(principal.getName()));
        return "users";
    }


    @PostMapping
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam Set<Role> roles) {
        user.setRoles(roles);
        service.createNewUser(user);
        return "redirect:/admin/users";
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return service.getUserById(id);
    }


    @PatchMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam Set<Role> roles) {
        user.setRoles(roles);
        service.saveUser(user);
        return "redirect:/admin/users";
    }


    @DeleteMapping("/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        service.deleteUser(user.getId());
        return "redirect:/admin/users";
    }
}
