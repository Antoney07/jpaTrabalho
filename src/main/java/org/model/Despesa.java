package org.model;

import jakarta.persistence.*;

import java.time.LocalDate;

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Despesa() {
    }

    public Despesa(String categoria, LocalDate data, double valor, int id, String descricao) {
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.id = id;
        this.descricao = descricao;
    }


}
