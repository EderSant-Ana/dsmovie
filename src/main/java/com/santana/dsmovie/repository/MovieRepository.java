package com.santana.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santana.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
