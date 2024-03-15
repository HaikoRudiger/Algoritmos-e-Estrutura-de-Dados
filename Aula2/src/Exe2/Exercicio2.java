package Exe2;

import java.util.Scanner;
import java.util.Vector;

public class Exercicio2 {
    Scanner input = new Scanner(System.in);
    Vector<Cadastro> cadastro = new Vector<>();

    public Exercicio2() {
        System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Pesquisar\n5 - Remover\n6 - Finalizar ");

        int opcao = input.nextInt();
        input.nextLine();

        while (opcao != 6) {

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                    pesquisar();
                    break;
                case 5:
                    remover();
                    break;

                default:
                    break;

            }

            System.out.println(
                    "Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Pesquisar\n5 - Remover\n6 - Finalizar ");
            opcao = input.nextInt();
            input.nextLine();
        }

        System.out.println("Programa finalizado!");

        input.close();

    }

    public void cadastrar() {
        System.out.println("Digite o nome para cadastrar: ");
        String nome = input.nextLine();

        boolean encontrado = false;

        for (Cadastro dados : cadastro) {
            if (dados.getNomeCadastro().equals(nome)) {
                System.out.println("O nome já existe!");
                encontrado = true;
                break;
            }

        }

        if (encontrado == false) {
            cadastro.add(new Cadastro(nome));
        }

    }

    public void listar() {
        for (Cadastro dados : cadastro) {
            System.out.println(dados.toString());
        }
    }

    public void pesquisar() {
        System.out.println("Digite um termo para pesquisar todos que tenaham esse termo: ");
        String letraPesquisa = input.nextLine().toLowerCase();

        for (Cadastro dados : cadastro) {
            if (dados.getNomeCadastro().toLowerCase().contains(letraPesquisa)) {
                System.out.println(dados.toString());
            }
        }
    }

    public void alterar() {
        System.out.println("Digite o nome para fazer a alteração: ");
        String nomeAlterar = input.nextLine();

        boolean encontrado = false;

        for (Cadastro dados : cadastro) {
            if (dados.getNomeCadastro().equals(nomeAlterar)) {
                System.out.println("Digite o novo nome para alterar: ");
                String novoNome = input.nextLine();
                dados.setNomeCadastro(novoNome);

                encontrado = true;
                System.out.println("Alterado com sucesso!");
                break;
            }
        }

        if (encontrado == false) {
            System.out.println("Alterado com sucesso");
        }
    }

    public void remover() {
        System.out.println("Digite o nome para remover: ");
        String nomeRemover = input.nextLine().trim(); 
    
        boolean encontrado = false;
    
        for (Cadastro dados : cadastro) {
            if (dados.getNomeCadastro().trim().equals(nomeRemover)) { 
                cadastro.remove(dados);
                encontrado = true;
                System.out.println("Removido com sucesso!");
                break;
            }
        }
    
        if (!encontrado) {
            System.out.println("Nome não encontrado. Nenhuma remoção realizada.");
        }
    }

    public static void main(String[] args) {
        new Exercicio2();
    }
}
