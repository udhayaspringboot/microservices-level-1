package com.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.moviecatalogservice.model.ListRatings;
import com.moviecatalogservice.model.Movie;
import com.moviecatalogservice.model.MovieCatalog;
import com.moviecatalogservice.model.Ratings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public /* Map<Ratings,MovieCatalog> */ List<MovieCatalog> getMovies(@PathVariable String userId) {

		//RestTemplate restTemplate = new RestTemplate();
		// = restTemplate.getForObject("http://localhost:8081/movies/movie1", Movie.class);

	
//		List<Ratings> lisRat = new ArrayList<Ratings>();
//		lisRat.add(new Ratings("movie1", 4));
//		lisRat.add(new Ratings("movie2", 3));

		ListRatings rating = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, ListRatings.class);
		
		/*
		 * Map<Ratings,MovieCatalog> map = new HashMap<Ratings, MovieCatalog>(); for
		 * (Ratings ratings : lisRat) {
		 * 
		 * map.put(ratings, new MovieCatalog("Gravity","Sci-fy movie",4));
		 * 
		 * }
		 */

		return rating.getListRatings().stream().map(lisRa -> 
		{
			
			Movie mov = restTemplate.getForObject("http://movie-info-service/movies/"+lisRa.getMovieId(), Movie.class);
			
		//Movie mov =	webClientBuilder.build().get().uri("http://localhost:8081/movies/"+lisRa.getMovieId()).retrieve().bodyToMono(Movie.class).block();
		return new MovieCatalog(mov.getMovieName(), "Sci-fy ed movie", lisRa.getRating());
		
	})
				.collect(Collectors.toList());

	}

}
