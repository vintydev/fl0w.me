package dev.vinty.fl0w.repository;

import dev.vinty.fl0w.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for User entity methods fetched from extended JpaRepository
public interface UserRepository extends JpaRepository<User, Long> { // User is the entity type, Long is the ID type

    // Additional query methods can be defined here if we need

    


}
