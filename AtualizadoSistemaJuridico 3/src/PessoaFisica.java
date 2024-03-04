// @author Beatriz Moresco Joaquim e Haiko Rudiger
public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String nome, String cpf) {
        super(nome);
        setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IllegalArgumentException {
        // Formato de CPF: 000.000.000-00
        if (cpf == null || cpf.trim().isEmpty() || cpf.length() != 14 || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF digitado em um formato inválido! O formato correto é: 000.000.000-00");
        }
    
        this.cpf = cpf;
    }

}