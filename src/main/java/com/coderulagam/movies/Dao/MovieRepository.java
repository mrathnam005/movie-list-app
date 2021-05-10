package com.coderulagam.movies.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderulagam.movies.model.Movie;


public interface MovieRepository<T>  extends JpaRepository<Movie, Long>{
	
	
	public List<Movie> findMoviesByActorName(final String name);
	
	

}
