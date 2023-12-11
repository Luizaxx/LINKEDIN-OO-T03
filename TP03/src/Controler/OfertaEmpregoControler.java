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
                    // Verifica se a empresa tem ofertas de emprego
                    if (empresa.getOfertasOfertadas().isEmpty()) {
                        System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                    } else {
                        System.out.println("Ofertas de emprego ofertada pela empresa "+ empresa.getNome() +":");
                        
                        // Imprime as ofertas de emprego com números
                        for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                            int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                            System.out.println("\nOferta número: " + numeroOferta);
                            System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                        }

                        System.out.println("\nQual oferta da empresa " + empresa.getNome() +" você deseja editar? (Digite o número da oferta)");
                        int numeroOfertaEscolhida = in.nextInt();

                        // Verifica se o número da oferta escolhida é válido
                        if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                            // Obtém a oferta escolhida
                            OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);
                            System.out.println("Digite o novo salário: ");
                            double novoSalario = in.nextDouble();
                            ofertaParaEditar.setSalario(novoSalario);

                            System.out.println("\nOferta editada com sucesso!");
                        } else {
                            System.out.println("\nNúmero de oferta inválido.");
                        }
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }

    }

    public static void editarOfertaEmpregoCargo(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    // Verifica se a empresa tem ofertas de emprego
                    if (empresa.getOfertasOfertadas().isEmpty()) {
                        System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                    } else {
                        System.out.println("Ofertas de emprego ofertada pela empresa "+ empresa.getNome() +":");
                        
                        // Imprime as ofertas de emprego com números
                        for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                            int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                            System.out.println("\nOferta número: " + numeroOferta);
                            System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                        }
                        System.out.println("\nQual oferta da empresa " + empresa.getNome() +" você deseja editar? (Digite o número da oferta)");
                        int numeroOfertaEscolhida = in.nextInt();
                        // Verifica se o número da oferta escolhida é válido
                        if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                            // Obtém a oferta escolhida
                            OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);
                            in.nextLine();
                            System.out.println("Digite novo cargo: ");
                            String novoCargo = in.nextLine();
                            ofertaParaEditar.setCargo(novoCargo);

                            System.out.println("\nOferta editada com sucesso!");
                        } else {
                            System.out.println("\nNúmero de oferta inválido.");
                        }
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }
        
    }

    public static void editarOfertaEmpregoQntdVagas(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    // Verifica se a empresa tem ofertas de emprego
                    if (empresa.getOfertasOfertadas().isEmpty()) {
                        System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                    } else {
                        System.out.println("Ofertas de emprego ofertada pela empresa "+ empresa.getNome() +":");
                        
                        // Imprime as ofertas de emprego com números
                        for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                            int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                            System.out.println("\nOferta número: " + numeroOferta);
                            System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                        }

                        System.out.println("\nQual oferta da empresa " + empresa.getNome() +" você deseja editar? (Digite o número da oferta)");
                        int numeroOfertaEscolhida = in.nextInt();

                        // Verifica se o número da oferta escolhida é válido
                        if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                            // Obtém a oferta escolhida
                            OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);
                            System.out.println("Digite nova quantidade de vagas: ");
                            int novaQntdVagas = in.nextInt();
                            ofertaParaEditar.setQntVagas(novaQntdVagas);

                            System.out.println("\nOferta editada com sucesso!");
                        } else {
                            System.out.println("\nNúmero de oferta inválido.");
                        }
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }
    }

    public static void editarOfertaEmpregoEscolaridade(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    // Verifica se a empresa tem ofertas de emprego
                    if (empresa.getOfertasOfertadas().isEmpty()) {
                        System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                    } else {
                        System.out.println("Ofertas de emprego ofertada pela empresa "+ empresa.getNome() +":");
                        
                        // Imprime as ofertas de emprego com números
                        for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                            int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                            System.out.println("\nOferta número: " + numeroOferta);
                            System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                        }

                        System.out.println("\nQual oferta da empresa " + empresa.getNome() +" você deseja editar? (Digite o número da oferta)");
                        int numeroOfertaEscolhida = in.nextInt();

                        // Verifica se o número da oferta escolhida é válido
                        if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                            // Obtém a oferta escolhida
                            OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);
                            in.nextLine();
                            System.out.println("Qual novo nível de escolaridade necessário? ");
                            String novoNivelEscolaridade = in.nextLine();
                            ofertaParaEditar.setEscolaridade(novoNivelEscolaridade);

                            System.out.println("\nOferta editada com sucesso!");
                        } else {
                            System.out.println("\nNúmero de oferta inválido.");
                        }
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }
    }

    // public static void apagarOfertaEmprego() {
    //     String cnpjDesejado = CNPJ();
    //     if (verificaCNPJ(cnpjDesejado)) {
    //         for (Empresa empresa : empresas) {
    //             if (empresa.getCnpj().equals(cnpjDesejado)) {
    //                 if (empresa.getOfertasOfertadas().isEmpty()) {
    //                     System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
    //                 } else {
    //                     // Mostra as ofertas de emprego com números
    //                     System.out.println("Ofertas de emprego ofertadas pela empresa " + empresa.getNome() + ":");
    
    //                     for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
    //                         int numeroOferta = i + 1;
    //                         System.out.println("\nOferta número: " + numeroOferta);
    //                         System.out.println(empresa.getOfertasOfertadas().get(i).toString());
    //                     }
    //                     System.out.println("\nQual oferta da empresa " + empresa.getNome() + " você deseja apagar? (Digite o número da oferta)");
    //                     int numeroOfertaEscolhida = in.nextInt();
    //                     if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
    //                         // Removendo a oferta de emprego da empresa
    //                         OfertaEmprego ofertaRemovida = empresa.getOfertasOfertadas().remove(numeroOfertaEscolhida - 1);
                            
    //                         // Removendo a oferta de emprego da lista de ofertas inscritas dos candidatos
    //                         for (Candidato candidato : candidatos) {
    //                             if (candidato.getOfertasInscritas().contains(ofertaRemovida)) {
    //                                 candidato.getOfertasInscritas().remove(ofertaRemovida);
    //                                 break;
    //                             }
    //                         }
    //                         System.out.println("\nOferta de emprego removida com sucesso!");
    //                     } else {
    //                         System.out.println("\nNúmero de oferta inválido.");
    //                     }
    //                 }
    //                 break;
    //             }
    //         }
    //     }
    // }

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
                                        if(empresa.getAreaAtuacao().equals("Alimentos")) Dados.getOfertasAlimentos().remove(ofertaRemovida);
                                        // Removendo a oferta de emprego da lista de ofertas inscritas dos candidatos
                                        for (Candidato candidato : candidatos) {
                                            System.out.println("Ofertas antes: "+candidato.getOfertasInscritas().toString());
                                            if (candidato.getOfertasInscritas().contains(ofertaRemovida)) {                                            
                                                candidato.getOfertasInscritas().remove(ofertaRemovida);
                                                System.out.println("Ofertas depois: "+candidato.getOfertasInscritas().toString()+ "Nome do candidato: "+ candidato.getNome());
                                                break;
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
                        System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                    } else {
                        System.out.println("Ofertas de emprego para a empresa " + empresa.getNome() + ":");
                        // Imprime as ofertas de emprego
                        for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                            int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                            System.out.println("\nOferta número: " + numeroOferta);
                            System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                        }
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