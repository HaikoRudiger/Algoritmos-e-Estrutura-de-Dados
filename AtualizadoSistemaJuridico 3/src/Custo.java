// @author Beatriz Moresco Joaquim e Haiko Rudiger

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Custo {
    private Date dataCusto;
    private String descricaoCusto;
    private double valorCusto;
    private SimpleDateFormat formatoData;

    public Custo(String dataCusto, String descricaoCusto, double valorCusto) throws ParseException {
        this.formatoData = new SimpleDateFormat("dd/MM/yyyy");
        setDataCusto(dataCusto);
        setDescricaoCusto(descricaoCusto);
        setValorCusto(valorCusto);
    }

    public Date getDataCusto() {
        return dataCusto;
    }

    public void setDataCusto(String dataCusto) throws ParseException {
        
        if (dataCusto == null || dataCusto.trim().isEmpty()) {
            throw new IllegalArgumentException("Data não pode ser vazia!");
        }
        this.dataCusto = formatoData.parse(dataCusto);
    }

    public String getDescricaoCusto() {
        return descricaoCusto;
    }

    public void setDescricaoCusto(String descricaoCusto) {
        if (descricaoCusto == null || descricaoCusto.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida! Este campo precisa ser preenchido.");
        }
        this.descricaoCusto = descricaoCusto;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        if (valorCusto < 0) {
            throw new IllegalArgumentException("Valor do custo inválido! Apenas números positivos são aceitos.");
        }
        this.valorCusto = valorCusto;
    }
}