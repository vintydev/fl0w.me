package dev.vinty.fl0w.service;

import dev.vinty.fl0w.dto.UserDTO;

import java.util.List;

/**
 * UserService interface defines the contract for user-related operations
 * It provides methods to create, retrieve, and list users
 */
public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long userId, UserDTO userDTO);

    void deleteUser(Long userId);

}
