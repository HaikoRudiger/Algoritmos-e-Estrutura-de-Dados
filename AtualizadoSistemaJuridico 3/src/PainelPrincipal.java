// @author Beatriz Moresco Joaquim e Haiko Rudiger
import javax.swing.*; // biblioteca Swing
 
import java.awt.GridLayout; // Grade
import java.awt.event.ActionEvent; // evento clique
import java.awt.event.ActionListener; // responde esse evento
import java.text.ParseException; // para data
import java.util.ArrayList;
import java.util.HashMap;
 
public class PainelPrincipal extends JFrame {
    private JTextField textFieldLogin; // retangulo de insercao texto
    private JPasswordField passwordFieldSenha; // retangulo de insercao texto
    private ArrayList<Usuario> usuarios;
    private HashMap<Integer, Processo> processos;
    private HashMap<String, Advogado> advogados;
    private HashMap<String, Secretaria> secretarias;
    private ArrayList<Vara> varas;
    private ArrayList<Tribunal> tribunais;
    private JPanel panelPrincipal; // painel, retangulo prinicpal
 
    public PainelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0, 1)); // definindo o tamanho do painel, 1 coluna e 0 linhas, 0 pois o
                                                        // número de linhas é dinâmicoas (se adaptam a medida que sao
                                                        // inseridas).
        usuarios = new ArrayList<>();
        processos = new HashMap<>();
        advogados = new HashMap<>();
        secretarias = new HashMap<>();
        varas = new ArrayList<>();
        tribunais = new ArrayList<>();
 
        // Adicionando componentes ao painel principal
        textFieldLogin = new JTextField(20);
        passwordFieldSenha = new JPasswordField(20);
        panelPrincipal.add(new JLabel("Login:")); // texto
        panelPrincipal.add(textFieldLogin);
        panelPrincipal.add(new JLabel("Senha:")); // texto
        panelPrincipal.add(passwordFieldSenha); // retangulo de insercao de texto especifico para senha
        add(panelPrincipal);
 
        // Configuração da janela principal
        setTitle("Tela Principal"); // barra de titulo sendo definida
        setSize(300, 200); // tamanho da janela para 300 pixels de largura por 200 pixels de altura.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ação da janela quando o usuário clicar no botão de fechar (fecha a janela).
        setLocationRelativeTo(null); // centraliza a janela
 
        // Botão de login/entrar sistema (atribui uma ação a ele e adiciona esse botão ao painel principal)
        JButton buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLoginSenha(); // chamando o método (validarLoginSenha) para validar o login e a senha
            }
        });
        panelPrincipal.add(buttonLogin);
 
        // Adicionando o botão de cadastrar (atribui uma ação a ele e adiciona esse botão ao painel principal)
        JButton buttonCadastrar = new JButton("Cadastrar-se");
        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro(); // chamando o método (abrirTelaCadastro) para abrir a tela de cadastro
            }
        });
        panelPrincipal.add(buttonCadastrar);
    }
 
    // Método abrirTelaCadastro
    private void abrirTelaCadastro() {
        JFrame frameCadastro = new JFrame("Cadastro"); // barra de titulo sendo definida na janela criada (Frame = janela)
        frameCadastro.setSize(400, 300); // tamanho inicial da janela de cadastro como 400 pixels de largura por 300 pixels de altura.
        frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ação da janela quando o usuário clicar no botão de fechar (fecha a janela).
        frameCadastro.setLocationRelativeTo(null); // centraliza a janela
 
        JPanel panelCadastro = new JPanel(); // criacao de novo painel e adicao dele dentro da janela criada anteriormente
        frameCadastro.add(panelCadastro);
 
        // Botão de voltar para a tela principal ou fechar a janela de cadastro
        JButton buttonVoltar = new JButton("Voltar"); // criacao e nome do botao
        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCadastro.dispose(); // Fecha a janela de cadastro (Frame = janela)
            }
        });
        panelCadastro.add(buttonVoltar); // adiciona o botao
 
        // Lógica para cadastro de advogados (simulada com JOptionPane)
        JButton buttonCadastrarAdvogado = new JButton("Cadastrar Advogado"); // criacao do botao e nome dele
        buttonCadastrarAdvogado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField registroOABField = new JTextField(10); // definicao do tamanho do retangulo de insercao de texto para registro OAB
                JTextField loginAdvogadoField = new JTextField(10); // definicao do tamanho do retangulo de insercao de texto para login do advogado
                JPasswordField senhaAdvogadoField = new JPasswordField(10); // definicao do tamanho do retangulo de insercao de texto para senha do advogado
 
                registroOABField.setToolTipText("Formato: UF 000000"); // colocando o toolTip (textinho de infromacao quando coloca o cursor em cima do retangulo de insercao de texto para registro OAB
 
                Object[] message = { // array
                        "Registro OAB do Advogado: ", registroOABField, // definindo o titulo dos retangulos de insercao de texto
                        "Login do Novo Advogado:", loginAdvogadoField,
                        "Senha do Novo Advogado:", senhaAdvogadoField
                };
 
                int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de Advogado", // null = centro da tela
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, // botao de ok e cancelar, e icone de mensagem
                        new ImageIcon("c:\\Users\\haiko\\Downloads\\MicrosoftTeams-image.png")); // adicao de imagem
 
                if (option == JOptionPane.OK_OPTION) { // verifica se foi acionado o botao ok
                    String registroOAB = registroOABField.getText(); // obtem o texto e armazena em uma variavel
                    String loginAdvogado = loginAdvogadoField.getText();
                    String senhaAdvogado = new String(senhaAdvogadoField.getPassword()); // obtem o texto e armazena em uma variavel e converte em string (estava em *****)
 
                    try { // criando e inicializando o objeto advogado
                        Advogado advogado = new Advogado(loginAdvogado, senhaAdvogado, registroOAB);
                        advogados.put(loginAdvogado, advogado);
                        usuarios.add(advogado); // adionando esse novo objeto em usuario
 
                        JOptionPane.showMessageDialog(null, "Advogado cadastrado com sucesso!"); // mensagem de sucesso, null = centralizar
                    } catch (IllegalArgumentException ex) { // caso ocorra erro
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro no cadastro", // titulo na barra superior
                                JOptionPane.ERROR_MESSAGE); // icone de erro (X)
                    }
                }
            }
        });
 
        panelCadastro.add(buttonCadastrarAdvogado); // adicionando o botao ao painel
 
        // Lógica para cadastro de secretárias (simulada com JOptionPane) MESMO ESQUEMA DO ANTERIOR
        JButton buttonCadastrarSecretaria = new JButton("Cadastrar Secretaria");
        buttonCadastrarSecretaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField numCarteiraTrabalhoField = new JTextField(10);
                JTextField loginSecretariaField = new JTextField(10);
                JPasswordField senhaSecretariaField = new JPasswordField(10);
 
                numCarteiraTrabalhoField.setToolTipText("Formato: 0000000/0000");
 
                Object[] message = {
                        "Número da Carteira de Trabalho da secretária: ", numCarteiraTrabalhoField,
                        "Login da Nova Secretária:", loginSecretariaField,
                        "Senha da Nova Secretária:", senhaSecretariaField
                };
 
                int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de Secretária",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon("c:\\Users\\haiko\\Downloads\\MicrosoftTeams-image (1).png"));
 
                if (option == JOptionPane.OK_OPTION) {
                    String numCarteiraTrabalho = numCarteiraTrabalhoField.getText();
                    String loginSecretaria = loginSecretariaField.getText();
                    String senhaSecretaria = new String(senhaSecretariaField.getPassword());
 
                    try {
                        Secretaria secretaria = new Secretaria(loginSecretaria, senhaSecretaria, numCarteiraTrabalho);
                        secretarias.put(loginSecretaria, secretaria);
                        usuarios.add(secretaria);
 
                        JOptionPane.showMessageDialog(null, "Secretária cadastrada com sucesso!");
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro no cadastro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panelCadastro.add(buttonCadastrarSecretaria);
 
        frameCadastro.setVisible(true); // visibilidade da janela como verdadeira
    }

    private void exibirTelaPrincipal() {
        JFrame telaPrincipal = new JFrame("Tela Principal");
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0, 1));

        // Botão para cadastrar processo
        JButton buttonCadastrarProcesso = new JButton("Cadastrar Processo");
        buttonCadastrarProcesso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroProcesso();
            }
        });

        // Botão para consultar processos
        JButton buttonConsultarProcesso = new JButton("Consultar Processos");
        buttonConsultarProcesso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaConsultarProcesso();
            }
        });

        // Botão para advogadoSecretaria do aplicativo
        JButton buttonCadastrarAdvogadoSecretaria = new JButton("Advogado/Secretaria");
        buttonCadastrarAdvogadoSecretaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
        
        // Botão para sair do aplicativo
        JButton buttonSair = new JButton("Sair");
        buttonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
 
        // Adicionando os botões ao painel principal
        panelPrincipal.add(buttonCadastrarProcesso);
        panelPrincipal.add(buttonConsultarProcesso);
        panelPrincipal.add(buttonCadastrarAdvogadoSecretaria);
        panelPrincipal.add(buttonSair);


        // Adicionando o painel à janela principal
        telaPrincipal.add(panelPrincipal);

        telaPrincipal.setSize(600, 400);
        telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaPrincipal.setLocationRelativeTo(null);
        telaPrincipal.setVisible(true);
    }

    private void validarLoginSenha() {
        String login = textFieldLogin.getText();
        String senha = new String(passwordFieldSenha.getPassword());

        for (Usuario usuario : usuarios) {
            try {
                if (usuario.getLogin().equals(login) && usuario.autenticarSenha(senha)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    exibirTelaPrincipal(); // Exibe a tela principal após o login bem-sucedido
                    dispose();
                    return; // Se o login for bem-sucedido, não há necessidade de continuar verificando
                            // outros usuários
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro. Tente novamente.");
                e.printStackTrace(); // Isso imprime a pilha de chamadas, é útil para depuração, mas pode ser
                                     // removido em um ambiente de produção
                return; // Encerre o método após lidar com a exceção
            }
        }

        // Se o loop terminar sem encontrar um usuário válido, exiba uma mensagem de
        // erro
        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos. Tente novamente.");
    }

    private void abrirTelaCadastroProcesso() {
        JFrame telaCadastroProcesso = new JFrame("Cadastro de Processo");
        JButton buttonOK = new JButton("OK");
        JButton buttonVoltar = new JButton("Voltar");

        // Criação dos campos para cadastro do cliente
        JTextField textFieldNomeCliente = new JTextField(20);
        JComboBox<String> comboBoxTipoCliente = new JComboBox<>(new String[] { "Pessoa Física", "Pessoa Jurídica" });
        JTextField textFieldCPFCNPJCliente = new JTextField(20);

        // Criação dos campos para cadastro da parte contrária
        JTextField textFieldNomeParteContraria = new JTextField(20);
        JComboBox<String> comboBoxTipoParteContraria = new JComboBox<>(
                new String[] { "Pessoa Física", "Pessoa Jurídica" });
        JTextField textFieldCPFCNPJParteContraria = new JTextField(20);

        // Criação dos campos para vinculação do advogado
        JTextField textFieldLoginAdvogado = new JTextField(20);

        // Criação dos campos para vinculação da secretária
        JTextField textFieldLoginSecretaria = new JTextField(20);

        JTextField textFieldNomeVara = new JTextField(20);
        JTextField textFieldNomeTribunal = new JTextField(20);

        // Criação dos campos para a situação do processo (Aberto ou Fechado)
        ButtonGroup situacaoGroup = new ButtonGroup();
        JRadioButton radioButtonAberto = new JRadioButton("Aberto");
        JRadioButton radioButtonFechado = new JRadioButton("Fechado");
        situacaoGroup.add(radioButtonAberto);
        situacaoGroup.add(radioButtonFechado);

        // Campo para a descrição do processo
        JTextArea textAreaDescricaoProcesso = new JTextArea(5, 20);

        // Campo para o código do processo
        JTextField textFieldCodigoProcesso = new JTextField(10);

        // Lógica para criar a tela de cadastro de processo (campos, botões, etc.)
        JPanel panelCadastroProcesso = new JPanel(new GridLayout(0, 2));
        panelCadastroProcesso.add(new JLabel("Código do Processo:"));
        panelCadastroProcesso.add(textFieldCodigoProcesso);
        panelCadastroProcesso.add(new JLabel("Nome do Cliente:"));
        panelCadastroProcesso.add(textFieldNomeCliente);
        panelCadastroProcesso.add(new JLabel("Tipo de Cliente:"));
        panelCadastroProcesso.add(comboBoxTipoCliente);
        panelCadastroProcesso.add(new JLabel("CPF/CNPJ do Cliente:"));
        panelCadastroProcesso.add(textFieldCPFCNPJCliente);
        textFieldCPFCNPJCliente.setToolTipText("Formato CPF: 000.000.000-00, Formato CNPJ: 00.000.000/0001-00");

        panelCadastroProcesso.add(new JLabel("Nome da Parte Contrária:"));
        panelCadastroProcesso.add(textFieldNomeParteContraria);
        panelCadastroProcesso.add(new JLabel("Tipo de Parte Contrária:"));
        panelCadastroProcesso.add(comboBoxTipoParteContraria);
        panelCadastroProcesso.add(new JLabel("CPF/CNPJ da Parte Contrária:"));
        panelCadastroProcesso.add(textFieldCPFCNPJParteContraria);
        textFieldCPFCNPJParteContraria.setToolTipText("Formato CPF: 000.000.000-00, Formato CNPJ: 00.000.000/0001-00");

        panelCadastroProcesso.add(new JLabel("Login do Advogado:"));
        panelCadastroProcesso.add(textFieldLoginAdvogado);

        panelCadastroProcesso.add(new JLabel("Login da Secretária:"));
        panelCadastroProcesso.add(textFieldLoginSecretaria);

        panelCadastroProcesso.add(new JLabel("Situação do Processo:"));
        panelCadastroProcesso.add(radioButtonAberto);
        panelCadastroProcesso.add(new JLabel(""));
        panelCadastroProcesso.add(radioButtonFechado);

        panelCadastroProcesso.add(new JLabel("Descrição do Processo:"));
        panelCadastroProcesso.add(new JScrollPane(textAreaDescricaoProcesso));

        panelCadastroProcesso.add(new JLabel("Nome da Vara:"));
        panelCadastroProcesso.add(textFieldNomeVara);

        panelCadastroProcesso.add(new JLabel("Nome do Tribunal:"));
        panelCadastroProcesso.add(textFieldNomeTribunal);

        panelCadastroProcesso.add(buttonVoltar);

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastroProcesso.dispose(); // Fechar a tela de cadastro ao clicar em voltar
            }
        });

        panelCadastroProcesso.add(buttonOK);

        // Adicionando listener ao botão OK
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Recuperando os valores dos campos
                int codigoProcesso = Integer.parseInt(textFieldCodigoProcesso.getText());
                String nomeCliente = textFieldNomeCliente.getText();
                String tipoCliente = (String) comboBoxTipoCliente.getSelectedItem();
                String cpfcnpjCliente = textFieldCPFCNPJCliente.getText();

                String nomeParteContraria = textFieldNomeParteContraria.getText();
                String tipoParteContraria = (String) comboBoxTipoParteContraria.getSelectedItem();
                String cpfcnpjParteContraria = textFieldCPFCNPJParteContraria.getText();

                String loginAdvogado = textFieldLoginAdvogado.getText();
                String loginSecretaria = textFieldLoginSecretaria.getText();

                String nomeVara = textFieldNomeVara.getText();
                String nomeTribunal = textFieldNomeTribunal.getText();

                char situacaoProcesso;
                if (radioButtonAberto.isSelected()) {
                    situacaoProcesso = 'A';
                } else {
                    situacaoProcesso = 'F';
                }
                String descricaoProcesso = textAreaDescricaoProcesso.getText();

                // Criação do cliente
                try {
                    Pessoa cliente;
                    if (tipoCliente.equals("Pessoa Física")) {
                        cliente = new PessoaFisica(nomeCliente, cpfcnpjCliente);
                    } else {
                        cliente = new PessoaJuridica(nomeCliente, cpfcnpjCliente);
                    }

                    // Criação da parte contrária
                    Pessoa parteContraria;
                    if (tipoParteContraria.equals("Pessoa Física")) {
                        parteContraria = new PessoaFisica(nomeParteContraria, cpfcnpjParteContraria);
                    } else {
                        parteContraria = new PessoaJuridica(nomeParteContraria, cpfcnpjParteContraria);
                    }

                    // Vinculação do advogado
                    Advogado advogado = advogados.get(loginAdvogado);

                    // Vinculação da secretária
                    Secretaria secretaria = secretarias.get(loginSecretaria);

                    // Criação do objeto processo
                    Processo processo = new Processo(situacaoProcesso, codigoProcesso, cliente, parteContraria,
                            descricaoProcesso, secretaria, advogado, new ArrayList<>(), new ArrayList<>());

                    // Adicionar custos ao processo
                    adicionarCustosAoProcesso(processo);
                    adicionarAudienciasAoProcesso(processo);

                    processos.put(codigoProcesso, processo);

                    Vara vara = new Vara(nomeVara, processos);
                    varas.add(vara);

                    // Criando o Tribunal
                    Tribunal tribunal = new Tribunal(nomeTribunal, varas);
                    tribunais.add(tribunal);

                    // Fechar a tela de cadastro após a conclusão
                    telaCadastroProcesso.dispose();

                    // realizamos testes para ver se estava salvando
                    // System.out.println(processo.toString());

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
                }

                // Fechar a tela de cadastro após a conclusão
                telaCadastroProcesso.dispose();
            }
        });

        telaCadastroProcesso.add(panelCadastroProcesso);
        telaCadastroProcesso.setSize(500, 500);
        telaCadastroProcesso.setLocationRelativeTo(null);
        telaCadastroProcesso.setVisible(true);
    }

    private void adicionarCustosAoProcesso(Processo processo) throws NumberFormatException {
        ArrayList<Custo> custosDoProcesso = new ArrayList<>();

        do {
            try {
                // Perguntas ao usuário para cada custo
                String dataCustoInput = JOptionPane.showInputDialog("Digite a data do custo (dd/MM/yyyy):");
                String descricaoCustoInput = JOptionPane.showInputDialog("Digite a descrição do custo:");
                String valorCustoInput = JOptionPane.showInputDialog("Digite o valor do custo:");
                

                // Criar objeto Custo
                Custo custo = new Custo(dataCustoInput, descricaoCustoInput, Double.parseDouble(valorCustoInput));

                // Adicionar custo à lista de custos do processo
                custosDoProcesso.add(custo);

                // Perguntar ao usuário se deseja adicionar mais custos
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais custos?", "Adicionar Custos",
                        JOptionPane.YES_NO_OPTION);
                if (opcao != JOptionPane.YES_OPTION) {
                    break;
                }
            } catch (ParseException | IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro no cadastro de custo",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (true);

        // Adicionar a lista de custos ao processo
        processo.addCustos(custosDoProcesso);

    }

    private void adicionarAudienciasAoProcesso(Processo processo) throws NumberFormatException {
        ArrayList<Audiencia> audienciasProcesso = new ArrayList<>();

        do {
            try {
                // Perguntas ao usuário para cada custo
                String dataAudienciasInput = JOptionPane
                        .showInputDialog("Digite a data da Audiencia (dd/MM/yyyy):");
                String descricaoAudienciaInput = JOptionPane.showInputDialog("Digite a recomendação da audiencia:");

                // Criar objeto Custo
                Audiencia audiencia = new Audiencia(dataAudienciasInput, descricaoAudienciaInput);

                // Adicionar custo à lista de custos do processo
                audienciasProcesso.add(audiencia);

                // Perguntar ao usuário se deseja adicionar mais custos
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais Audiencia?", "Adicionar Custos",
                        JOptionPane.YES_NO_OPTION);
                if (opcao != JOptionPane.YES_OPTION) {
                    break;
                }
            } catch (ParseException | IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro no cadastro de custo",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (true);

        // Adicionar a lista de custos ao processo
        processo.addAudiencias(audienciasProcesso);
    }

    private void abrirTelaConsultarProcesso() {
        JFrame telaConsultaProcesso = new JFrame("Consulta de Processos");
        JButton buttonVoltar = new JButton("Voltar");

        String[] opcoesConsulta = { "Buscar por Protocolo", "Listar Processos Abertos", "Despesas por Processo",
                "Advogado Vinculado" };
        JComboBox<String> comboBoxConsultas = new JComboBox<>(opcoesConsulta);
        JButton buttonExecutar = new JButton("Executar");

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaConsultaProcesso.dispose(); // Fechar a tela atual
            }
        });

        buttonExecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcaoSelecionada = (String) comboBoxConsultas.getSelectedItem();
                executarOperacao(opcaoSelecionada);
            }
        });

        // Lógica para criar a tela de consulta de processo (campos, botões, etc.)
        JPanel panelConsultaProcesso = new JPanel();
        panelConsultaProcesso.add(new JLabel("Escolha o método de consulta:"));
        panelConsultaProcesso.add(comboBoxConsultas);
        panelConsultaProcesso.add(buttonExecutar);
        panelConsultaProcesso.add(buttonVoltar);
        telaConsultaProcesso.add(panelConsultaProcesso);

        telaConsultaProcesso.setSize(400, 300);
        telaConsultaProcesso.setLocationRelativeTo(null);
        telaConsultaProcesso.setVisible(true);
    }

    private void executarOperacao(String operacao) {

        switch (operacao) {
            case "Buscar por Protocolo":
                buscarProcessoPorProtocolo();
                break;
            case "Listar Processos Abertos":
                listarTodosProcessosAberto();
                break;
            case "Despesas por Processo":
                despesasPorProcesso();
                break;
            case "Advogado Vinculado":
                advogadoVinculadoProcesso();
                break;
            default:
                break;
        }
    }

    public void buscarProcessoPorProtocolo() {
        JFrame frame = new JFrame("Buscar Processo por Protocolo");
        JPanel panel = new JPanel();

        JTextField fieldProtocolo = new JTextField(10);
        panel.add(new JLabel("Número do Protocolo:"));
        panel.add(fieldProtocolo);

        JButton buttonBuscar = new JButton("Buscar");
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroProtocolo = Integer.parseInt(fieldProtocolo.getText());
                Processo processo = processos.get(numeroProtocolo);

                if (processo != null) {
                    JOptionPane.showMessageDialog(null, "Processo encontrado:\n" + processo.toString());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Processo não encontrado. Verifique o número do protocolo digitado.");
                }
            }
        });

        panel.add(buttonBuscar);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void listarTodosProcessosAberto() {
        StringBuilder listaProcessosAbertos = new StringBuilder();
        listaProcessosAbertos.append("Lista de Processos Abertos:\n");

        for (Processo processo : processos.values()) {
            if (processo.getSituacao() == 'A') {
                listaProcessosAbertos.append("Código do Processo: ").append(processo.getCodigoProcesso()).append("\n");
                listaProcessosAbertos.append("Cliente: ").append(processo.getCliente().getNome()).append("\n");
                listaProcessosAbertos.append("Parte Contrária: ").append(processo.getParteContraria().getNome())
                        .append("\n");
                listaProcessosAbertos.append("Descrição do Motivo: ").append(processo.getDescricaoMotivo())
                        .append("\n");
                listaProcessosAbertos.append("Advogado Responsável: ").append(processo.getAdvogado().getLogin())
                        .append("\n");
                listaProcessosAbertos.append("Secretaria Responsável: ").append(processo.getSecretaria().getLogin())
                        .append("\n");
                listaProcessosAbertos.append("Valor Total de Custos: R$ ").append(processo.getValorTotalCusto())
                        .append("\n");
                listaProcessosAbertos.append("--------------------------------\n");
            }
        }

        JTextArea textAreaProcessosAbertos = new JTextArea(listaProcessosAbertos.toString());
        textAreaProcessosAbertos.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textAreaProcessosAbertos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JFrame frameListaProcessosAbertos = new JFrame("Lista de Processos Abertos");
        frameListaProcessosAbertos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameListaProcessosAbertos.getContentPane().add(scrollPane);
        frameListaProcessosAbertos.pack();
        frameListaProcessosAbertos.setLocationRelativeTo(null);
        frameListaProcessosAbertos.setVisible(true);
    }

    public void despesasPorProcesso() {
        JFrame frame = new JFrame("Despesas por Processo");
        JPanel panel = new JPanel();

        JTextField fieldProtocolo = new JTextField(10);
        JButton buttonMostrarDespesas = new JButton("Mostrar Despesas");
        JTextArea textAreaDespesas = new JTextArea(20, 40);
        textAreaDespesas.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textAreaDespesas);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(new JLabel("Número do Protocolo:"));
        panel.add(fieldProtocolo);
        panel.add(buttonMostrarDespesas);
        panel.add(scrollPane);

        buttonMostrarDespesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroProtocolo;
                try {
                    numeroProtocolo = Integer.parseInt(fieldProtocolo.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o protocolo.");
                    return;
                }

                Processo processoSelecionado = processos.get(numeroProtocolo);

                if (processoSelecionado != null) {
                    StringBuilder despesasProcesso = new StringBuilder();
                    despesasProcesso.append("Despesas do Processo ").append(numeroProtocolo).append(":\n");

                    for (Custo custo : processoSelecionado.getCustos()) {
                        despesasProcesso.append("Data: ").append(custo.getDataCusto()).append("\n");
                        despesasProcesso.append("Descrição: ").append(custo.getDescricaoCusto()).append("\n");
                        despesasProcesso.append("Valor: ").append(custo.getValorCusto()).append("\n");
                        despesasProcesso.append("--------------------------------\n");
                    }

                    textAreaDespesas.setText(despesasProcesso.toString());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Processo não encontrado. Verifique o número do protocolo digitado.");
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void advogadoVinculadoProcesso() {
        JFrame frame = new JFrame("Processos Vinculados ao Advogado");
        JPanel panel = new JPanel();

        JTextField fieldLoginAdvogado = new JTextField(10);
        JButton buttonMostrarProcessos = new JButton("Mostrar Processos Vinculados");
        JTextArea textAreaProcessosVinculados = new JTextArea(20, 40);
        textAreaProcessosVinculados.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textAreaProcessosVinculados);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        buttonMostrarProcessos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginAdvogado = fieldLoginAdvogado.getText();
                Advogado advogado = advogados.get(loginAdvogado);

                if (advogado != null) {
                    StringBuilder processosVinculados = new StringBuilder();
                    processosVinculados.append("Processos vinculados ao Advogado ").append(loginAdvogado).append(":\n");
                    boolean encontrouProcesso = false;

                    for (Processo processo : processos.values()) {
                        if (processo.getAdvogado().equals(advogado)) {
                            encontrouProcesso = true;
                            processosVinculados.append("Código do Processo: ").append(processo.getCodigoProcesso())
                                    .append("\n");
                            processosVinculados.append("Cliente: ").append(processo.getCliente().getNome())
                                    .append("\n");
                            processosVinculados.append("Parte Contrária: ")
                                    .append(processo.getParteContraria().getNome()).append("\n");
                            processosVinculados.append("Descrição do Motivo: ").append(processo.getDescricaoMotivo())
                                    .append("\n");
                            processosVinculados.append("Advogado Responsável: ")
                                    .append(processo.getAdvogado().getLogin()).append("\n");
                            processosVinculados.append("Secretaria Responsável: ")
                                    .append(processo.getSecretaria().getLogin()).append("\n");
                            processosVinculados.append("Valor Total de Custos: R$ ").append(processo.getValorTotalCusto())
                                    .append("\n");
                            processosVinculados.append("--------------------------------\n");
                        }
                    }

                    if (!encontrouProcesso) {
                        processosVinculados.append("Não há processos vinculados ao Advogado ").append(loginAdvogado)
                                .append(".");
                    }

                    textAreaProcessosVinculados.setText(processosVinculados.toString());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Advogado não encontrado. Verifique o login do advogado digitado.");
                }
            }
        });

        panel.add(new JLabel("Login do Advogado:"));
        panel.add(fieldLoginAdvogado);
        panel.add(buttonMostrarProcessos);
        panel.add(scrollPane);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); //centralizar 
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PainelPrincipal painel = new PainelPrincipal();
                painel.setVisible(true);
            }
        });
    }
}