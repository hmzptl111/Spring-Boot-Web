package com.movie.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.bean.Movie;
import com.movie.bean.Movies;
import com.movie.model.persistence.MovieDao;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao movieDao;

	@Override
	public Movies getAllMovies() {
		Movies movies = new Movies(movieDao.findAll());
		return movies;
	}

	@Override
	public Movie getMovieById(int id) {
		Optional<Movie> movie = movieDao.findById(id);
		if(movie.isPresent()) {
			return movie.get();
		}
		
		return null;
	}
}