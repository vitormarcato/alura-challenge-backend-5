package br.com.challenge.backend.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.challenge.backend.modelo.Video;

public class VideoDto {
//	classe para o retorno de informações da requisição, portanto, só contém getters
	
	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	
	public VideoDto(Video video) {
		this.id = video.getId();
		this.titulo = video.getTitulo();
		this.descricao = video.getDescricao();
		this.url = video.getUrl();
	}
	
	public Long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}


	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static List<VideoDto> converter(List<Video> videos) {
		return videos.stream().map(VideoDto::new).collect(Collectors.toList());
	}

}
