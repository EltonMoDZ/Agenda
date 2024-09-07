package util;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    ArrayList<Contato> contatos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Agenda() {
        menuOpcoes();
    }

    private void menuOpcoes() {
        int opcao;
        do {
            menu();
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    Menu.ADICIONAR.criarNovoContato(sc, contatos);
                    break;
                case 2:
                    Menu.DETALHAR.listar(sc, contatos);
                    break;
                case 3:
                    Menu.EDITAR.editarContato(sc, contatos);
                    break;
                case 4:
                    Menu.REMOVER.removerContato(sc, contatos);
                    break;
                case 5:
                    Menu.SAIR.sair();
                    break;
                default:
                    continue;
            }
        } while (opcao != 5);
    }

    private void menu() {
        System.out.println("######");
        System.out.println("AGENDA");
        System.out.println("######");
        int i = 1;
        System.out.println(">>>> Contatos <<<<");
        System.out.println("Selecione a opcão desejada!!");
        for (Menu opcao : Menu.values()) {
            System.out.println(i + " " + "-" + " " + opcao.name());
            i++;
        }

    }

}