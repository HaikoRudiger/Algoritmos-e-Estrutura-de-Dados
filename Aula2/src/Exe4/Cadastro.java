package Exe4;

public class Cadastro {
    private String nomeCadastro;

    public Cadastro(String nomeCadastro){
        this.nomeCadastro = nomeCadastro;
    }

    public String getNomeCadastro() {
        return nomeCadastro;
    }

    public void setNomeCadastro(String nomeCadastro) {
        this.nomeCadastro = nomeCadastro;
    }

    public String toString(){
        return "Nome do cadastro: " + nomeCadastro;
    }
}
