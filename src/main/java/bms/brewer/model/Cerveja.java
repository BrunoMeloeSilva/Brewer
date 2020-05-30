package bms.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import bms.brewer.validation.SKU;


@Entity
@Table(name = "cerveja") // Esta anotação é para mudar o nome da tabela no banco de dados.
public class Cerveja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank(message = "SKU é obrigatório")
	//Obriga o valor que vier ter este padrao definido pelo regex
	//Se eu colocar o simbolo ? no final "([a-zA-Z]{2}\\d{4})?" 
	//esta validacao so ocorrerá quando houver valor
	//@Pattern(regexp = "([a-zA-Z]{2}\\d{4})", message = "SKU deve conter duas letras e quatro numeros")
	
	//Anotacao customizada que eu criei !
	@SKU
	private String sku;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@NotBlank
	@Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
	private String descricao;

	@NotNull
	@NumberFormat(pattern = "#,##0.00")
	@DecimalMin("0.01")
	@DecimalMax(value = "1000.00", message = "Não existe cerveja que custe mais de R$ 1.000,00")
	private BigDecimal valor;

	@NotNull
	@Column(name = "teor_alcoolico")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal teorAlcoolico;

	//Issa formatação é obrigatória, pois o valor chegará como 10,00 devido o maskMonkey
	// e deve ser convertido para 10.00 para poder ser aceito pelo objeto. Essa anotação
	//pega o numero e formata conforme o pattern definido.
	@NotNull
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal comissao;

	@NotNull
	@Column(name = "quantidade_estoque")
	@NumberFormat(pattern = "#,##0")
	@Max(value = 9999, message = "O limite suportado pelo estoque em uma única entrada é 9.999")
	private Integer quantidadeEstoque;

	@NotNull
	@Enumerated(EnumType.STRING) //EnumType.STRING porque eu quero que vá a descricao para o DB, e não o index.
	private Origem origem;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Sabor sabor;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")//renomeando a fk
	private Estilo estilo;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cerveja [codigo=" + codigo + ", sku=" + sku + ", nome=" + nome + ", descricao=" + descricao + ", valor="
				+ valor + ", teorAlcoolico=" + teorAlcoolico + ", comissao=" + comissao + ", quantidadeEstoque="
				+ quantidadeEstoque + ", origem=" + origem + ", sabor=" + sabor + ", estilo=" + estilo +" ]\n"
				+ "Estilo [codigo=" + estilo.getCodigo() + ", nome=" + estilo.getNome()+ " ]\n"
				+ "Origem [ordinal=" + origem.ordinal() + ", nome=" + origem.name()+ " ]\n"
				+ "Sabor  [ordinal=" + sabor.ordinal() + ", nome=" + sabor.name()+ " ]";
	}

	
	
	

}