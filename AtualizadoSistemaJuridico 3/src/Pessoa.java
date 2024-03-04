// @author Beatriz Moresco Joaquim e Haiko Rudiger
public class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            new IllegalArgumentException("Nome inválido! Esse campo precisa ser preenchido.");
        }
        this.nome = nome;
    }    
}