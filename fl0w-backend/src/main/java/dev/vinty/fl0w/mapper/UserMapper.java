package dev.vinty.fl0w.mapper;

import dev.vinty.fl0w.dto.UserDTO;
import dev.vinty.fl0w.entity.User;

/**
 * Mapper class to convert User entity to UserDTO.
 * This class provides a method to map User objects to UserDTO objects.
 */
public class UserMapper {

    /**
     * Maps a User entity to a UserDTO.
     * @param user the User entity to map
     * @return a UserDTO containing the mapped data
     */
    public static UserDTO mapToDTO(User user) {
        if (user == null) {
            return null;
        }

        // Return a new UserDTO object with the properties from the User entity
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername());
    }

    /**
     * Maps a UserDTO to a User entity.
     * @param userDTO the UserDTO to map
     * @return a User entity containing the mapped data
     */
    public static User mapToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        // Return a new User entity with the properties from the UserDTO
        return new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getUsername()  );
    }
}
