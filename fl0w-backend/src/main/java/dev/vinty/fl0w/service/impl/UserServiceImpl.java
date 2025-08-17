package dev.vinty.fl0w.service.impl;

import dev.vinty.fl0w.dto.UserDTO;
import dev.vinty.fl0w.entity.User;
import dev.vinty.fl0w.mapper.UserMapper;
import dev.vinty.fl0w.repository.UserRepository;
import dev.vinty.fl0w.service.UserService;
import org.springframework.stereotype.Service;
import dev.vinty.fl0w.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Service implementation for UserService interface use (Business Logic Layer + orchestrated calls to the repository layer)
@Service
public class UserServiceImpl implements UserService {

    // Constructor injection for UserRepository to ensure that the service has access to the user data layer
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user by mapping the provided UserDTO to a User entity, saving it to the database, and returning the saved user as a UserDTO
     *
     * @param userDTO the user data transfer object containing user information
     * @return the created user as a UserDTO
     */
    @Override
    public UserDTO createUser(UserDTO userDTO) {

        // Map UserDTO to User entity
        User user = UserMapper.mapToUser(userDTO);
        if (user != null) {
            User savedUser = userRepository.save(user);

            // Return the saved user as UserDTO
            return UserMapper.mapToDTO(savedUser);
        }

        return null;
    }

    /**
     * Retrieves a user by their ID, throwing a ResourceNotFoundException if the user does not exist
     *
     * @param userId the ID of the user to retrieve
     * @return the UserDTO of the found user
     * @throws ResourceNotFoundException if the user with the given ID does not exist
     */
    @Override
    public UserDTO getUserById(Long userId) {

        // Find the user by ID using the repository, but add custom logic to handle the case where the user is not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> ResourceNotFoundException.userNotFound(userId)); // If user not found, call factory method with userId

        // Map the found User entity to UserDTO and return it
        return UserMapper.mapToDTO(user);

    }

    /**
     * Retrieves all users from the database, mapping each User entity to a UserDTO and returning a list of UserDTOs
     *
     * @return a List of UserDTOs representing all users in the database
     */
    @Override
    public List<UserDTO> getAllUsers() {

        // Fetch all users from the repository
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw ResourceNotFoundException.USERS_NOT_FOUND; // If no users found, throw static singleton exception
        }

        return users.stream() // Transform the List into a Stream for processing
                .filter(Objects::nonNull) // Filter out any null User entities
                .map(UserMapper::mapToDTO) // Map each User entity to UserDTO
                .collect(Collectors.toList()); // Collect the mapped UserDTOs into a List
    }


}
