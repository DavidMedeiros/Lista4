package DadoCidadao;

public class CalculoParaSedentario implements ExpectativaDeVida {

	public static final double PUNICAO_IDOSO = 0.75;
	public static final double PUNICAO_JOVEM = 0.5;

	private int expectativaDeVida;
	private int idade;

	public CalculoParaSedentario(int idade) {
		this.idade = idade;
		expectativaDeVida = 100 - idade;
	}

	@Override
	public int anosAViver() {
		expectativaDeVida = (int) (0.5 * expectativaDeVida);
		return (int) (expectativaDeVida - (expectativaDeVida * punicaoIdade()));
	}

	private double punicaoIdade() {
		if (idade >= 60) {
			return PUNICAO_IDOSO;
		} else if (idade > 0 && idade < 60) {
			return PUNICAO_JOVEM;
		}
		return -1;
	}
}
