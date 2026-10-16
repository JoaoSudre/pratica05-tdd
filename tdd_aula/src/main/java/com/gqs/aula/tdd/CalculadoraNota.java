package com.gqs.aula.tdd;

public class CalculadoraNota {
    public static final double NOTA_MINIMA_APROVACAO = 70;

public boolean estaAprovadoPorNota(double notaFinal) {
return notaFinal >= NOTA_MINIMA_APROVACAO;
}
}