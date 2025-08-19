package dev.vinty.fl0w.exception;

/**
 * Custom exception to be thrown when a requested resource is not found.
 * This exception extends RuntimeException, allowing it to be thrown without being declared in method signatures.
 */
public class ResourceNotFoundException extends RuntimeException {

    // Private constructor to prevent instantiation from outside
    private ResourceNotFoundException(String message) {
        super(message, null, false, false); // Disable stack trace and suppression for performance
    }

    // Declare singleton instances for common static exceptions
    public static final ResourceNotFoundException USER_NOT_FOUND =
            new ResourceNotFoundException("User not found.");

    public static final ResourceNotFoundException USERS_NOT_FOUND =
            new ResourceNotFoundException("No users were found.");

    public static final ResourceNotFoundException TASK_NOT_FOUND =
            new ResourceNotFoundException("Task not found.");


    // Factory methods to create specific instances of ResourceNotFoundException with custom messages
    /**
     * Factory method to create a ResourceNotFoundException for a specific user ID.
     * @param id the ID of the user that was not found
     * @return a ResourceNotFoundException instance with a message indicating the user ID
     */
    public static ResourceNotFoundException userNotFound(Long id) {
        return new ResourceNotFoundException("A user not found with ID: " + id.toString());
    }
}

