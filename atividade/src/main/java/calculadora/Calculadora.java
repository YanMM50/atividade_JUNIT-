package calculadora;

/**
 * Calculadora com operações básicas: soma, subtração, multiplicação e divisão.
 */
public class Calculadora {

    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * @throws ArithmeticException se b for zero
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Erro: divisão por zero não é permitida.");
        }
        return a / b;
    }
}
