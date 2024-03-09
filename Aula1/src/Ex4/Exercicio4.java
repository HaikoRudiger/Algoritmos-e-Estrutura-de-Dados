// @author Haiko Rudiger


/*
Escolhi usar a estrutura de dados Fila neste sistema de atendimento devido à sua característica de operação FIFO (First-In-First-Out). 
Isso significa que o primeiro elemento que entra na fila é o primeiro a ser removido. Isso é ideal para um sistema de atendimento 
onde o atendimento deve ser feito na ordem de chegada.
*/

package Ex4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Exercicio4 {

    
    Scanner input = new Scanner(System.in);
    Queue<Fila> nomeFila = new LinkedList<>();

    public Exercicio4(){

        System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Finalizar ");

        int opcao = input.nextInt();
        input.nextLine();

        while (opcao != 2) {

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
               
                default:
                    break;

            }

            System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Finalizar ");
            opcao = input.nextInt();
            input.nextLine();
        }

        System.out.println("Programa finalizado!");

        input.close();

    }

    public void cadastrar(){
        System.out.println("Digite o nome da pessoa que irá entrar na fila:");
        String nomePessoaFila = input.nextLine();

        nomeFila.add(new Fila(nomePessoaFila));

        if (nomeFila.size() == 4){
            nomeFila.poll();
        }

        for (Fila dado : nomeFila){
            System.out.println(dado);
        }

    }

    public static void main(String[] args){
        new Exercicio4();
    }

}
