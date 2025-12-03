package org.model;

import lombok.Getter;

@Getter
public enum Categoria {
    ALIMENTACAO("Alimentação"),
    TRANSPORTE("Transporte"),
    LAZER("Lazer"),
    SAUDE("Saúde"),
    EDUCACAO("Educação"),
    OUTROS("Outros");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}