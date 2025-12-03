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
    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    public Despesa() {
    }

    public Despesa(LocalDate data, double valor, int id, String descricao) {
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
