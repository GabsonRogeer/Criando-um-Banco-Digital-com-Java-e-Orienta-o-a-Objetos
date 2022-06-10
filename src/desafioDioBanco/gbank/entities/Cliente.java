package desafioDioBanco.gbank.entities;

import java.util.Date;

public class Cliente {
    private String nome;
    private Date dataDeNascimento;
    private String cpf;

    public Cliente() {}

    public Cliente(String nome, Date dataDeNascimento, String cpf) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "Nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", cpf='" + cpf + '\'';
    }
}

