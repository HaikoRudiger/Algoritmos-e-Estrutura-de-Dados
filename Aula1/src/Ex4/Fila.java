// @author Haiko Rudiger

package Ex4;

public class Fila {
    
    private String nomeFila;
    
    public Fila(String nomeFila){
        this.nomeFila = nomeFila;
    }

    public String getNomeFila() {
        return nomeFila;
    }

    public void setNomeFila(String nomeFila) {
        this.nomeFila = nomeFila;
    }

    @Override
    public String toString() {
        return "Nome da pessoa: " + nomeFila;
    }

    

}
