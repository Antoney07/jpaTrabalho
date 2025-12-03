package org.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private double valor;
    private LocalDate data;
    private String categoria;


    public Despesa() {
    }

    public Despesa(String categoria, LocalDate data, double valor, int id, String descricao) {
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Descrição: " + descricao +
                " | Valor: " + valor +
                " | Data: " + data +
                " | Categoria: " + categoria;
    }



}
