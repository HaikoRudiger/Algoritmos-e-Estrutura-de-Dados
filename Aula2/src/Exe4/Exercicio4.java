package Exe4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Exercicio4 {

    Scanner input = new Scanner(System.in);

    List<Cadastro> cadastroNome = new LinkedList<>();

    public Exercicio4() {

        System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Finalizar ");

        int opcao = input.nextInt();
        input.nextLine();

        while (opcao != 3) {

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;

                default:
                    break;

            }

            System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Finalizar ");
            input.nextLine();
        }

        System.out.println("Programa finalizado!");

        input.close();

    }

    public void cadastrar() {
        System.out.println("Digite o nome para cadastrar:");
        String nome = input.nextLine();
        Cadastro novoCadastro = new Cadastro(nome);
        cadastroNome.add(novoCadastro);
        System.out.println("Cadastro realizado com sucesso!");
    }

    public void listar() {
        if (cadastroNome.isEmpty()) {
            System.out.println("Não há cadastros para listar.");
        } else {
            System.out.println("Lista de Cadastros:");
            for (Cadastro cadastro : cadastroNome) {
                System.out.println(cadastro);
            }
        }
    }

    public static void main(String[] args) {
        new Exercicio4();
    }

}
