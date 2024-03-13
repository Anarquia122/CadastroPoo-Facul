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

public class Pessoa implements Serializable {
    protected String nome;
    protected int id;
    
    //construtor padrão
    public Pessoa() {}
    
    //construtor completo
    public Pessoa (int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    public int getId() {
        return this.id;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    public void setId (int id) {
        this.id = id;
    }
    
    public static <T> void exibir(T item) {
        System.out.println("O valor eh: "+item);
    }
    
    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
    }
}
