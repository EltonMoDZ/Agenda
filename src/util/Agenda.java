package util;

public class Agenda {
    private final String[][] contatos = new String[1][3];

    public void adicionar(String nome, String email, String telefone) {
        int indice = buscarNovoIndice();
        if (indice < 0 || indice >= contatos.length) {
            System.out.println("Agenda cheia");
            return;
        }
        contatos[indice][0] = nome;
        contatos[indice][1] = email;
        contatos[indice][2] = telefone;
        System.out.println("Novo contato adicionado com sucesso");
        System.out.println();
    }

    public boolean verificarTelefoneExistente(String telefone) {
        for (String[] contato : contatos) {
            if (contato[2] != null && contato[2].equals(telefone)) return true;
        }
        return false;
    }

    public void remover(int contato) {
        contato--;
        if (contato < 0 || contato >= contatos.length || contatos[contato][0] == null) {
            System.out.println("Índice fora dos limites do array ou não existe");
            return;
        }

        contatos[contato][0] = null;
        contatos[contato][1] = null;
        contatos[contato][2] = null;

        for (int i = contato; i < contatos.length - 1; i++) {
            if (contatos[i + 1][0] != null) {
                contatos[i][0] = contatos[i + 1][0];
                contatos[i][1] = contatos[i + 1][1];
                contatos[i][2] = contatos[i + 1][2];
                contatos[i + 1][0] = null;
                contatos[i + 1][1] = null;
                contatos[i + 1][2] = null;
            } else {
                break;
            }
        }
        System.out.println("Contato removido");
        System.out.println();
    }

    public String[] listar() {
        String[] lista = new String[contatos.length];
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) {
                lista[i] = i + 1 + ": " + contatos[i][0] + " - " + contatos[i][1] + " - " + contatos[i][2];
            }
        }
        return lista;
    }

    private int buscarNovoIndice() {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] == null) {
                return i;
            }
        }
        return -1;
    }
}