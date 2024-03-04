// @author Beatriz Moresco Joaquim e Haiko Rudiger
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Audiencia {
    private Date dataAudiencia;
    private String recomendacaoTribunal;
    private SimpleDateFormat formatoData;

    public Audiencia(String dataAudiencia, String recomendacaoTribunal) throws ParseException {
        this.formatoData = new SimpleDateFormat("dd/MM/yyyy");
        setDataAudiencia(dataAudiencia);
        setRecomendacaoTribunal(recomendacaoTribunal);
    }

    public Date getDataAudiencia() {
        return dataAudiencia;
    }

    public void setDataAudiencia(String dataAudiencia) throws ParseException {
        if (dataAudiencia == null || dataAudiencia.trim().isEmpty()) {
            throw new IllegalArgumentException("Data não pode ser vazia!");
        }
        this.dataAudiencia = formatoData.parse(dataAudiencia);
    }

    public String getRecomendacaoTribunal() {
        return recomendacaoTribunal;
    }

    public void setRecomendacaoTribunal(String recomendacaoTribunal) {
        if (recomendacaoTribunal == null || recomendacaoTribunal.trim().isEmpty()) {
            throw new IllegalArgumentException("Recomendação inválida! Este campo precisa ser preenchido.");
        }
        this.recomendacaoTribunal = recomendacaoTribunal;
    }
}