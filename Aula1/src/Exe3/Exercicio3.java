// @author Haiko Rudiger
package Exe3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Exercicio3 {

    Scanner input = new Scanner(System.in);
    List<Informacao> produtoNomeValor = new ArrayList<>();

    public Exercicio3() {
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

            System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Pesquisar\n5 - Remover\n6 - Finalizar ");
            opcao = input.nextInt();
            input.nextLine();
        }

        System.out.println("Programa finalizado!");

        input.close();

    }

    public void cadastrar(){
        
        System.out.println("Digite o nome do produto para cadastrar: ");
        String nome = input.nextLine();

        System.out.println("Digite o valor do produto para cadastrar: ");
        double valor = input.nextDouble();
        
        produtoNomeValor.add(new Informacao(nome, valor));

        System.out.println("Produto cadastrado!");
        

    }

    public void listar() {
        if (produtoNomeValor.isEmpty()) {
            System.out.println("Está vazio");
        } else {
            for (Informacao dados : produtoNomeValor) {
                System.out.println(dados);
            }
        }
    }
    

    public void alterar(){
        System.out.println("Digite o nome completo para fazer a alteracao do nome e do valor:");
        String nomeAlterar = input.nextLine();

        boolean encontrado = false;

        for (Informacao dados : produtoNomeValor){
            if(dados.getNomeProduto().equals(nomeAlterar)){
                System.out.println("Digite o novo nome para o produto: ");
                String novoNome = input.nextLine();
                dados.setNomeProduto(novoNome);

                System.out.println("Digite o novo valor para o produto: ");
                double novoValor = input.nextDouble();
                dados.setValorProduto(novoValor);

                encontrado = true;
                System.out.println("Alterado com sucesso!");
                break;
            }
        }

        if (encontrado == false){
            System.out.println("Produto não encontrado");
        }
    }

    

    public void pesquisar(){
        System.out.println("Digite parte do nome a ser pesquisada (por exemplo, 'Bolsa'):");
        String nomePesquisa = input.nextLine();


        for (Informacao dados : produtoNomeValor){
            if(dados.getNomeProduto().toLowerCase().contains(nomePesquisa.toLowerCase())){
                System.out.println("Nome do produto: " + dados.getNomeProduto() + " Valor do produto R$ " + dados.getValorProduto());
            }
        }

        
    }

    public void remover(){
        System.out.println("Digite o nome completo para fazer a remoção do nome e do valor: '):");
        String nomeRemover = input.nextLine();

        boolean remover = false;

        for (Informacao dados : produtoNomeValor){
            if(dados.getNomeProduto().equals(nomeRemover)){
                produtoNomeValor.remove(dados);
                remover = true;
                System.out.println("Produto removido!");
                break;
            }
        }

        if (remover == false){
            System.out.println("Produto não encontrado!");

        }
    }

    public static void main(String[] args) {
        new Exercicio3();
    }
}
