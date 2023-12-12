package controler;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Candidato;
import model.Empresa;
import model.OfertaEmprego;

public class OfertaEmpregoControler {

    private static Scanner in = new Scanner(System.in);

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();

    public static String CNPJ(){   
        boolean camposPreenchidos = false;
        while (!camposPreenchidos) {
            String cnpjDesejado = JOptionPane.showInputDialog(null,"Qual é o CNPJ da empresa? ", "Informe o CNPJ da empresa", JOptionPane.PLAIN_MESSAGE);
            if (cnpjDesejado == null) {
                break;
            }
            if (cnpjDesejado.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite o CNPJ da empresa antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }else{
                camposPreenchidos = true;
                return cnpjDesejado;
            }
        }
        return null;
    }

    public static boolean verificaCNPJ(String cnpjDesejado){    
        boolean encontrado = false;   
        if (cnpjDesejado != null) {                  
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    encontrado = true;
                    break;                
                }
            }
        }  
        return encontrado; 
    }

    public static void cadastrarOfertaEmprego(){    
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    OfertaEmprego novaOfertaEmprego = lerDadosOfertaEmprego(empresa); 
                    empresa.getOfertasOfertadas().add(novaOfertaEmprego);// Adicionando uma nova oferta de emprego no arrayList de ofertasOfertadas da empresa
                    if(empresa.getAreaAtuacao().equals("Tecnologia")) Dados.getOfertasTecnologia().add(novaOfertaEmprego);
                    if(empresa.getAreaAtuacao().equals("Vendas")) Dados.getOfertasVendas().add(novaOfertaEmprego);
                    if(empresa.getAreaAtuacao().equals("Hospitalar")) Dados.getOfertasHospitalar().add(novaOfertaEmprego);
                    if(empresa.getAreaAtuacao().equals("Educação")) Dados.getOfertasEducacao().add(novaOfertaEmprego);
                    if(empresa.getAreaAtuacao().equals("Alimentos")) Dados.getOfertasAlimentos().add(novaOfertaEmprego);
                    if (!(empresa.getAreaAtuacao().equals("Tecnologia")) && !(empresa.getAreaAtuacao().equals("Vendas"))
                    && !(empresa.getAreaAtuacao().equals("Hospitalar")) && !(empresa.getAreaAtuacao().equals("Educação"))
                    && !(empresa.getAreaAtuacao().equals("Alimentos"))){Dados.getOfertasRestantes().add(novaOfertaEmprego);}
                    JOptionPane.showMessageDialog(null,"Oferta criada com sucesso!");
                    break; // Se encontrou, não precisa continuar procurando
                }
            } 
        }
    }

    public static void editarOfertaEmpregoSalario(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    StringBuilder mensagem = new StringBuilder();
                    for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                        int numeroOferta = i + 1;
                        mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                        .append(empresa.getOfertasOfertadas().get(i).toString()).append("\n");
                    }

                    JTextArea textArea = new JTextArea(10, 40);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                    textArea.setText(mensagem.toString());
                    textArea.setEditable(false);

                    JPanel panel = new JPanel(new BorderLayout());
                    panel.add(scrollPane, BorderLayout.NORTH);

                    JLabel mensagemLabel = new JLabel("Qual oferta da empresa " + empresa.getNome() + " você deseja editar o salário? (Digite o número da oferta)");
                    panel.add(mensagemLabel, BorderLayout.CENTER);

                    JTextField inputField = new JTextField();
                    panel.add(inputField, BorderLayout.SOUTH);

                    boolean camposPreenchidos = false;
                    while (!camposPreenchidos) {
                        int result = JOptionPane.showOptionDialog(
                            null,
                            panel,
                            "Ofertas de emprego ofertadas pela empresa " + empresa.getNome(),
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            null
                        );

                        if (result == JOptionPane.OK_OPTION) {
                            // Lógica para processar o campo de entrada
                            String input = inputField.getText();
                            if (algumCampoEmBranco(inputField)) {
                                JOptionPane.showMessageDialog(null, "Digite o número da oferta antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int numeroOfertaEscolhida = Integer.parseInt(input);
                                // Verifica se o número da oferta escolhida é válido
                                if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                                    // Obtém a oferta escolhida
                                    OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);                          
                                    String novoSalario = JOptionPane.showInputDialog(null,"Antigo salário cadastrado para essa oferta de emprego: "+ ofertaParaEditar.getSalario()+" \nDigite o novo salário:");
                                    double novoSalarioDouble = Double.parseDouble(novoSalario);
                                    ofertaParaEditar.setSalario(novoSalarioDouble);
                                    JOptionPane.showMessageDialog(null,"\nSalário da Oferta editada com sucesso!");
                                    camposPreenchidos = true;
                                } else {
                                    JOptionPane.showMessageDialog(null,"\nNúmero de oferta inválido.");
                                }
                            }        
                        } else {
                            break;
                        }
                    }
                }
                break; 
            }
        }
    }
    
    public static void editarOfertaEmpregoCargo(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    StringBuilder mensagem = new StringBuilder();
                    for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                        int numeroOferta = i + 1;
                        mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                        .append(empresa.getOfertasOfertadas().get(i).toString()).append("\n");
                    }

                    JTextArea textArea = new JTextArea(10, 40);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                    textArea.setText(mensagem.toString());
                    textArea.setEditable(false);

                    JPanel panel = new JPanel(new BorderLayout());
                    panel.add(scrollPane, BorderLayout.NORTH);

                    JLabel mensagemLabel = new JLabel("Qual oferta da empresa " + empresa.getNome() + " você deseja editar o cargo? (Digite o número da oferta)");
                    panel.add(mensagemLabel, BorderLayout.CENTER);

                    JTextField inputField = new JTextField();
                    panel.add(inputField, BorderLayout.SOUTH);

                    boolean camposPreenchidos = false;
                    while (!camposPreenchidos) {
                        int result = JOptionPane.showOptionDialog(
                            null,
                            panel,
                            "Ofertas de emprego ofertadas pela empresa " + empresa.getNome(),
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            null
                        );

                        if (result == JOptionPane.OK_OPTION) {
                            // Lógica para processar o campo de entrada
                            String input = inputField.getText();
                            if (algumCampoEmBranco(inputField)) {
                                JOptionPane.showMessageDialog(null, "Digite o número da oferta antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int numeroOfertaEscolhida = Integer.parseInt(input);
                                // Verifica se o número da oferta escolhida é válido
                                if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                                    // Obtém a oferta escolhida
                                    OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);                          
                                    String novoCargo = JOptionPane.showInputDialog(null,"Antigo cargo cadastrado para oferta de emprego: "+ ofertaParaEditar.getCargo()+" \nDigite o novo cargo:", "Digite o novo cargo", JOptionPane.WARNING_MESSAGE);
                                    ofertaParaEditar.setCargo(novoCargo);
                                    JOptionPane.showMessageDialog(null,"\nCargo da oferta editada com sucesso!");
                                    camposPreenchidos = true;
                                } else {
                                    JOptionPane.showMessageDialog(null,"\nNúmero de oferta inválido.");
                                }
                            }        
                        } else {
                            break;
                        }
                    }
                }
                break; 
            }
        }
    }

    public static void editarOfertaEmpregoQntdVagas(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    StringBuilder mensagem = new StringBuilder();
                    for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                        int numeroOferta = i + 1;
                        mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                        .append(empresa.getOfertasOfertadas().get(i).toString()).append("\n");
                    }

                    JTextArea textArea = new JTextArea(10, 40);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                    textArea.setText(mensagem.toString());
                    textArea.setEditable(false);

                    JPanel panel = new JPanel(new BorderLayout());
                    panel.add(scrollPane, BorderLayout.NORTH);

                    JLabel mensagemLabel = new JLabel("Qual oferta da empresa " + empresa.getNome() + " você deseja editar a quantidade de vagas abertas? (Digite o número da oferta)");
                    panel.add(mensagemLabel, BorderLayout.CENTER);

                    JTextField inputField = new JTextField();
                    panel.add(inputField, BorderLayout.SOUTH);

                    boolean camposPreenchidos = false;
                    while (!camposPreenchidos) {
                        int result = JOptionPane.showOptionDialog(
                            null,
                            panel,
                            "Ofertas de emprego ofertadas pela empresa " + empresa.getNome(),
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            null
                        );

                        if (result == JOptionPane.OK_OPTION) {
                            // Lógica para processar o campo de entrada
                            String input = inputField.getText();
                            if (algumCampoEmBranco(inputField)) {
                                JOptionPane.showMessageDialog(null, "Digite o número da oferta antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int numeroOfertaEscolhida = Integer.parseInt(input);
                                // Verifica se o número da oferta escolhida é válido
                                if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                                    // Obtém a oferta escolhida
                                    OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);                          
                                    String qntdVagas = JOptionPane.showInputDialog(null,"Antiga quantidade de vagas abertas cadastrado para essa oferta de emprego: "+ ofertaParaEditar.getQntVagas()+" \nDigite a nova  quantidade de vagas abertas:");
                                    int novaQntdVagas = Integer.parseInt(qntdVagas);
                                    ofertaParaEditar.setQntVagas(novaQntdVagas);
                                    JOptionPane.showMessageDialog(null,"\nQuantidade de vagas abertas da oferta editada com sucesso!");
                                    camposPreenchidos = true;
                                } else {
                                    JOptionPane.showMessageDialog(null,"\nNúmero de oferta inválido.");
                                }
                            }        
                        } else {
                            break;
                        }
                    }
                }
                break; 
            }
        }
    }

    public static void editarOfertaEmpregoEscolaridade(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    StringBuilder mensagem = new StringBuilder();
                    for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                        int numeroOferta = i + 1;
                        mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                        .append(empresa.getOfertasOfertadas().get(i).toString()).append("\n");
                    }

                    JTextArea textArea = new JTextArea(10, 40);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                    textArea.setText(mensagem.toString());
                    textArea.setEditable(false);

                    JPanel panel = new JPanel(new BorderLayout());
                    panel.add(scrollPane, BorderLayout.NORTH);

                    JLabel mensagemLabel = new JLabel("Qual oferta da empresa " + empresa.getNome() + " você deseja editar o nível de escolaridade? (Digite o número da oferta)");
                    panel.add(mensagemLabel, BorderLayout.CENTER);

                    JTextField inputField = new JTextField();
                    panel.add(inputField, BorderLayout.SOUTH);

                    boolean camposPreenchidos = false;
                    while (!camposPreenchidos) {
                        int result = JOptionPane.showOptionDialog(
                            null,
                            panel,
                            "Ofertas de emprego ofertadas pela empresa " + empresa.getNome(),
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            null
                        );

                        if (result == JOptionPane.OK_OPTION) {
                            // Lógica para processar o campo de entrada
                            String input = inputField.getText();
                            if (algumCampoEmBranco(inputField)) {
                                JOptionPane.showMessageDialog(null, "Digite o número da oferta antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int numeroOfertaEscolhida = Integer.parseInt(input);
                                // Verifica se o número da oferta escolhida é válido
                                if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                                    // Obtém a oferta escolhida
                                    OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);                          
                                    String novoNivelEscolaridade = JOptionPane.showInputDialog(null,"Antigo nível de escolaridade requerido por essa vagas era: "+ ofertaParaEditar.getEscolaridade()+" \nDigite o novo nível de escolaridade:");
                                    ofertaParaEditar.setEscolaridade(novoNivelEscolaridade );
                                    JOptionPane.showMessageDialog(null,"\nNível de escolaridade da oferta editado com sucesso!");
                                    camposPreenchidos = true;
                                } else {
                                    JOptionPane.showMessageDialog(null,"\nNúmero de oferta inválido.");
                                }
                            }        
                        } else {
                            break;
                        }
                    }
                }
                break; 
            }
        }
    }
    
    public static void apagarOfertaEmprego() {
    String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    if (empresa.getOfertasOfertadas().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "A empresa não tem nenhuma oferta de emprego ainda.");
                    } else {
                        StringBuilder mensagem = new StringBuilder();
                        for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                            int numeroOferta = i + 1;
                            mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                                    .append(empresa.getOfertasOfertadas().get(i).toString()).append("\n");
                        }

                        JTextArea textArea = new JTextArea(10, 40);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                        textArea.setText(mensagem.toString());
                        textArea.setEditable(false);

                        JPanel panel = new JPanel(new BorderLayout());
                        panel.add(scrollPane, BorderLayout.NORTH);

                        JLabel mensagemLabel = new JLabel("Qual oferta da empresa " + empresa.getNome() + " você deseja apagar? (Digite o número da oferta)");
                        panel.add(mensagemLabel, BorderLayout.CENTER);

                        JTextField inputField = new JTextField();
                        panel.add(inputField, BorderLayout.SOUTH);

                        boolean camposPreenchidos = false;
                        while (!camposPreenchidos) {
                            int result = JOptionPane.showOptionDialog(
                                    null,
                                    panel,
                                    "Ofertas de emprego ofertadas pela empresa " + empresa.getNome(),
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    null
                            );

                            if (result == JOptionPane.OK_OPTION) {
                                // Lógica para processar o campo de entrada
                                String input = inputField.getText();
                                if (algumCampoEmBranco(inputField)) {
                                    JOptionPane.showMessageDialog(null, "Digite o número da oferta antes de prosseguir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    int numeroOfertaEscolhida = Integer.parseInt(input);
                                    if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                                        // Removendo a oferta de emprego da empresa
                                        OfertaEmprego ofertaRemovida = empresa.getOfertasOfertadas().remove(numeroOfertaEscolhida - 1);                                        
                                        //Removendo as ofertas do ArrayLists que ela está
                                        if(empresa.getAreaAtuacao().equals("Tecnologia")) Dados.getOfertasTecnologia().remove(ofertaRemovida);
                                        if(empresa.getAreaAtuacao().equals("Vendas")) Dados.getOfertasVendas().remove(ofertaRemovida);
                                        if(empresa.getAreaAtuacao().equals("Hospitalar")) Dados.getOfertasHospitalar().remove(ofertaRemovida);
                                        if(empresa.getAreaAtuacao().equals("Educação")) Dados.getOfertasEducacao().remove(ofertaRemovida);
                                        if(empresa.getAreaAtuacao().equals("Alimentos")) Dados.getOfertasAlimentos().remove(ofertaRemovida);
                                        if (!(empresa.getAreaAtuacao().equals("Tecnologia")) && !(empresa.getAreaAtuacao().equals("Vendas"))
                                        && !(empresa.getAreaAtuacao().equals("Hospitalar")) && !(empresa.getAreaAtuacao().equals("Educação"))
                                        && !(empresa.getAreaAtuacao().equals("Alimentos"))){Dados.getOfertasRestantes().remove(ofertaRemovida);}

                                        // Removendo a oferta de emprego da lista de ofertas inscritas dos candidatos
                                        for (Candidato candidato : candidatos) {
                                            if (candidato.getOfertasInscritas().contains(ofertaRemovida)) {                                            
                                                candidato.getOfertasInscritas().remove(ofertaRemovida);
                                            }
                                        }
                                        JOptionPane.showMessageDialog(null, "Oferta de emprego removida com sucesso!");
                                        camposPreenchidos = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Número de oferta inválido.");
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
    

    public static void imprimirOfertasEmprego(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true){     
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {           
                    // Verifica se a empresa tem ofertas de emprego
                    if (empresa.getOfertasOfertadas().isEmpty()) {
                        JOptionPane.showMessageDialog(null,"A empresa não tem nenhuma oferta de emprego cadastrada ainda!");
                    } else {
                        StringBuilder mensagem = new StringBuilder();                        
                        // Imprime as ofertas de emprego
                        for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                            int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                            mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                            .append(empresa.getOfertasOfertadas().get(i).toString()).append("\n");
                        }
                        JTextArea textArea = new JTextArea(20, 40);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        textArea.setText(mensagem.toString());
                        textArea.setEditable(false);
                        Object[] options = {"OK", "Cancel"};
                        JOptionPane.showOptionDialog(
                                null,
                                scrollPane,
                                "Ofertas de emprego para a empresa " + empresa.getNome() + ":",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                options,
                                options[0]
                        );
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }
    }

    
    public static OfertaEmprego lerDadosOfertaEmprego(Empresa empresa) {
    boolean camposPreenchidos = false;
    while (!camposPreenchidos) {
        JPanel panel = new JPanel(new GridLayout(5, 2, 20, 5));

        JTextField salarioField = new JTextField();
        JTextField cargoField = new JTextField();
        JTextField qntVagasField = new JTextField();
        JTextField escolaridadeField = new JTextField();

        panel.add(new JLabel("Salário:"));
        panel.add(salarioField);
        panel.add(new JLabel("Cargo:"));
        panel.add(cargoField);
        panel.add(new JLabel("Quantidade de Vagas:"));
        panel.add(qntVagasField);
        panel.add(new JLabel("Escolaridade Mínima:"));
        panel.add(escolaridadeField);

        // Defina as dimensões preferenciais do painel
        Dimension preferredSize = new Dimension(400, 200);
        panel.setPreferredSize(preferredSize);

        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                "Digite os dados da oferta de emprego:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );

        if (result == JOptionPane.OK_OPTION) {
            // Obtenha os valores inseridos pelos usuários
            try {
                double salario = Double.parseDouble(salarioField.getText());
                String cargo = cargoField.getText();
                int qntVagas = Integer.parseInt(qntVagasField.getText());
                String escolaridade = escolaridadeField.getText();

                // Realize as verificações necessárias, se aplicável
                // Adicione as condições de validação conforme necessário

                camposPreenchidos = true;
                LocalDateTime criadoEm = LocalDateTime.now();
                boolean ativa = true;

                // Crie e retorne um novo objeto OfertaEmprego
                return new OfertaEmprego(salario, cargo, qntVagas, criadoEm, escolaridade, ativa, empresa);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Retorna null se o usuário pressionar Cancelar ou fechar a janela
            return null;
        }
    }
        return null;
    }

    private static boolean algumCampoEmBranco(JTextField... campos){
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                return true; // Pelo menos um campo está em branco
            }
        }
        return false; // Nenhum campo está em branco
    } 
}