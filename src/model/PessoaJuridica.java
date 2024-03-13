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

public class PessoaJuridica extends Pessoa implements Serializable {
    protected String cnpj;
    
    // Construtor padrao
    public PessoaJuridica(){
        super();
    }
    
    // Construtor completo
    public PessoaJuridica (int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    public String getCNPJ() {
        return this.cnpj;
    }
    
    public void setCNPJ (String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: "+this.cnpj);
    }
}
