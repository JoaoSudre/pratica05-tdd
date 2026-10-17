package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {

    @Test
    void deveSomarAsTresNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(20.0, 20.0, 30.0);
        assertEquals(70.0, resultado);
    }

    @Test
    void deveSomarOutrasNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(10.0, 15.0, 25.0);
        assertEquals(50.0, resultado);
    }

    @Test
    void deveAprovarComNota70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.estaAprovadoPorNota(70.0));
    }

    @Test
    void deveReprovarComNota69() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.estaAprovadoPorNota(69.0));
    }

    @Test
    void deveRejeitarA1MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(35.0, 20.0, 30.0));
    }

    @Test
    void deveRejeitarA2Invalida() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(20.0, 35.0, 30.0));
    }

    @Test
    void deveRejeitarA3Invalida() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(20.0, 20.0, 45.0));
    }

    @Test
    void deveRejeitarA1Negativa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(-1.0, 20.0, 30.0));
    }

    @Test
    void deveAceitarNotasMaximas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(30.0, 30.0, 40.0);
        assertEquals(100.0, resultado);
    }

    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("APROVADO", calc.situacao(80.0, 90.0));
    }

    @Test
    void deveReprovarComNotaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO", calc.situacao(60.0, 90.0));
    }

    @Test
    void deveReprovarPorFrequenciaMesmoComNotaAlta() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO", calc.situacao(95.0, 74.0));
    }

    @Test
    void deveAprovarComFrequenciaExatamente75() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("APROVADO", calc.situacao(70.0, 75.0));
    }

    @Test
    void devePoderFazerAIComA2MaisA3Suficiente() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10.0, 20.0, 30.0, 80.0)); // Nota 60; A2+A3 = 50
    }

    @Test
    void devePoderFazerAIComLimiteExato() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10.0, 5.0, 30.0, 80.0)); // A1+A3 = exatamente 40[cite: 26]
    }

    @Test
    void naoDevePoderFazerAISeJaAprovado() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(25.0, 25.0, 30.0, 80.0)); // Nota 80: já aprovado[cite: 26]
    }

    @Test
    void naoDevePoderFazerAIComFrequenciaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(10.0, 20.0, 30.0, 70.0)); // Frequência abaixo de 75[cite: 26]
    }

    @Test
    void deveSubstituirMenorNotaPelaAI() {
        CalculadoraNota calc = new CalculadoraNota();
        // A1=10, A2=20, A3=30. Menor é A1(10). Entra AI=25. Nova soma: 25 + 20 + 30 = 75
        assertEquals(75.0, calc.aplicarAI(10.0, 20.0, 30.0, 25.0));
    }

    @Test
    void naoDeveSubstituirSeAIBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        // AI=5 é menor que A1 e A2, então nada muda: 10 + 20 + 30 = 60
        assertEquals(60.0, calc.aplicarAI(10.0, 20.0, 30.0, 5.0));
    }

    @Test
    void deveRejeitarAIInvalida() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, 
                () -> calc.aplicarAI(10.0, 20.0, 30.0, 35.0)); // AI maior que 30
    }

    @Test
    void deveDarReprovadoPorFrequenciaMesmoComNotaAlta() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO POR FALTA", calc.situacao(95.0, 74.0));
    }

    @Test
    void deveDarReprovadoPorNota() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO POR NOTA", calc.situacao(60.0, 90.0));
    }

    @Test
    void deveDarReprovadoPorFaltaCasoAmbosFracos() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO POR FALTA", calc.situacao(50.0, 60.0));
    }
}