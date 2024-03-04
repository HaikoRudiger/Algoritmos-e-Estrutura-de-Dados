// @author Beatriz Moresco Joaquim e Haiko Rudiger
public class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        setLogin(login);
        setSenha(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws IllegalArgumentException {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login inválido! Esse campo precisa ser preenchido.");
        }
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws IllegalArgumentException {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha inválida! Esse campo precisa ser preenchido.");
        }
        this.senha = senha;
    }

    public boolean autenticarSenha(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }
    
}