package br.com.challenge.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.backend.modelo.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{
	
}
