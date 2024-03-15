package Exe3;

public class Segmento {
    private String nomeProduto;
    private String nomeSegmento;

    public Segmento(String nomeProduto, String nomeSegmento){
        this.nomeProduto = nomeProduto;
        this.nomeSegmento = nomeSegmento;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeSegmento() {
        return nomeSegmento;
    }

    public void setNomeSegmento(String nomeSegmento) {
        this.nomeSegmento = nomeSegmento;
    }

    public String toString() {
        return "Nome do produto: " + nomeProduto + " Nome do segmento: " + nomeSegmento;
    }
}
