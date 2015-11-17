package NumerosAleatorios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GeradorDeNumeros {

	public GeradorDeNumeros() {

	}

	public double geraNumeroAleatorio() {
		return 1 + (Math.random() * 100);
	}

	public void salvaDados(int qntAGerar) {
		FileOutputStream fluxo;
		DataOutputStream stream;
		int i = 0;

		try {
			fluxo = new FileOutputStream("resources/saida_g1.dat");
			stream = new DataOutputStream(fluxo);

			while (i < qntAGerar) {
				stream.writeDouble(geraNumeroAleatorio());
				i++;
			}

			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
