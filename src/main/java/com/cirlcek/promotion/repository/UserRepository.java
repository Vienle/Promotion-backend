package com.cirlcek.promotion.repository;

import com.cirlcek.promotion.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> getFirstByStaffcode(String staffCode);
}
