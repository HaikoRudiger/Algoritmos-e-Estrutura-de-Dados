package Exe3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio3 {

    Scanner input = new Scanner(System.in);
    ArrayList<Segmento> produtoSegmento = new ArrayList<>();

    public Exercicio3() {

        System.out.println(
                "Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Remover\n5 - Exibir Quantidade de Segmentos\n6 - Finalizar ");

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
                remover();
                    break;
                case 5:
                qntSegmentoProduto();
                    break;
                default:
                    break;

            }

            System.out.println(
                    "Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Pesquisar\n5 - Remover\n6 - Exibir Quantidade de Segmentos\n7 - Finalizar ");
            opcao = input.nextInt();
            input.nextLine();
        }

        System.out.println("Programa finalizado!");

        input.close();

    }

    public void cadastrar(){

        System.out.println("Digite o nome do produto: ");
        String produtoNome = input.nextLine();

        System.out.println("Digite o nome do segmento: ");
        String segmentoNome = input.nextLine();

        produtoSegmento.add(new Segmento(produtoNome, segmentoNome));

    }

    public void listar(){
        for (Segmento informacao : produtoSegmento){
            System.out.println(informacao.toString());
        }
    }

    public void qntSegmentoProduto(){
        Map<String, Integer> segmentoQuantidade = new HashMap<>();

        for (Segmento segmento : produtoSegmento) {
            String nomeSegmento = segmento.getNomeSegmento();
            segmentoQuantidade.put(nomeSegmento, segmentoQuantidade.getOrDefault(nomeSegmento, 0) + 1);
        }

        System.out.println("Quantidade de segmentos:");
        for (String nomeSegmento : segmentoQuantidade.keySet()) {
            int quantidade = segmentoQuantidade.get(nomeSegmento);
            System.out.println("Segmento: " + nomeSegmento + " - Quantidade: " + quantidade);
        }
    }

    public void remover(){
        System.out.println("Digite o nome do segmento que deseja remover:");
        String nomeSegmentoRemover = input.nextLine();
    
        boolean removido = false;
        for (int i = 0; i < produtoSegmento.size(); i++) {
            if (produtoSegmento.get(i).getNomeSegmento().equals(nomeSegmentoRemover)) {
                produtoSegmento.remove(i);
                removido = true;
                break;
            }
        }
    
        if (removido) {
            System.out.println("Segmento removido com sucesso.");
        } else {
            System.out.println("Segmento não encontrado.");
        }
    }

    public void alterar(){
        System.out.println("Digite o nome do segmento que deseja alterar:");
        String nomeSegmentoAlterar = input.nextLine();
    
        boolean alterado = false;
        for (Segmento segmento : produtoSegmento) {
            if (segmento.getNomeSegmento().equals(nomeSegmentoAlterar)) {
                System.out.println("Digite o novo nome do segmento:");
                String novoNomeSegmento = input.nextLine();
                segmento.setNomeSegmento(novoNomeSegmento);
                alterado = true;
                break;
            }
        }
    
        if (alterado) {
            System.out.println("Segmento alterado com sucesso.");
        } else {
            System.out.println("Segmento não encontrado.");
        }
    }

    public static void main(String[] args) {
        new Exercicio3();
    }
}