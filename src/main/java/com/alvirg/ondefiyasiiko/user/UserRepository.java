package com.alvirg.ondefiyasiiko.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    //    @Query(
//            value = """
//                SELECT COUNT(*) > 0
//                FROM users
//                WHERE phone_number = :phoneNumber;
//            """,
//            nativeQuery = true
//    )
    Optional<User> findByEmailIgnoreCase(String email);
}
