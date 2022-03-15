package com.santana.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santana.dsmovie.entities.Score;
import com.santana.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {


}
