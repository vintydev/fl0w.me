package dev.vinty.fl0w.controller;
import dev.vinty.fl0w.dto.UserDTO;
import dev.vinty.fl0w.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This class is a REST controller; handles HTTP requests/responses for user-related operations
@RestController
@RequestMapping("/api/users") // Maps requests to /api/users URL to this controller
@CrossOrigin(origins = "http://localhost:3000") // Allows cross-origin requests from the specified origin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Sets the response status to 201 Created
    public UserDTO createUser(@RequestBody UserDTO userDTO) { // @RequestBody indicates that the user data will be sent in the request body as JSON

        // Call the service to create a user and return the created user data
        return userService.createUser(userDTO); // Return 201 Created with userDTO as body (JSON)

    }

    // Handles GET requests to retrieve a user by ID
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    // Build get all users REST API endpoint
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<UserDTO> users = userService.getAllUsers();

        return ResponseEntity.ok(users); // Return 200 OK with the list of users

    }

    // Build update user REST API endpoint
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId, @RequestBody UserDTO userDTO) {

        UserDTO updatedUser = userService.updateUser(userId, userDTO);

        return ResponseEntity.ok(updatedUser); // Return 200 OK with the updated user data

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Sets the response status to 204 No Content
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {

        userService.deleteUser(userId); // Call the service to delete the user by ID
        return ResponseEntity.ok("User deleted successfully"); // Return 200 OK with a success message

    }

}
