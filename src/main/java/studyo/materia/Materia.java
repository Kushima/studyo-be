package studyo.materia;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Materia {

	@Id
	private String id;

	@Indexed(unique=true)
	private String nome;
	private String descricao;
	private String cor;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
