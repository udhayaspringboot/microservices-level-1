package com.movieinfoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@RequestMapping("/{movieId}")
	public Movie getMovies(@PathVariable String movieId)
	{
		
		return new Movie(movieId,"Gravity");
	}

}
