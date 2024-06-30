package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.user.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MovieService {

    @Autowired
    private MongoTemplate mongoTemplate;
    private UserRepository userRepository;

    public Movie createMovie(Movie movie){
            return mongoTemplate.save(movie);
        }

        public List<Movie> findAllMovies() {
            return mongoTemplate.findAll(Movie.class);
        }

    public Movie findMovieByImdbId(String imdbId) {
        return mongoTemplate.findById(imdbId, Movie.class);
    }

    public List<Movie> getMovieByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Movie.class);
    }

}
