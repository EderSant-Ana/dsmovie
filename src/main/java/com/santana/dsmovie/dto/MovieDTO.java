package com.santana.dsmovie.dto;

import com.santana.dsmovie.entities.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
	
	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	
	public MovieDTO(Movie movie) {
		this.id = movie.getId();
		this.title = movie.getTitle();
		this.score = movie.getScore();
		this.count = movie.getCount();
		this.image = movie.getImage();
	}

}
