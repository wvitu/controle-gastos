package br.com.vitor.controlegastos;

import br.com.vitor.controlegastos.model.Gasto;
import br.com.vitor.controlegastos.service.GastoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GastoService gastoService = new GastoService();

        int opcao;
        do {
            System.out.println("\n=== Controle de Gastos ===");
            System.out.println("[1] Adicionar gasto");
            System.out.println("[2] Listar todos os gastos");
            System.out.println("[3] Mostrar total gasto");
            System.out.println("[4] Filtrar por categoria");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do gasto: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a data (dd/MM/yyyy): ");
                    String dataStr = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate data = null;
                    try {
                        data = LocalDate.parse(dataStr, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
                        break;
                    }

                    System.out.print("Digite a categoria: ");
                    String categoria = scanner.nextLine();

                    System.out.print("Digite uma descrição (opcional): ");
                    String descricao = scanner.nextLine();

                    Gasto novoGasto = new Gasto(valor, data, categoria, descricao);
                    gastoService.adicionarGasto(novoGasto);
                    break;

                case 2:
                    List<Gasto> gastos = gastoService.listarGastos();
                    if (gastos.isEmpty()) {
                        System.out.println("Nenhum gasto registrado.");
                    } else {
                        gastos.forEach(System.out::println);
                    }
                    break;

                case 3:
                    double total = gastoService.calcularTotalGasto();
                    System.out.printf("Total gasto: R$ %.2f\n", total);
                    break;

                case 4:
                    System.out.print("Digite a categoria para filtrar: ");
                    String catFiltro = scanner.nextLine();
                    List<Gasto> filtrados = gastoService.filtrarPorCategoria(catFiltro);
                    if (filtrados.isEmpty()) {
                        System.out.println("Nenhum gasto encontrado para esta categoria.");
                    } else {
                        filtrados.forEach(System.out::println);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
