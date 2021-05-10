package com.coderulagam.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderulagam.movies.Dao.MovieRepository;
import com.coderulagam.movies.model.Movie;

@Controller
@RequestMapping("/")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping(method=RequestMethod.GET,value="/movies/{actor}")
	public String getMovieInfo(@PathVariable("actor") String name , Model model) {

		/*
		 * List<Movie> list = new ArrayList<Movie>(); Movie m1 = new Movie();
		 * m1.setActorName("Tom"); m1.setName("MI4");
		 * m1.setDecription("Thrilling & adventure");
		 */

		List<Movie> list = movieRepository.findMoviesByActorName(name);

		//	list.add(m1);
		model.addAttribute("movies",list);
		return "movieList"; 
	}

	@RequestMapping(method=RequestMethod.POST,value="/movies",consumes="application/json")
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie){
		movieRepository.save(movie);

		return ResponseEntity.ok().build();
	}


}
