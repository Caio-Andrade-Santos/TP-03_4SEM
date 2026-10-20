/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp03.pkg2sem;

/**
 *
 * @author cavia
 */
public class Pessoa {

    // Atributos protegidos (#)
    protected static int kp;   // contador de pessoas criadas
    protected String nome;
    protected char sexo;
    protected int idade;

    // Construtor padrão
    public Pessoa() {
        setKp();
    }

    // Construtor com parâmetros
    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        setKp();
    }

    // Setters
    public void setKp() {
        kp++;   // incrementa o contador a cada pessoa criada
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Getters
    public int getKp() {
        return kp;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}
