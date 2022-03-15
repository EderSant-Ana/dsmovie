package com.santana.dsmovie.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.santana.dsmovie.dto.MovieDTO;
import com.santana.dsmovie.dto.ScoreDTO;
import com.santana.dsmovie.entities.Movie;
import com.santana.dsmovie.entities.Score;
import com.santana.dsmovie.entities.User;
import com.santana.dsmovie.repository.MovieRepository;
import com.santana.dsmovie.repository.ScoreRepository;
import com.santana.dsmovie.repository.UserRepository;

@Service
public class ScoreService {

	private final MovieRepository movieRepository;
	private final UserRepository userRepository;
	private final ScoreRepository scoreRepository;
	
	public ScoreService(MovieRepository movieRepository, UserRepository userRepository,
			ScoreRepository scoreRepository) {
		this.movieRepository = movieRepository;
		this.userRepository = userRepository;
		this.scoreRepository = scoreRepository;
	}

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		System.out.println(dto);
		Movie movie = movieRepository.findById(dto.getMovieID()).get();
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score  = scoreRepository.save(score);
		
		movie.getScores();
		
		double sum = 0.0;
;
		
		for(Score s : movie.getScores()) {
			sum += s.getValue();
		}

		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
	}
	
}
