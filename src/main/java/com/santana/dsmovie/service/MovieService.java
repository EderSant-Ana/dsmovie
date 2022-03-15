package com.santana.dsmovie.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santana.dsmovie.dto.MovieDTO;
import com.santana.dsmovie.entities.Movie;
import com.santana.dsmovie.repository.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = movieRepository.findAll(pageable);
		
		Page<MovieDTO> page = result.map(movie -> new MovieDTO(movie));
		
		return page;
	}
	
	public MovieDTO findById(Long id) {
		Movie movie = movieRepository.findById(id).get();
		return new MovieDTO(movie);		
	}
	
}
