package com.rnacode.movieapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rnacode.movieapi.Models.Movie;
import com.rnacode.movieapi.Repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovieById(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public List<Movie> findAllTrailers() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }
}
