package dev.vinty.fl0w.service.impl;

import dev.vinty.fl0w.dto.UserDTO;
import dev.vinty.fl0w.entity.User;
import dev.vinty.fl0w.mapper.UserMapper;
import dev.vinty.fl0w.repository.UserRepository;
import dev.vinty.fl0w.service.UserService;
import org.springframework.stereotype.Service;

// Service implementation for UserService interface use
@Service
public class UserServiceImpl implements UserService {

    // Constructor injection for UserRepository
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Creates a new user by mapping UserDTO to User entity, saving it to the database, and returning the mapped UserDTO
    @Override
    public UserDTO createUser(UserDTO userDTO) {

        // Map UserDTO to User entity
        User user = UserMapper.mapToUser(userDTO);
        if (user != null) {
            User savedUser = userRepository.save(user);

            // Return the saved user as UserDTO via UserMapper function
            return UserMapper.mapToDTO(savedUser);
        }

        return null;
    }
}
