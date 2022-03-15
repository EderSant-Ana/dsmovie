package com.santana.dsmovie.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santana.dsmovie.dto.MovieDTO;
import com.santana.dsmovie.dto.ScoreDTO;
import com.santana.dsmovie.service.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {
	
	private final ScoreService scoreService;
		
	public ScoreController(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {

		return scoreService.saveScore(dto);
	}

}
