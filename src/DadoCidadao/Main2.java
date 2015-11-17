package DadoCidadao;

public class Main2 {

	public static void main(String[] args) {
		LeitorDeDados leitorDeDados = new LeitorDeDados();
		leitorDeDados.carregaListaCidadaos();
		
		System.out.println("=====  Lista de Cidadaos  =====");
		leitorDeDados.listaCidadaos();
		System.out.println("=====  Expectativa de Vida  =====");
		leitorDeDados.determinaExpectativaDeVida();
		System.out.println("__________________________________");	
	}
}
