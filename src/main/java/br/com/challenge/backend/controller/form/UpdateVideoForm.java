package br.com.challenge.backend.controller.form;

import br.com.challenge.backend.modelo.Video;
import br.com.challenge.backend.repository.VideoRepository;

public class UpdateVideoForm {

	private String titulo;
	private String descricao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Video update(Long id, VideoRepository videoRepository) {
		Video video = videoRepository.getReferenceById(id);
		video.setTitulo(this.titulo);
		video.setDescricao(this.descricao);

		return video;
	}

}
