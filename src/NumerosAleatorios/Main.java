package NumerosAleatorios;

public class Main {

	public static final int QUANTIDADE_DE_DADOS_A_GERAR = 10;
	
	public static void main(String[] args) {
		GeradorDeNumeros gerador = new GeradorDeNumeros();
		LeitorDeDados leitor = new LeitorDeDados();

		gerador.salvaDados(QUANTIDADE_DE_DADOS_A_GERAR);
		leitor.leDados();
		leitor.calculaMedia();
	}
	
}
