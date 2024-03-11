# 📚 Aula 1 - 04/03/2024

## 📝 O que é estrutura de dados? 
São formas de organizar e armazenar dados para acesso e uso eficientes. Eles podem ser lineares, não lineares, homogêneas e heterogêneas.

## 🎯 Qual sua importância?
- Eficiência de processamento e organização de dados
- Desenvolvimento de software eficiente
- Facilita o manuseio dos dados
- Otimiza a manutenção 

## 🏗️ Estruturas

### Array (Estático e dinâmico)
É uma estrutura de dados que armazena uma coleção de elementos do mesmo tipo. Um array estático tem tamanho fixo. O array dinâmico tem tamanho que pode mudar durante a execução do programa.

#### • Array Estático (ArrayList) - Exemplo de código
```java
int[] arrayEstatico = new int[5]; // Cria um array de inteiros com tamanho 5
arrayEstatico[0] = 1; //Atribui o valor 1 ao primeiro elemento do array
```

#### • Array Dinamico (ArrayList) - Exemplo codigo
```java
ArrayList<Integer> arrayDinamico = new ArrayList<Integer>(); // Cria um ArrayList vazio
arrayDinamico.add(1); // Adicona o número 1 ao ArrayList
```

### Lista (List) 
Representa uma lista ordenada de elementos, os elementos podem ser acessados por seu indice e inserir elementos em qualquer posição na lista.

#### • Exemplo codigo (List)
```java
List<String> lista = new ArrayList<String>(); //Cria uma lista vazia
list.add("Exemplo1"); //Adiciona a string "Exemplo1" a lista 
```

### Fila (Queue)
Suporta operações para adicionar elementos no final da fila e remover do início.

#### • Exemplo codigo (Queue)
```java
Queue<String> fila = new LinkedList<String>(); //Cria uma fila vazia
fila.add("Exemplo"); // Adiciona a string "Exemplo" ao final da fila
String primeiroElemento = fila.poll(); //Remove e retorna o primeiro elemento da fila
```
### Pilha (Stack) 
Suporta operações para adicionar elementos no topo da pilha e remover do topo.

#### • Exemplo codigo (Stack)
```java 
Stack<String> pilha = new Stack<String>(); // Cria uma pilha vazia
pilha.push("Teste"); // Adicona a string "Teste" ao topo da pilha
String elementoTopo = pilha.pop(); // Remove e retorna o elemento do topo da pilha
```
