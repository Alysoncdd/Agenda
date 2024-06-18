package Principal;

import java.util.ArrayList;
import java.util.Scanner;
import DAO.ContatoDAO;
import model.Contato;

public class CadContatos {
    private static Scanner scanner = new Scanner(System.in);
    private static ContatoDAO dao = new ContatoDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Contato");
            System.out.println("2. Alterar Contato");
            System.out.println("3. Excluir Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarContato();
                    break;
                case 2:
                    alterarContato();
                    break;
                case 3:
                    excluirContato();
                    break;
                case 4:
                    listarContatos();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: "); // Novo campo
        String endereco = scanner.nextLine();

        Contato contato = new Contato(nome, telefone, email, endereco); // Passa o novo campo
        if (dao.inserir(contato)) {
            System.out.println("Contato cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar contato.");
        }
    }

    private static void alterarContato() {
        System.out.print("ID do Contato a ser alterado: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: "); // Novo campo
        String endereco = scanner.nextLine();

        Contato contato = new Contato(id, nome, telefone, email, endereco); // Passa o novo campo
        if (dao.alterar(contato)) {
            System.out.println("Contato alterado com sucesso!");
        } else {
            System.out.println("Erro ao alterar contato.");
        }
    }

    private static void excluirContato() {
        System.out.print("ID do Contato a ser excluído: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (dao.excluir(id)) {
            System.out.println("Contato excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir contato.");
        }
    }

    private static void listarContatos() {
        ArrayList<Contato> contatos = dao.buscarTodos();
        System.out.println("Lista de Contatos:");
        for (Contato contato : contatos) {
            System.out.println("ID: " + contato.getId() + ", Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone() + ", Email: " + contato.getEmail() + ", Endereço: " + contato.getEndereco());
        }
    }
}