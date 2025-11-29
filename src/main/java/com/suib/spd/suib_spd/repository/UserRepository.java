package com.suib.spd.suib_spd.repository;

import com.suib.spd.suib_spd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.accountStatus = 'ACTIVE'")
    List<User> findActiveUsers();

    List<User> findByEmailContaining(String email);
}
