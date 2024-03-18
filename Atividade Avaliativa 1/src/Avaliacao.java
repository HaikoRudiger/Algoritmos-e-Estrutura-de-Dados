//@author Haiko
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Avaliacao {
    Scanner input = new Scanner(System.in);
    Queue<Tarefa> tarefas = new LinkedList<>();

    public Avaliacao() {
        int opcao;

        do {
            System.out.println("Digite a opção:\n1 - Cadastrar Tarefa\n2 - Listar Proxima Tarefa\n3 - Concluir Tarefa\n4 - Finalizar");

            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarTarefa();
                    break;
                case 2:
                    proximaTarefa();
                    break;
                case 3:
                    concluirTarefa();
                    break;
                case 4:
                    System.out.println("Programa finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 4);
        
        input.close(); 
    }

    public void cadastrarTarefa() {
        System.out.println("Cadastrar Nova Tarefa:");

        System.out.println("Nome da Tarefa:");
        String nome = input.nextLine();

        System.out.println("Descricao da Tarefa:");
        String descricao = input.nextLine();

        System.out.println("Data da Tarefa (dd/MM/yyyy):");
        String dataString = input.nextLine();

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatter.parse(dataString);
            tarefas.add(new Tarefa(nome, descricao, data));
            System.out.println("Tarefa cadastrada com sucesso!");
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
        }
    }

    public void proximaTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas.");
        } else {
            System.out.println("Próxima Tarefa:");
            System.out.println(tarefas.peek()); 
        }
    }

    public void concluirTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas para concluir.");
        } else {
            System.out.println("Tarefa concluída:");
            System.out.println(tarefas.poll()); 
        }
    }

    public static void main(String[] args) {
        new Avaliacao();
    }
}