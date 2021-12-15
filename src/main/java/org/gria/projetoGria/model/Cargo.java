package org.gria.projetoGria.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_cargos")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O nome da empresa é obrigatorio")
	private String empresa;

	@NotNull(message = "O nome do cargo é obrigatorio")
	private String nome;
	
	@NotNull(message = "O nivel docargo é obrigatorio")
	private String nivel;
	
	@NotNull(message = "O periodo do cargo é obrigatorio")
	private String periodo;
	
	@NotNull(message = "A regiao do cargo é obrigatorio")
	private String regiao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}


	
	
}
