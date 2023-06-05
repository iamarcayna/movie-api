package com.rnacode.movieapi.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rnacode.movieapi.Models.Movie;
import com.rnacode.movieapi.Services.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
// @CrossOrigin(origins = "http://localhost:3006", methods = {
// RequestMethod.GET, RequestMethod.POST })
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> findAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/trailers")
    public ResponseEntity<List<Movie>> findAllTrailers() {
        return new ResponseEntity<List<Movie>>(movieService.findAllTrailers(), HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<Optional<Movie>> findMovieByTitle(@PathVariable String title) {
        return new ResponseEntity<Optional<Movie>>(movieService.findMovieByTitle(title),
                HttpStatus.OK);
    }

    @GetMapping("/watch/{imdbId}")
    public ResponseEntity<Optional<Movie>> findMovieById(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.findMovieById(imdbId),
                HttpStatus.OK);
    }
}
