package com.movie.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.bean.Movie;
import com.movie.bean.Movies;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Movies getAllMovies() {
		ResponseEntity<Movies> response = restTemplate.getForEntity("http://localhost:8085/movies", Movies.class);
		
		if(response.getStatusCode() != HttpStatus.NO_CONTENT) {
			Movies movies = response.getBody();
			return movies;
		}
		System.out.println(response.getBody());
		
		return null;
	}

	@Override
	public Movie getMovieById(int id) {
		ResponseEntity<Movie> response = restTemplate.getForEntity("http://localhost:8085/movies/" + id, Movie.class);
		
		if(response.getStatusCode() != HttpStatus.NOT_FOUND) {
			Movie movie = response.getBody();
			return movie;
		}
		System.out.println(response.getBody());
		
		return null;
	}

}
