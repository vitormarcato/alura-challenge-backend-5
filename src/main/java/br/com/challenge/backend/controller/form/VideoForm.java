package br.com.challenge.backend.controller.form;

import br.com.challenge.backend.modelo.Video;

public class VideoForm {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	public Video converter( VideoForm form) {
		return new Video(titulo, descricao, url);
	}
	
	
}
