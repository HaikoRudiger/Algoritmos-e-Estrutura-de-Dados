// @author Beatriz Moresco Joaquim e Haiko Rudiger
public class Secretaria extends Usuario {
    private String numeroCarteiraTrabalho;

    public Secretaria(String login, String senha, String numeroCarteiraTrabalho) {
        super(login, senha);
        setNumeroCarteiraTrabalho(numeroCarteiraTrabalho);
    }

    public String getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }

    public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) throws IllegalArgumentException { 
        if (numeroCarteiraTrabalho == null || !numeroCarteiraTrabalho.matches("\\d{7}/\\d{4}")) {
            throw new IllegalArgumentException("Número da Carteira de Trabalho digitado em um formato inválido! O formato correto é: 0000000/0000");
        }
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }

    @Override
    public String toString(){
        return "Login da Secretaria: " + this.getLogin() + "\nNúmero da Careteira de Trabalho: " + this.getNumeroCarteiraTrabalho();
    }
}