package com.example.demo.Repository;

import com.example.demo.user.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Movie,String> {
}
