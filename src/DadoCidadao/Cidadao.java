package DadoCidadao;

import java.io.Serializable;
import java.util.List;

public class Cidadao implements Serializable {

	private static final long serialVersionUID = -4209096359779519321L;
	private String nome;
	private int idade;
	private List<String> atividadesFisicas;
	private ExpectativaDeVida expectativaDeVida;

	public Cidadao(String nome, int idade, List<String> atividadesFisicas) {
		this.nome = nome;
		this.idade = idade;
		this.atividadesFisicas = atividadesFisicas;
		this.expectativaDeVida = new CalculoParaSedentario(idade);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<String> getAtividadesFisicas() {
		return atividadesFisicas;
	}

	public String getAtividadesFisicasFormatada() {
		if (atividadesFisicas.isEmpty()) {
			return "";
		}

		StringBuilder atividades = new StringBuilder();

		for (String atividade : atividadesFisicas) {
			atividades.append(atividade + ", ");
		}

		return atividades.substring(0, atividades.length() - 2);
	}

	public void setAtividadesFisicas(List<String> atividadesFisicas) {
		this.atividadesFisicas = atividadesFisicas;
	}
	
	public void determinaExpectativaDeVida() {

		if (atividadesFisicas.isEmpty()) {
			expectativaDeVida = new CalculoParaSedentario(idade);
		} else {
			expectativaDeVida = new CalculoParaAtleta(idade, atividadesFisicas.size());
		}
	}
	
	public void getExpectativaDeVida() {
		determinaExpectativaDeVida();
		String mensagem = this.nome + " ainda deve viver uns " + expectativaDeVida.anosAViver()
				+ " anos (Total: " + (expectativaDeVida.anosAViver() + this.idade) + " anos);";
		System.out.println(mensagem);
	}

	@Override
	public String toString() {
		return this.nome + ", " + this.idade + " anos. Atividade(s): "
				+ getAtividadesFisicasFormatada();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object outroCidadao) {
		if (outroCidadao instanceof Cidadao) {
			Cidadao novoCidadao = (Cidadao) outroCidadao;
			if (this.nome.equals((novoCidadao).getNome())) {
				return true;
			}
		}
		return false;

	}

}
