//@author Haiko

import java.util.Date;
import java.text.SimpleDateFormat;


public class Tarefa {
    private String nomeTarefa;
    private String descricaoTarefa;
    private Date dataTarefa;

    public Tarefa(String nomeTarefa, String descricaoTarefa, Date dataTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.dataTarefa = dataTarefa;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public Date getDataTarefa() {
        return dataTarefa;
    }

    public void setDataTarefa(Date dataTarefa) {
        this.dataTarefa = dataTarefa;
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(dataTarefa);
        return "Titulo: " + nomeTarefa + "\nDescricao da tarefa: " + descricaoTarefa + "\nData: " + formattedDate;
    }
}