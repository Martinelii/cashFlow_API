package com.generation.cashFlow.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_movimentacoes")
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo preço não pode ser vazio!!")
	@Positive(message = "O valor não pode ser negativo!")
	BigDecimal valor;
	
	@NotBlank(message = "A Origem não pode ser vazia!!")
	private String origem;
	
	@ManyToOne
	@JsonIgnoreProperties("movimentacao")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("movimentacao")
	private Usuario usuario;
}
