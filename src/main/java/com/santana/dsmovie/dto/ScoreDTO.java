package com.santana.dsmovie.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ScoreDTO {
	
	private Long movieID;
	private String email;
	private Double score;

}
