package DadoCidadao;

public class Main {
	public static void main(String[] args) {
		LeitorDeDados leitor = new LeitorDeDados();
		leitor.leArquivoCVS("resources/cidadaoscsv.txt");
	}
}
