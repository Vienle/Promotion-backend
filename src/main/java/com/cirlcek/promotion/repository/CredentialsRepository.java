package com.cirlcek.promotion.repository;

import com.cirlcek.promotion.entities.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsRepository  extends JpaRepository<Credentials,String> {
    Optional<Credentials> getFirstByAcessToken(String token);
}
