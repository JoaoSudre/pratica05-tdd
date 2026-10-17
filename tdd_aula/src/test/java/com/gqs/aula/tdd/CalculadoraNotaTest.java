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
}