package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Plano de Testes - Calculadora
 *
 * | ID  | Operação             | Entrada      | Resultado Esperado        |
 * |-----|----------------------|--------------|---------------------------|
 * | T01 | Soma                 | 2 + 3        | 5.0                       |
 * | T02 | Subtração            | 5 - 2        | 3.0                       |
 * | T03 | Multiplicação        | 4 * 3        | 12.0                      |
 * | T04 | Divisão              | 10 / 2       | 5.0                       |
 * | T05 | Divisão por zero     | 10 / 0       | ArithmeticException       |
 * | T06 | Números negativos    | -2 + 3       | 1.0                       |
 * | T07 | Números decimais     | 2.5 * 2      | 5.0                       |
 * | T08 | Soma com zero        | 0 + 0        | 0.0                       |
 * | T09 | Subtrair negativo    | 3 - (-2)     | 5.0                       |
 * | T10 | Multiplicar por zero | 99999 * 0    | 0.0                       |
 * | T11 | Divisão decimal      | 7 / 2        | 3.5                       |
 * | T12 | Números grandes      | 1e9 + 1e9    | 2.0E9                     |
 * | T13 | Números grandes mult | 1e6 * 1e6    | 1.0E12                    |
 * | T14 | Subtração negativa   | 2 - 5        | -3.0                      |
 * | T15 | Divisão negativa     | -10 / 2      | -5.0                      |
 * | T16 | Dois negativos soma  | -3 + (-4)    | -7.0                      |
 * | T17 | Dois negativos mult  | -2 * (-3)    | 6.0                       |
 * | T18 | Divisão dois neg.    | -9 / (-3)    | 3.0                       |
 * | T19 | Soma resultado neg.  | -10 + 3      | -7.0                      |
 * | T20 | Zero dividido        | 0 / 5        | 0.0                       |
 */
@DisplayName("Testes da Calculadora")
class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    // -------------------------------------------------------------------------
    // SOMA
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("T01 - Soma de inteiros positivos: 2 + 3 = 5")
    void t01_somaInteiroPositivos() {
        assertEquals(5.0, calc.somar(2, 3));
    }

    @Test
    @DisplayName("T06 - Soma com número negativo: -2 + 3 = 1")
    void t06_somaComNegativo() {
        assertEquals(1.0, calc.somar(-2, 3));
    }

    @Test
    @DisplayName("T08 - Soma de zeros: 0 + 0 = 0")
    void t08_somaZeros() {
        assertEquals(0.0, calc.somar(0, 0));
    }

    @Test
    @DisplayName("T12 - Soma de números grandes: 1e9 + 1e9 = 2e9")
    void t12_somaGrandes() {
        assertEquals(2_000_000_000.0, calc.somar(1_000_000_000, 1_000_000_000));
    }

    @Test
    @DisplayName("T16 - Soma de dois negativos: -3 + (-4) = -7")
    void t16_somaDoisNegativos() {
        assertEquals(-7.0, calc.somar(-3, -4));
    }

    @Test
    @DisplayName("T19 - Soma com resultado negativo: -10 + 3 = -7")
    void t19_somaResultadoNegativo() {
        assertEquals(-7.0, calc.somar(-10, 3));
    }

    // -------------------------------------------------------------------------
    // SUBTRAÇÃO
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("T02 - Subtração simples: 5 - 2 = 3")
    void t02_subtracacaoSimples() {
        assertEquals(3.0, calc.subtrair(5, 2));
    }

    @Test
    @DisplayName("T09 - Subtrair número negativo: 3 - (-2) = 5")
    void t09_subtrairNegativo() {
        assertEquals(5.0, calc.subtrair(3, -2));
    }

    @Test
    @DisplayName("T14 - Subtração com resultado negativo: 2 - 5 = -3")
    void t14_subtracacaoResultadoNegativo() {
        assertEquals(-3.0, calc.subtrair(2, 5));
    }

    // -------------------------------------------------------------------------
    // MULTIPLICAÇÃO
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("T03 - Multiplicação simples: 4 * 3 = 12")
    void t03_multiplicacaoSimples() {
        assertEquals(12.0, calc.multiplicar(4, 3));
    }

    @Test
    @DisplayName("T07 - Multiplicação com decimal: 2.5 * 2 = 5.0")
    void t07_multiplicacaoDecimal() {
        assertEquals(5.0, calc.multiplicar(2.5, 2));
    }

    @Test
    @DisplayName("T10 - Multiplicação por zero: 99999 * 0 = 0")
    void t10_multiplicacaoPorZero() {
        assertEquals(0.0, calc.multiplicar(99999, 0));
    }

    @Test
    @DisplayName("T13 - Multiplicação de números grandes: 1e6 * 1e6 = 1e12")
    void t13_multiplicacaoGrandes() {
        assertEquals(1_000_000_000_000.0, calc.multiplicar(1_000_000, 1_000_000));
    }

    @Test
    @DisplayName("T17 - Multiplicação de dois negativos: -2 * (-3) = 6")
    void t17_multiplicacaoDoisNegativos() {
        assertEquals(6.0, calc.multiplicar(-2, -3));
    }

    // -------------------------------------------------------------------------
    // DIVISÃO
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("T04 - Divisão simples: 10 / 2 = 5")
    void t04_divisaoSimples() {
        assertEquals(5.0, calc.dividir(10, 2));
    }

    @Test
    @DisplayName("T05 - Divisão por zero lança exceção")
    void t05_divisaoPorZero() {
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> calc.dividir(10, 0)
        );
        assertTrue(ex.getMessage().contains("zero"));
    }

    @Test
    @DisplayName("T11 - Divisão com resultado decimal: 7 / 2 = 3.5")
    void t11_divisaoDecimal() {
        assertEquals(3.5, calc.dividir(7, 2));
    }

    @Test
    @DisplayName("T15 - Divisão com negativo: -10 / 2 = -5")
    void t15_divisaoNegativa() {
        assertEquals(-5.0, calc.dividir(-10, 2));
    }

    @Test
    @DisplayName("T18 - Divisão de dois negativos: -9 / (-3) = 3")
    void t18_divisaoDoisNegativos() {
        assertEquals(3.0, calc.dividir(-9, -3));
    }

    @Test
    @DisplayName("T20 - Zero dividido por número: 0 / 5 = 0")
    void t20_zeroDividido() {
        assertEquals(0.0, calc.dividir(0, 5));
    }
}
