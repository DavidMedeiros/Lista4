package NumerosAleatorios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeDados {

	private List<Double> listaDeDados;

	public LeitorDeDados() {
		listaDeDados = new ArrayList<Double>();
	}

	public void leDados() {
		FileInputStream fluxo;
		DataInputStream stream;
		StringBuilder stringDeDados;
		int i = 0;

		try {
			fluxo = new FileInputStream("resources/saida_g1.dat");
			stream = new DataInputStream(fluxo);
			stringDeDados = new StringBuilder();

			stringDeDados.append("Amostra lida: ");

			while (i < stream.available()) {
				Double dado = stream.readDouble();
				listaDeDados.add(dado);
				stringDeDados.append(dado + " ");
			}

			System.out.println(stringDeDados);

			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void calculaMedia() {
		StringBuilder media = new StringBuilder();
		Double somatorio = 0.0;

		for (Double dado : listaDeDados) {
			somatorio = somatorio + dado;
		}

		media.append("A média dos dados é: ");

		if (listaDeDados.isEmpty()) {
			media.append(somatorio);
		} else {
			media.append(somatorio / listaDeDados.size());
		}

		System.out.println(media);
	}

}
