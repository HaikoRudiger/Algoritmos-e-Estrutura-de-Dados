// @author Haiko Rudiger
package Exe2;
import java.util.Scanner;

public class Exercicio2 {

    Scanner input = new Scanner(System.in);
    String[] nomes = new String[10];
    int tamanho = 0;

    public Exercicio2() {

        System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Remover\n5 - Finalizar ");
        int opcao = input.nextInt();
        input.nextLine(); 

        while (opcao != 5) {

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
                    finalizar();
                    break;

                default:
                    break;
            }

            System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Remover\n5 - Finalizar ");
            opcao = input.nextInt();
            input.nextLine(); 
        }

        input.close();
    }

    public void cadastrar() {

        if (tamanho < 10) {
            System.out.println("Digite o nome para cadastrar: ");
            String cadastrarNome = input.nextLine();
            nomes[tamanho] = cadastrarNome;
            tamanho++;
            System.out.println("Cadastrado com sucesso!");

        } else {
            System.out.println("O armazenamento está cheio!!!!");
        }

    }

    public void listar() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(nomes[i]);
        }
    }

    public void alterar() {
        System.out.println("Digite o nome que queira alterar:");
        String nomeAlterar = input.nextLine();
        for (int i = 0; i < tamanho; i++) {
            if (nomes[i].equals(nomeAlterar)) {
                System.out.println("Digite o novo nome:");
                String nomeNome = input.nextLine();
                nomes[i] = nomeNome;
                System.out.println("Nome alterado com sucesso");
                return;
            }
        }

        System.out.println("Nada encontrado!");
    }

    public void remover(){
        System.out.println("Qual nome quer remover?");
        String nomeRemover = input.nextLine();

        for (int i = 0; i < tamanho; i++){
            if (nomes[i].equals(nomeRemover)){
                for (int j = i; j < tamanho - 1; j++){
                    nomes[j] = nomes[j + 1];
                }

                nomes[tamanho - 1] = null;
                tamanho--;
                System.out.println("Nome removido com sucesso!");
                return;
            }
        }
        
        System.out.println("Nome não encontrado");

    }

    public void finalizar(){
        System.out.println("Programa finalizado!");
    }

    public static void main(String[] args) {
        new Exercicio2();
    }
}
