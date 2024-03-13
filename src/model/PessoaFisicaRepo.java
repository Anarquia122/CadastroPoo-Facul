/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author italo
 */
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class PessoaFisicaRepo {
    private List<PessoaFisica> pessoas;
    
    public PessoaFisicaRepo() {
        this.pessoas = new ArrayList<>();
    }
    
    public void inserir (PessoaFisica pessoa) {
        pessoas.add(pessoa);
    }
    
    public void alterar (PessoaFisica pessoa) {
        for (int i = 0 ; i < pessoas.size() ; i++) {
            if (pessoas.get(i).getId() == pessoa.getId()) {
                pessoas.set(i, pessoa);
                return;
            }
        }
        System.out.println("Pessoa nao encontrada para alteracao!");
    }
    
    public void excluir (int id) {
        for (int i = 0 ; i < pessoas.size() ; i++) {
            if (pessoas.get(i).getId() == id) {
                pessoas.remove(i);
                return;
            }
        }
        System.out.println("Pessoa nao encontrada para exclusao!");
    }
    
    public PessoaFisica obter (int id) {
        for (PessoaFisica pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        System.out.println("Pessoa nao encontrada.");
        return null;
    }
    
    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(pessoas);
    }
    
    public void persistir (String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoas);
            System.out.println("Dados persistidos com sucesso!");
        } catch (IOException e) {
            throw new IOException("Erro ao persistir os dados do disco: "+e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public void recuperar (String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoas = (List<PessoaFisica>) inputStream.readObject();
            System.out.println("Dados recuperados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao recuperar os dados do disco: "+e.getMessage());
        }
    }
}
