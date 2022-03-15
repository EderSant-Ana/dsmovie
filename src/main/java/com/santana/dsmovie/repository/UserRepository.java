package com.santana.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santana.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
