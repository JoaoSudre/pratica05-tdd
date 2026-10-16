package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {
    @Test
void deveAprovarComNota70() {
CalculadoraNota calc = new CalculadoraNota();
assertTrue(calc.estaAprovadoPorNota(70));
}

    @Test
void deveReprovarComNota69() {
CalculadoraNota calc = new CalculadoraNota();
assertFalse(calc.estaAprovadoPorNota(69));
}
}