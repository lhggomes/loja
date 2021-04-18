package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosPessoais dadosPessoais;

    public String getNome(){
        return this.dadosPessoais.getNome();
    }

    public String getCPF(){
        return this.dadosPessoais.getCpf();
    }

    public Cliente() {
    }

    public Cliente(String nome, String cpf){
        this.dadosPessoais = new DadosPessoais(nome, cpf);
    }


    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
