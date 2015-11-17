package DadoCidadao;

public class CalculoParaAtleta implements ExpectativaDeVida {
	
	public static final double BONUS_IDOSO = 0.1;
	public static final double BONUS_JOVEM = 0.05;

	private int expectativaDeVida;
	private int numeroDeExercicios;
	private int idade;

	public CalculoParaAtleta(int idade, int numeroDeExercicios) {
		this.idade = idade;
		this.numeroDeExercicios = numeroDeExercicios;
		expectativaDeVida = 100 - idade;
	}

	@Override
	public int anosAViver() {
		expectativaDeVida = (int) (((0.05 * numeroDeExercicios) * expectativaDeVida) + expectativaDeVida);
		return (int) (expectativaDeVida * bonusIdade() + expectativaDeVida);
	}
	
	private double bonusIdade() {
		if (idade >= 60) {
			return BONUS_IDOSO;
		} else if (idade > 0 && idade <60) {
			return BONUS_JOVEM;
		}
		return -1;
	}

}
