package DAO;

import java.util.ArrayList;
import model.Contato;

public class ContatoDAO {
    private ArrayList<Contato> contatos = new ArrayList<>();
    private int idCounter = 1;

    public boolean inserir(Contato contato) {
        contato = new Contato(idCounter++, contato.getNome(), contato.getTelefone(), contato.getEmail(), contato.getEndereco());
        contatos.add(contato);
        return true;
    }

    public boolean alterar(Contato contato) {
        for (Contato c : contatos) {
            if (c.getId() == contato.getId()) {
                c.setNome(contato.getNome());
                c.setTelefone(contato.getTelefone());
                c.setEmail(contato.getEmail());
                c.setEndereco(contato.getEndereco()); // Altera o endereço
                return true;
            }
        }
        return false;
    }

    public boolean excluir(int id) {
        return contatos.removeIf(c -> c.getId() == id);
    }

    public ArrayList<Contato> buscarTodos() {
        return contatos;
    }
}