package desafioDioBanco;

import java.util.Date;

public class Cliente extends Conta {

    private String nome;
    private Date dataDeNascimento;
    private String cpf;

    public Cliente() {
        super(cliente);
    }

    public String getNome() {
        return nome;
    }


    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento() {
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
    public void imprimirExtrato() {

    }
}
