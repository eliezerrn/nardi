package Exercicio;

import java.math.BigDecimal;

public class ProdutoModel {
	
	private String nome;
	private BigDecimal valor;
	private BigDecimal quantidade;
	
	public ProdutoModel(String nome, BigDecimal valor, BigDecimal quantidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}				
}
