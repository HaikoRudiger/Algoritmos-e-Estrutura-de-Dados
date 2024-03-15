package Exe2;

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
        return "Nome da pessoa: " + nomeCadastro;
    }
}
