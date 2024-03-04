// @author Beatriz Moresco Joaquim e Haiko Rudiger
public class Advogado extends Usuario {
    private String registroOAB;

    public Advogado(String login, String senha, String registroOAB) {
        super(login, senha);
        setRegistroOAB(registroOAB);
    }

    public String getRegistroOAB() {
        return registroOAB;
    }

    public void setRegistroOAB(String registroOAB) throws IllegalArgumentException {
        if (registroOAB == null || registroOAB.trim().isEmpty() || !registroOAB.matches("[A-Za-z]{2}\\s*\\d{6}")) {
            throw new IllegalArgumentException("Registro OAB digitado em um formato inválido! O formato correto é: UF 000000");
        }
        this.registroOAB = registroOAB;
    }

    @Override
    public String toString(){
        return "Login Advogado: " + this.getLogin() + "\nRegistro OAB: " + this.getRegistroOAB();
    }

}