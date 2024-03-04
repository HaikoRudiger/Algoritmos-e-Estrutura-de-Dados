// @author Beatriz Moresco Joaquim e Haiko Rudiger
public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        setCnpj(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) throws IllegalArgumentException { 
        if (cnpj == null || cnpj.trim().isEmpty() || cnpj.length() != 18 || !cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
            throw new IllegalArgumentException("CNPJ digitado em um formato inválido! O formato correto é: 00.000.000/0001-00");
        }
        this.cnpj = cnpj;
    }

}