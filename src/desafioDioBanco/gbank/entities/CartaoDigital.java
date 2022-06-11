package desafioDioBanco.gbank.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class CartaoDigital {
    private Integer numeroDoCartao;
    private Date validade;
    private Integer cvv;

    public CartaoDigital()throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Random random = new Random();

        this.numeroDoCartao = random.nextInt(16);
        this.cvv = random.nextInt(3);
        this.validade = simpleDateFormat.parse("01/12/2029");
    }

    public Integer getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public Date getValidade() {
        return validade;
    }

    public Integer getCvv() {
        return cvv;
    }
}
