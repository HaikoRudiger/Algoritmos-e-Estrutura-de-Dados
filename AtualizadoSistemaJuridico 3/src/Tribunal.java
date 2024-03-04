// @author Beatriz Moresco Joaquim e Haiko Rudiger
import java.util.ArrayList;

public class Tribunal {
    private String nomeTribunal;
    private ArrayList<Vara> varas;

    public Tribunal(String nomeTribunal, ArrayList<Vara> varas) {
        setNomeTribunal(nomeTribunal);
        this.varas = varas; 
    }

    public String getNomeTribunal() {
        return nomeTribunal;
    }

    public void setNomeTribunal(String nomeTribunal) throws IllegalArgumentException {
        if (nomeTribunal == null || nomeTribunal.trim().isEmpty()) {
            new IllegalArgumentException("Nome inválido! Esse campo precisa ser preenchido.");
        }
        this.nomeTribunal = nomeTribunal;
    }

    public ArrayList<Vara> getVaras() {
        return varas;
    }

    public void addVara(Vara vara) {
        varas.add(vara);
    }
}