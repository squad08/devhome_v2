package com.devhome.models;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class CursoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico")
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Double valor;

	@Lob
	@Column(name = "imagem", columnDefinition = "LONGBLOB")
	private byte[] imagemBytes;

	public void setImagem(MultipartFile imagem) throws IOException {
		this.imagemBytes = imagem.getBytes();
	}

	public enum Nivel {
		Fácil, Intermediário, Difícil
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Nivel nivel;

	// Getter e Setter para 'nivel'
	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public CursoModel() {

	}

	public CursoModel(Long id, String nome, String descricao, Double valor, byte[] imagemBytes, Nivel nivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.imagemBytes = imagemBytes;
		this.nivel = nivel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public byte[] getImagemBytes() {
		return imagemBytes;
	}

	public void setImagemBytes(byte[] imagemBytes) {
		this.imagemBytes = imagemBytes;
	}

	@Override
	public String toString() {
		return "CursoModel [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor
				+ ", imagemBytes=" + Arrays.toString(imagemBytes) + ", nivel=" + nivel + "]";
	}

}