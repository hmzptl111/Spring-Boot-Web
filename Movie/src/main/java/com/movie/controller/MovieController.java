package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bean.Movie;
import com.movie.bean.Movies;
import com.movie.model.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@GetMapping(path = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movies> getAllMovies() {
		Movies movies = movieService.getAllMovies();
		if(movies == null) {
			return new ResponseEntity<Movies>(new Movies(), HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Movies>(movies, HttpStatus.FOUND);
	}
	
	@GetMapping(path = "/movies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> getMovieById(@PathVariable("id") int id) {
		Movie movie = movieService.getMovieById(id);
		if(movie == null) {
			return new ResponseEntity<Movie>(new Movie(), HttpStatus.NOT_FOUND);	
		}
		
		return new ResponseEntity<Movie>(movie, HttpStatus.FOUND);
	}
}
