package br.com.challenge.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.challenge.backend.controller.dto.VideoDto;
import br.com.challenge.backend.controller.form.UpdateVideoForm;
import br.com.challenge.backend.controller.form.VideoForm;
import br.com.challenge.backend.modelo.Video;
import br.com.challenge.backend.repository.VideoRepository;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {
	
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping
	public List<VideoDto> list() {
		List<Video> videos = videoRepository.findAll();
		return VideoDto.converter(videos);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VideoDto> insert(@RequestBody VideoForm form, UriComponentsBuilder uriBuilder){
		Video video = form.converter(form);
		videoRepository.save(video);
		
		URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
		return ResponseEntity.created(uri).body(new VideoDto(video));
	}

	@GetMapping("/{id}")
	public Video findById(@PathVariable Long id) {
		Optional<Video> video = videoRepository.findById(id);
		return video.get();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VideoDto> update(@PathVariable Long id, @RequestBody UpdateVideoForm form){
		videoRepository.findById(id);
		Video video = form.update(id, videoRepository);
		return ResponseEntity.ok(new VideoDto(video));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Video> optional = videoRepository.findById(id);
		if (optional.isPresent()) {
			videoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	
}
