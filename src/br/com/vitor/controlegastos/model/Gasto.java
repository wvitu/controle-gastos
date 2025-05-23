package br.com.vitor.controlegastos.model;

import java.time.LocalDate;
import java.util.Objects;

public class Gasto {

    private double valor;
    private LocalDate data;
    private String categoria;
    private String descricao;

    public Gasto(double valor, LocalDate data, String categoria, String descricao) {
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "valor=" + valor +
                ", data=" + data +
                ", categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gasto)) return false;
        Gasto gasto = (Gasto) o;
        return Double.compare(gasto.valor, valor) == 0 &&
                Objects.equals(data, gasto.data) &&
                Objects.equals(categoria, gasto.categoria) &&
                Objects.equals(descricao, gasto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, data, categoria, descricao);
    }
}
