package com.projectnetflix.netflix.Repository;

import com.projectnetflix.netflix.Model.Guser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuserRepo extends MongoRepository<Guser,Long> {
}
