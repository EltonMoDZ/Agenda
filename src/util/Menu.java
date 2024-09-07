package util;

import java.util.Scanner;
import java.util.ArrayList;

public enum Menu {
    ADICIONAR {
        @Override
        public void criarNovoContato(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Qual o nome do contato?");
            String nome = sc.nextLine();
            System.out.println("Qual o telefone do contato?");
            String telefone = sc.nextLine();
            System.out.println("Qual o email do contato?");
            String email = sc.nextLine();
            contatos.add(new Contato(nome, telefone, email));
        }
    }, DETALHAR {
        @Override
        public void listar(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Lista de contatos:");
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }, EDITAR {
        @Override
        public void editarContato(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Digite o nome do contato a ser editado:");
            String nome = sc.nextLine();
            for (Contato contato : contatos) {
                if (contato.getNome().equals(nome)) {
                    System.out.println("Contato encontrado. Insira os novos dados.");
                    System.out.println("Novo telefone:");
                    contato.setTelefone(sc.nextLine());
                    System.out.println("Novo email:");
                    contato.setEmail(sc.nextLine());
                    System.out.println("Contato atualizado.");
                    return;
                }
            }
            System.out.println("Contato não encontrado.");
        }
    }, REMOVER {
        @Override
        public void removerContato(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Digite o nome do contato a ser removido:");
            String nome = sc.nextLine();
            Contato contatoRemover = null;
            for (Contato contato : contatos) {
                if (contato.getNome().equals(nome)) {
                    contatoRemover = contato;
                    break;
                }
            }
            if (contatoRemover != null) {
                contatos.remove(contatoRemover);
                System.out.println("Contato removido.");
            } else {
                System.out.println("Contato não encontrado.");
            }
        }
    }, SAIR {
        @Override
        public void sair() {
            System.out.println("Saindo do sistema.");
        }
    };

    public void criarNovoContato(Scanner sc, ArrayList<Contato> contatos) {
        throw new UnsupportedOperationException("Esta operação não está disponível para esta opção.");
    }

    public void listar(Scanner sc, ArrayList<Contato> contatos) {
        throw new UnsupportedOperationException("Esta operação não está disponível para esta opção.");
    }

    public void editarContato(Scanner sc, ArrayList<Contato> contatos) {
        throw new UnsupportedOperationException("Esta operação não está disponível para esta opção.");
    }

    public void removerContato(Scanner sc, ArrayList<Contato> contatos) {
        throw new UnsupportedOperationException("Esta operação não está disponível para esta opção.");
    }

    public void sair() {
        throw new UnsupportedOperationException("Esta operação não está disponível para esta opção.");
    }
}
