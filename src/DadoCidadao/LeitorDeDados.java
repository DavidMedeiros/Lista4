package DadoCidadao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeDados {

	private List<Cidadao> listaDeCidadaos;

	public LeitorDeDados() {
		listaDeCidadaos = new ArrayList<Cidadao>();
	}

	public void leArquivoCVS(String arquivoASerLido) {
		try {
			FileReader fluxo = new FileReader(arquivoASerLido);
			BufferedReader stream = new BufferedReader(fluxo);
			String linha;
			// carrega lista de cidadaos cadastrados
			carregaListaCidadaos();

			while ((linha = stream.readLine()) != null) {
				String[] dados = linha.split(",");

				String nome = dados[0];
				int idade = Integer.valueOf(dados[1]);
				List<String> atividadesFisicas = getAtividadesFisicas(dados);

				Cidadao novoCidadao = new Cidadao(nome, idade,
						atividadesFisicas);
				
				//TODO: VERIFICAR UMA FORMA MAIS INTELIGENTE DE FAZER ESSA CHEGAGEM
				
				// Verifica se a lista já contem o objeto, caso contenha, irah
				// atualizar as informacoes de idade e atividades fisicas
				if (listaDeCidadaos.contains(novoCidadao)) {
					for (Cidadao cidadao : listaDeCidadaos) {
						if (cidadao.equals(novoCidadao)) {
							cidadao.setIdade(idade);
							cidadao.setAtividadesFisicas(atividadesFisicas);
						}
					}
					// caso nao contenha, o novo objeto serah criado.
				} else {
					listaDeCidadaos.add(novoCidadao);
				}

			}

			stream.close();

			salvaListaCidadaos();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listaCidadaos() {
		if (listaDeCidadaos.isEmpty()) {
			System.out.println("Nenhum cidadão cadastrado.");
		}
		for (Cidadao cidadao : listaDeCidadaos) {
			System.out.println(cidadao.toString());
		}
	}

	public void salvaListaCidadaos() {
		File arquivo = new File("resources/cidadaosCadastrados.dat");
		try {
			FileOutputStream fluxo = new FileOutputStream(arquivo);
			ObjectOutputStream stream = new ObjectOutputStream(fluxo);

			stream.writeObject(listaDeCidadaos);

			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void carregaListaCidadaos() {
		File arquivo = new File("resources/cidadaosCadastrados.dat");
		try {
			FileInputStream fluxo = new FileInputStream(arquivo);
			ObjectInputStream stream = new ObjectInputStream(fluxo);

			listaDeCidadaos = (List<Cidadao>) stream.readObject();

			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void determinaExpectativaDeVida() {
		for (Cidadao cidadao : listaDeCidadaos) {
			cidadao.getExpectativaDeVida();;
		}
	}

	private List<String> getAtividadesFisicas(String[] dados) {
		List<String> atividadesFisicas = new ArrayList<String>();

		for (int i = 2; i < dados.length; i++) {
			atividadesFisicas.add(dados[i]);
		}
		return atividadesFisicas;
	}

}
