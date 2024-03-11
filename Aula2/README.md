# 📚 Aula 2 - 11/03/2024

## 🗃️ Tipos de Armazenamento em Java

### 🧮 Vector
O `Vector` é semelhante a um `ArrayList`, mas com duas diferenças:
- O `Vector` é sincronizado 🔒
- Contém muitos métodos legados que não fazem parte da coleção de estrutura de dados 🏛️

### 📝 ArrayList
O `ArrayList` fornece acesso aleatório aos elementos. Pode ser descrito como um array dinâmico ou um array redimensionável 📈

### 🔗 LinkedList
O `LinkedList` fornece uma estrutura de dados na forma de uma lista duplamente ligada 🧶

### 🗺️ HashMap
No `HashMap`, usamos chave e valor para salvar ou recuperar dados, onde a chave é usada para identificar o valor 🔑

## 📌 Características

### 🧮 Vector
- O tamanho de um `Vector` pode crescer ou diminuir conforme necessário para acomodar a adição e remoção de itens após a criação do `Vector`.
- Contém componentes que podem ser acessados usando um índice inteiro.
- Mantém uma ordem de inserção como um `ArrayList`.

### 📝 ArrayList
- Os elementos podem ser adicionados e removidos de um `ArrayList` sempre que necessário.
- É um array redimensionável.
- Implementa todas as operações de lista opcionais e permite todos os elementos, incluindo null.

### 🔗 LinkedList
- É uma implementação de lista duplamente vinculada das interfaces `List` e `Deque`.
- Todas as operações de lista opcionais e permite todos os elementos.
- As operações que indexam na lista percorrerão a lista desde o início ou o fim, o que estiver mais próximo do índice especificado.

### 🗺️ HashMap
- Usa uma função de hash para mapear chaves para índices em um array.
- Se você tentar inserir a chave duplicada no `HashMap`, ele substituirá o elemento da chave correspondente.
- Pode ter uma chave null e vários valores null.

## 📖 Exemplos

### 🧮 Vector
`Vector<String> exemploVector = new Vector<>();` É como uma lista dinâmica que pode crescer conforme necessário para acomodar seus elementos.

### 📝 ArrayList
`ArrayList<String> exemploArrayList = new ArrayList<>();` É parecido com um `Vector`, mas não é sincronizado, significa que é mais rápido, mas não seguro para threads.

### 🔗 LinkedList
`LinkedList<String> exemploLinkedList = new LinkedList<>();` É uma lista encadeada que permite inserções e remoções eficientes.

### 🗺️ HashMap
`HashMap<Integer, String> exemploHashMap = new HashMap<>();` É uma estrutura de dados que armazena elementos na forma de pares chave-valor.
