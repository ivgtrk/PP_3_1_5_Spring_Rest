package web.Spring_Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.Spring_Rest.model.User;
import web.Spring_Rest.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {

    private final UserService service;

    @Autowired
    public UserRESTController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<User> getUser(Principal principal){
        return new ResponseEntity<>(service.getByUsername(principal.getName()), HttpStatus.OK);
    }
}
