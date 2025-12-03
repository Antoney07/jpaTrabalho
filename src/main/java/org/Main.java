package org;

import org.model.Despesa;
import org.model.DespesaService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DespesaService service = new DespesaService();

        int opcao;

        do {
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    Despesa d = new Despesa();
                    System.out.print("Descrição: ");
                    d.setDescricao(sc.nextLine());
                    System.out.print("Valor: ");
                    d.setValor(sc.nextDouble());
                    d.setData(LocalDate.now());
                    service.salvar(d);
                    break;

                case 2:
                    service.listar().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("ID da despesa: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    Despesa du = new Despesa();
                    du.setId(idUpdate);
                    System.out.print("Nova descrição: ");
                    du.setDescricao(sc.nextLine());
                    service.atualizar(du);
                    break;

                case 4:
                    System.out.print("ID para remover: ");
                    int idDelete = sc.nextInt();
                    service.excluir(idDelete);
                    break;
            }
        } while(opcao != 0);
    }
}
