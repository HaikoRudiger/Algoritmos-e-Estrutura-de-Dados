// @author Haiko Rudiger
package Exe3;

public class Informacao {
    private String nomeProduto;
    private double valorProduto;

    public Informacao(String nomeProduto, double valorProduto){
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    @Override
    public String toString(){
        return "Nome do Produto: " + nomeProduto + ", valor: " + valorProduto; 
    }
}
