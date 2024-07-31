package com.projectnetflix.netflix.Repository;

import com.projectnetflix.netflix.Model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Adminrepo extends MongoRepository<Admin,Long> {
}
