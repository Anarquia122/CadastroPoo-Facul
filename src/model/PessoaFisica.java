/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author italo
 */
import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    protected String cpf;
    protected int idade;
    
    //construtor padrão
    public PessoaFisica() {
        super();
    }
    
    //constritor completo
    public PessoaFisica (int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    // metodos getters
    public String getCPF() {
        return this.cpf;
    }
    
    public int getIdade() {
        return this.idade;
    }
    
    // metodos setters
    public void setCPF (String cpf) {
        this.cpf = cpf;
    }
    
    public void setIdade (int idade) {
        this.idade = idade;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: "+this.cpf);
        System.out.println("Idade: "+this.idade);
    }
}
