package com.gqs.aula.tdd;

public class CalculadoraNota {

    public static final double NOTA_MINIMA_APROVACAO = 70.0;

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0.0 || nota > notaMaxima) {
            throw new IllegalArgumentException(nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
        }
    }

    public double calcularNotaFinal(double a1, double a2, double a3) {
        validarNota(a1, 30.0, "A1");
        validarNota(a2, 30.0, "A2");
        validarNota(a3, 40.0, "A3");
        return a1 + a2 + a3;
    }

    public boolean estaAprovadoPorNota(double notaFinal) {
        return notaFinal >= NOTA_MINIMA_APROVACAO;
    }

    public static final double FREQUENCIA_MINIMA = 75.0;

    public String situacao(double notaFinal, double frequencia) {
        if (estaAprovadoPorNota(notaFinal) && frequencia >= FREQUENCIA_MINIMA) {
            return "APROVADO";
        }
        return "REPROVADO";
    }
}