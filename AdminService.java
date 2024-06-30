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
public class AdminService {
        @Autowired
        private MongoTemplate mongoTemplate;
        private UserRepository userRepository;

        public Movie createMovie(Movie movie){
            return mongoTemplate.save(movie);
        }

        public List<Movie> getAllMovies() {
        return mongoTemplate.findAll(Movie.class);
        }

        public Movie findMovieByImdbId(String imdbId) {
            return mongoTemplate.findById(imdbId, Movie.class);
        }

        public List<Movie> getByName(String name) {
            Query query = new Query();
            query.addCriteria(Criteria.where("name").is(name));
            return mongoTemplate.find(query, Movie.class);
        }

        public Movie updateMovie(String id, Movie movie){
            Query query = new Query(Criteria.where("id").is(id));
            Update update = new Update()
                    .set("name", movie.getName());
            return mongoTemplate.findAndModify(query, update, Movie.class);
        }

        public void deleteUserById(String id){
            Query query = new Query(Criteria.where("id").is(id));
            mongoTemplate.remove(query, Movie.class);
        }
}
