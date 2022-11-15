package br.com.challenge.backend.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.challenge.backend.modelo.Video;

public class VideoForm {

	
	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String titulo;
	
	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String descricao;
	
	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Video converter(VideoForm form) {
		return new Video(form.getTitulo(), form.getDescricao(), form.getUrl());
	}
	

}
