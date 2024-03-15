package Exe5;

import java.util.HashMap;
import java.util.Scanner;

public class Exercicio5 {
    static int totalCadastrados = 0;
    static int totalExcluidos = 0;
    static int totalAlterados = 0;

    HashMap<String, Animal> mapaAnimais = new HashMap<>();
    Scanner input = new Scanner(System.in);

    public Exercicio5() {

        int opcao;

        do {
            System.out.println("Digite a opção: \n1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Excluir\n5 - Finalizar ");

            opcao = input.nextInt();
            input.nextLine();

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
                    excluir();
                    break;
                case 5:
                    System.out.println("Programa finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 5);

        input.close();
    }

    public void cadastrar() {
        System.out.println("Digite o nome do animal:");
        String nome = input.nextLine();
        Animal animal = new Animal(nome);
        mapaAnimais.put(nome, animal);
        totalCadastrados++;
        System.out.println("Animal cadastrado com sucesso!");
    }

    public void listar() {
        if (mapaAnimais.isEmpty()) {
            System.out.println("Não há animais cadastrados.");
        } else {
            System.out.println("Lista de animais cadastrados:");
            for (Animal animal : mapaAnimais.values()) {
                System.out.println(animal);
            }
        }
    }

    public void alterar() {
        System.out.println("Digite o nome do animal que deseja alterar:");
        String nome = input.nextLine();
        if (mapaAnimais.containsKey(nome)) {
            System.out.println("Digite o novo nome do animal:");
            String novoNome = input.nextLine();
            Animal animal = mapaAnimais.get(nome);
            animal.setNomeAnimal(novoNome);
            mapaAnimais.remove(nome);
            mapaAnimais.put(novoNome, animal);
            totalAlterados++;
            System.out.println("Animal alterado com sucesso!");
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

    public void excluir() {
        System.out.println("Digite o nome do animal que deseja excluir:");
        String nome = input.nextLine();
        if (mapaAnimais.containsKey(nome)) {
            mapaAnimais.remove(nome);
            totalExcluidos++;
            System.out.println("Animal excluído com sucesso!");
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

    public static void main(String[] args) {
        new Exercicio5();
        System.out.println("Total de animais cadastrados: " + totalCadastrados);
        System.out.println("Total de animais excluídos: " + totalExcluidos);
        System.out.println("Total de animais alterados: " + totalAlterados);
    }

}

