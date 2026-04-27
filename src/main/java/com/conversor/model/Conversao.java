package com.conversor.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversao {

    private String valorOriginal;
    private String origem;
    private String destino;
    private String resultado;
    private LocalDateTime dataHora;

    public Conversao(String valorOriginal, String origem, String destino, String resultado) {
        this.valorOriginal = valorOriginal;
        this.origem = origem;
        this.destino = destino;
        this.resultado = resultado;
        this.dataHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return dataHora.format(formato) + " | " +
                valorOriginal + " (" + origem + ") -> " +
                resultado + " (" + destino + ")";
    }
}
