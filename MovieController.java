package com.example.demo.Controller;

import com.example.demo.Service.MovieService;
import com.example.demo.user.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie createdMovie = movieService.createMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }


    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> movie = movieService.findAllMovies();
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        Optional<Movie> movie = Optional.ofNullable(movieService.findMovieByImdbId(imdbId));
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/movieName")
    public ResponseEntity<List<Movie>> getMovieByName(@PathVariable String name){
        List<Movie> movies = movieService.getMovieByName(name);
        return ResponseEntity.ok(movies);
    }

}
