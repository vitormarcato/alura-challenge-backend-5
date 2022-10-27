package br.com.challenge.backend.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.backend.entities.Video;

@RestController
@RequestMapping(value = "/videos")
public class VideoResource {
	
	@GetMapping
	public ResponseEntity<Video> findAll() {
		Video video = new Video(1L, "Semana01", "Live sobre desafio da semana 1", "https://urldovideo.com");
		return ResponseEntity.ok().body(video);
	}
}
