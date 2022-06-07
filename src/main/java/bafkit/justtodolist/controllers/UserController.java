package bafkit.justtodolist.controllers;

import bafkit.justtodolist.domain.Todo;
import bafkit.justtodolist.domain.User;
import bafkit.justtodolist.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/todo")
    public ResponseEntity<Todo> createUser(@RequestBody Todo todo) {
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
}
