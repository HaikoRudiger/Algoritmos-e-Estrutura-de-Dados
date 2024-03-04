// @author Beatriz Moresco Joaquim e Haiko Rudiger
import java.util.HashMap;

public class Vara {
    private String nomeVara;
    private HashMap<Integer, Processo> processos;

    public Vara(String nomeVara, HashMap<Integer, Processo> processos) {
        setNomeVara(nomeVara);
         this.processos = processos;
    }

    public String getNomeVara() {
        return nomeVara;
    }

    public void setNomeVara(String nomeVara) throws IllegalArgumentException {
        if (nomeVara == null || nomeVara.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido! Esse campo precisa ser preenchido.");
        }
        this.nomeVara = nomeVara;
    }

    public HashMap<Integer, Processo> getProcessos() {
        return processos;
    }

    public void vincularProcesso(Processo processo) {
        processos.put(processo.getCodigoProcesso(), processo);
    }
}
