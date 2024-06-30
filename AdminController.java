package com.example.demo.Controller;

import com.example.demo.Service.AdminService;
import com.example.demo.user.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/movie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie createdMovie = adminService.createMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        Optional<Movie> movie = Optional.ofNullable(adminService.findMovieByImdbId(imdbId));
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/Name")
    public ResponseEntity<List<Movie>> getByName(@PathVariable String name){
        List<Movie> movies = adminService.getByName(name);
        return ResponseEntity.ok(movies);
    }

    @PutMapping("/movie/{imdbId}")
    public ResponseEntity<Movie> updateUser(@PathVariable String imdbId, @RequestBody Movie movie){
        Movie updatedMovie = adminService.findMovieByImdbId(imdbId);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/movie/{imdbId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String imdbId){
        adminService.deleteUserById(imdbId);
        return ResponseEntity.noContent().build();
    }
}
