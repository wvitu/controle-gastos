package br.com.vitor.controlegastos.service;

import br.com.vitor.controlegastos.model.Gasto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GastoService {

    private List<Gasto> gastos = new ArrayList<>();

    public void adicionarGasto(Gasto gasto) {
        gastos.add(gasto);
        System.out.println("Gasto adicionado com sucesso: " + gasto);
    }

    public List<Gasto> listarGastos() {
        return new ArrayList<>(gastos); // cópia de segurança
    }

    public double calcularTotalGasto() {
        return gastos.stream()
                .mapToDouble(Gasto::getValor)
                .sum();
    }

    public List<Gasto> filtrarPorCategoria(String categoria) {
        return gastos.stream()
                .filter(g -> g.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }
}
