package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.movie.bean.Movie;
import com.movie.bean.Movies;
import com.movie.model.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@GetMapping(path = "/movies")
	public ModelAndView getAllMovies() {
		ModelAndView modelAndView = new ModelAndView();
		Movies movies = movieService.getAllMovies();
		
		if(movies == null) {
			modelAndView.addObject("message", "No movies");
		}
		
		modelAndView.addObject("movies", movies.getMovies());
		modelAndView.setViewName("movies");
		return modelAndView;
	}
	
	@GetMapping(path = "/movies/{id}")
	public ModelAndView getMovieById(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Movie movie = movieService.getMovieById(id);
		
		if(movie == null) {
			modelAndView.addObject("message", "Movie not found");
		}
		
		modelAndView.addObject("movie", movie);
		modelAndView.setViewName("movie");
		return modelAndView;
	}
}
