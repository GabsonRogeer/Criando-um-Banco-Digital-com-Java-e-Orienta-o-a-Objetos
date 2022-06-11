package desafioDioBanco.gbank.entities;

import java.util.Date;

public class Instituicao {
    private String nome;
    private String cnpj;
    private Date dataDeCriacao;
    private String codigo;

    public Instituicao() {
        this.nome = "GBank";
        this.cnpj = "85.577.999/0023-14";
        this.dataDeCriacao = new Date();
        this.codigo = "0013";
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public String getCodigo() {
        return codigo;
    }
}
