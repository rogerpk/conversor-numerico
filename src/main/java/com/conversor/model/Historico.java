package com.conversor.model;

import java.util.ArrayList;
import java.util.List;

public class Historico {

    private List<Conversao> lista = new ArrayList<>();

    public void adicionar(Conversao conversao) {
        lista.add(conversao);
    }

    public List<Conversao> listar() {
        return lista;
    }

    public void limpar() {
        lista.clear();
    }
}