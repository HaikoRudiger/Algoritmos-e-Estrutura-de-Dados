// @author Beatriz Moresco Joaquim e Haiko Rudiger
import java.util.ArrayList;
public class Processo {
    private char situacao;
    private int codigoProcesso;
    private Pessoa cliente;
    private Pessoa parteContraria;
    private String descricaoMotivo;
    private Secretaria secretaria;
    private Advogado advogado;
    private ArrayList<Audiencia> audiencias;
    private ArrayList<Custo> custos;
    private double valorTotalCusto;
    
    public Processo(char situacao, int codigoProcesso, Pessoa cliente, Pessoa parteContraria, String descricaoMotivo, Secretaria secretaria, Advogado advogado, ArrayList<Audiencia> audiencia, ArrayList<Custo> custo) {
        setSituacao(situacao);
        setCodigoProcesso(codigoProcesso);
        setCliente(cliente);
        setParteContraria(parteContraria);
        setDescricaoMotivo(descricaoMotivo);
        setSecretaria(secretaria);
        setAdvogado(advogado);
        audiencias = new ArrayList<Audiencia>();
        custos = new ArrayList<Custo>();
    }
    
    public void setValorTotalCusto(double valorTotalCusto) {
        this.valorTotalCusto = valorTotalCusto;
    }
 
    public char getSituacao() {
        return situacao;
    }
 
    public void setSituacao(char situacao) throws IllegalStateException {
        if (!Character.isDefined(situacao) || Character.isWhitespace(situacao)) {
            throw new IllegalArgumentException("Situação inválida! Esse campo precisa ser preenchido com um caractere válido.");
        }
        this.situacao = situacao;
    }
 
    public int getCodigoProcesso() {
        return codigoProcesso;
    }
 
    public void setCodigoProcesso(int codigoProcesso) throws IllegalArgumentException {
        if (codigoProcesso < 0) {
            throw new IllegalArgumentException("Valor do código do processo inválido! Apenas números positivos são aceitos.");
        }
        this.codigoProcesso = codigoProcesso;
    }
    
    public Pessoa getCliente() {
        return cliente;
    }
 
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }
 
    public Pessoa getParteContraria() {
        return parteContraria;
    }
 
    public void setParteContraria(Pessoa parteContraria) {
        this.parteContraria = parteContraria;
    }
 
    public String getDescricaoMotivo() {
        return descricaoMotivo;
    }
 
    public void setDescricaoMotivo(String descricaoMotivo) {
        if (descricaoMotivo == null || descricaoMotivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida! Esse campo precisa ser preenchido.");
        }
        this.descricaoMotivo = descricaoMotivo;
    }
    
    public Secretaria getSecretaria() {
        return secretaria;
    }
 
    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
 
    public Advogado getAdvogado() {
        return advogado;
    }
 
    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }
 
    public ArrayList<Audiencia> getAudiencias() {
        return audiencias;
    }
 
    public void addAudiencias(ArrayList<Audiencia> audiencias) {
        this.audiencias.addAll(audiencias);
    }
 
    public ArrayList<Custo> getCustos() {
        return custos;
    }
 
    public void addCustos(ArrayList<Custo> custos) {
        this.custos.addAll(custos);
        atualizarValorTotalCustos();
    }
 
    public double getValorTotalCusto() {
        return valorTotalCusto;
    }
 
    // Adicionei este método para atualizar o valor total dos custos
    public void atualizarValorTotalCustos() {
     double valorTotalCustos = 0.0;
     for (Custo custo : custos) {
         valorTotalCustos += custo.getValorCusto();
        }
        this.valorTotalCusto = valorTotalCustos; // Atualiza o valor total dos custos no atributo da classe
    }

    public String toString() {
        String result = "Situação Processo: " + this.getSituacao() + "\nDescrição do processo: " + this.getDescricaoMotivo() + "\nCodigo do processo: " + this.getCodigoProcesso() + "\nNome Cliente: " + this.getCliente().getNome() + "\nNome Parte Contraria: " + this.getParteContraria().getNome() + "\nLogin Advogado: " + this.getAdvogado().getLogin()  + "\nLogin Secretaria: " + this.getSecretaria().getLogin() + "\n\nAudiências:\n";
 
        for (Audiencia audiencia : this.getAudiencias()) {
            result += "Data Audiência: " + audiencia.getDataAudiencia() + "\nRecomendação Audiência: " + audiencia.getRecomendacaoTribunal() + "\n\n";
        }
 
        result += "Custos:\n";
 
        for (Custo custo : this.getCustos()) {
            result += "Data Custo: " + custo.getDataCusto() + "\nDescrição Custo: " + custo.getDescricaoCusto() + "\nValor Custo: " + custo.getValorCusto()  + "\n\n";
        }
 
        result += "Valor Total dos Custos: " + this.getValorTotalCusto();
 
        return result;
    }

    
}
 