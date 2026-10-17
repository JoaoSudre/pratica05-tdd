package com.gqs.aula.tdd;

public class CalculadoraNota {

    public static final double NOTA_MINIMA_APROVACAO = 70.0;
    public static final double FREQUENCIA_MINIMA = 75.0;

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

    public boolean podeFazerAI(double a1, double a2, double a3, double frequencia) {
        double notaFinal = calcularNotaFinal(a1, a2, a3);
        boolean naoAprovadoPorNota = !estaAprovadoPorNota(notaFinal);
        boolean frequenciaSuficiente = frequencia >= FREQUENCIA_MINIMA;
        boolean condicaoAI = (a1 + a3 >= 40.0) || (a2 + a3 >= 40.0);

        return naoAprovadoPorNota && frequenciaSuficiente && condicaoAI;
    }

    public double aplicarAI(double a1, double a2, double a3, double notaAI) {
        validarNota(notaAI, 30.0, "AI");
        validarNota(a1, 30.0, "A1");
        validarNota(a2, 30.0, "A2");
        validarNota(a3, 40.0, "A3");

        double menorNota = Math.min(a1, a2);
        if (notaAI > menorNota) {
            if (a1 == menorNota) {
                return notaAI + a2 + a3;
            } else {
                return a1 + notaAI + a3;
            }
        }
        return a1 + a2 + a3;
    }

    public static final String STATUS_APROVADO = "APROVADO";
    public static final String STATUS_REPROVADO_FALTA = "REPROVADO POR FALTA";
    public static final String STATUS_REPROVADO_NOTA = "REPROVADO POR NOTA";

    public String situacao(double notaFinal, double frequencia) {
        // A falta tem prioridade
        if (frequencia < FREQUENCIA_MINIMA) {
            return STATUS_REPROVADO_FALTA; 
        }
        if (estaAprovadoPorNota(notaFinal)) {
            return STATUS_APROVADO;
        }
        return STATUS_REPROVADO_NOTA;
    }
}