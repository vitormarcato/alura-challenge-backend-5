package br.com.challenge.backend.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.challenge.backend.modelo.Video;
import br.com.challenge.backend.repository.VideoRepository;

public class UpdateVideoForm {

	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String titulo;
	
	@NotNull
	@NotEmpty
	@Length(min = 10)
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
