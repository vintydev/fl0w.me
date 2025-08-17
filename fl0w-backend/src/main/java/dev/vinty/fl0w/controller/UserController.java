package dev.vinty.fl0w.controller;
import dev.vinty.fl0w.dto.UserDTO;
import dev.vinty.fl0w.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This class is a REST controller; handles HTTP requests/responses for user-related operations
@RestController
@RequestMapping("/api/users") // Maps requests to /api/users URL to this controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Sets the response status to 201 Created
    public UserDTO createUser(@RequestBody UserDTO userDTO) {

        // Call the service to create a user and return the created user data
        return userService.createUser(userDTO); // Return 201 Created with userDTO as body (JSON)
    }

    // Handles GET requests to retrieve a user by ID
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Build get all users REST API endpoint
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<UserDTO> users = userService.getAllUsers();

        return ResponseEntity.ok(users); // Return 200 OK with the list of users
    }
}
