package com.projectnetflix.netflix.Repository;

import com.projectnetflix.netflix.Model.AuthUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthGuserRepo extends MongoRepository<AuthUser,Long> {
    Optional<AuthUser> findByGusername(String username);
}
