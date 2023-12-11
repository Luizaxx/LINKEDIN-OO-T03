package controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;


import model.Candidato;
import model.Empresa;
import model.OfertaEmprego;
public class CandidatoControler {
    
    private static Scanner in = new Scanner(System.in);

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();
    static ArrayList<OfertaEmprego> ofertasInscritas = Dados.getOfertasInscritas();
    static ArrayList<OfertaEmprego> ofertasTecnologia = Dados.getOfertasTecnologia();
    static ArrayList<OfertaEmprego> ofertasVendas = Dados.getOfertasVendas();
    static ArrayList<OfertaEmprego> ofertaHospitalares = Dados.getOfertasHospitalar();
    static ArrayList<OfertaEmprego> ofertasAlimentos = Dados.getOfertasAlimentos();
    static ArrayList<OfertaEmprego> ofertasEducacao = Dados.getOfertasEducacao();
    static ArrayList<OfertaEmprego> ofertasRestantes = Dados.getOfertasRestantes();

    public static String CPF(){        
        String cpfDesejado = JOptionPane.showInputDialog(null,"\nQual é o seu CPF? ", "Informe o seu CPF", JOptionPane.PLAIN_MESSAGE);
        return cpfDesejado;
    }

    public static boolean verificaCPF(String cpfDesejado){        
        boolean encontrado = false;        
        for (Candidato candidato : candidatos){
            if (candidato.getCpf().equals(cpfDesejado)) {
                encontrado = true;
                break;                
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null,"\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
        }
        return encontrado;
    }

    public static void cadastrarCandidato() {
        Candidato novoCandidato = lerDadosCandidato();
        if (novoCandidato != null) {
            Dados.getCandidatosInscritos().add(novoCandidato);
            JOptionPane.showMessageDialog(null,"Candidato cadastrado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void editarNomeCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    String novoNome = JOptionPane.showInputDialog(null,"Antigo nome cadastrado no seu cadastro: "+ candidato.getNome()+" \nDigite o novo nome:");
                    candidato.setNome(novoNome);
                    JOptionPane.showMessageDialog(null,"Nome editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarEmailCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    String novoEmail = JOptionPane.showInputDialog(null,"Antigo email cadastrado no seu cadastro: "+ candidato.getEmail() + " \nDigite o novo email: ");
                    candidato.setEmail(novoEmail);
                    JOptionPane.showMessageDialog(null,"Email editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarDataNascimentoCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    String novaDataNascimento = JOptionPane.showInputDialog(null,"Antiga data de nascimento cadastrado no seu cadastro: "+ candidato.getDataNascimento() + " \nDigite a nova data de nascimento:");
                    candidato.setDataNascimento(novaDataNascimento);
                    JOptionPane.showMessageDialog(null,"Data de nascimento editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarEnderecoCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    String novoEndereco = JOptionPane.showInputDialog(null, "Antigo endereço cadastrado no seu cadastro: "+ candidato.getEndereco() + " \nDigite o novo endereço: ");
                    candidato.setEndereco(novoEndereco);
                    JOptionPane.showMessageDialog(null,"Endereço editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarTelefoneCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println();
                    System.out.println("");
                    String novoTelefone = JOptionPane.showInputDialog(null, "Antigo telefone cadastrado no seu cadastro: "+ candidato.getTelefone() + " \nDigite o novo telefone:");
                    candidato.setTelefone(novoTelefone);
                    JOptionPane.showMessageDialog(null,"Telefone editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarAreaAtuacaoCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    String novaAreaAtuacao = JOptionPane.showInputDialog(null,"Antiga área de atuação cadastrado no seu cadastro: "+ candidato.getAreaAtuacao() + " \nDigite a nova área de atuação:");
                    candidato.setAreaAtuacao(novaAreaAtuacao);
                    JOptionPane.showMessageDialog(null,"Área de atuação editada com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarCpfCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    String novoCPF = JOptionPane.showInputDialog(null, "Antigo CPF cadastrado no seu cadastro: "+ candidato.getCpf() + " \nDigite o novo CPF:");
                    candidato.setCpf(novoCPF);
                    JOptionPane.showMessageDialog(null,"CPF editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarNivelEscolaridadeCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    String novoNivelEscolaridade = JOptionPane.showInputDialog(null,"Antigo nível de escolaridade cadastrado no seu cadastro: "+ candidato.getNivelEscolaridade() + " \nDigite o novo nível de escolaridade:");
                    candidato.setNivelEscolaridade(novoNivelEscolaridade);
                    JOptionPane.showMessageDialog(null,"Nível de escolaridade editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarInstituicaoCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    String novaInstituicao = JOptionPane.showInputDialog(null,"Antiga instituiçã cadastradá no seu cadastro: "+ candidato.getInstituicao() + " \nDigite o novo nome da instituição:");
                    candidato.setInstituicao(novaInstituicao);
                    JOptionPane.showMessageDialog(null,"Nome da instituição editada com sucesso!");
                    break;
                }
            }
        }
    }

    public static void apagarCadastroDoSistema(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            Iterator<Candidato> iterator = candidatos.iterator();
            while (iterator.hasNext()) {
                Candidato candidato = iterator.next();
                if (candidato.getCpf().equals(cpfDesejado)) {
                    iterator.remove(); // Remove o candidato usando o iterador
                    JOptionPane.showMessageDialog(null,"Candidato(a) removido(a) com sucesso!");
                    break; // Se encontrou o candidato, não precisa continuar procurando
                }
            }
        }
    }

    public static void removerOfertaEmpregoCandidatos(String cnpjEmpresa) {
        Iterator<Candidato> iterator = candidatos.iterator();
        while (iterator.hasNext()) {
            Candidato candidato = iterator.next();
            if (candidato.getOfertasInscritas() != null) {
                Iterator<OfertaEmprego> ofertaIterator = candidato.getOfertasInscritas().iterator();
                while (ofertaIterator.hasNext()) {
                    OfertaEmprego oferta = ofertaIterator.next();
                    if (oferta.getEmpresa() != null && oferta.getEmpresa().getCnpj().equals(cnpjEmpresa)) {
                        ofertaIterator.remove();
                    }
                }
            }
        }
    }

    public static void filtrarOfertasEmpregoTecnologia(){  
        for (OfertaEmprego ofertaTecnologia : ofertasTecnologia) {
            int numeroOferta = ofertasTecnologia.indexOf(ofertaTecnologia) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaTecnologia);
        }
    }

    public static void filtrarOfertasEmpregoVendas(){
       for(OfertaEmprego ofertaVendas : ofertasVendas){
            int numeroOferta = ofertasVendas.indexOf(ofertaVendas) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaVendas);
       }
    }

    public static void filtrarOfertasEmpregoAlimentos(){
       for(OfertaEmprego ofertaAlimentos : ofertasAlimentos){
            int numeroOferta = ofertasAlimentos.indexOf(ofertaAlimentos) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaAlimentos);
       }
    }

    public static void filtrarOfertasEmpregoHospitalar(){
       for(OfertaEmprego ofertaHospitalar : ofertaHospitalares){
            int numeroOferta = ofertaHospitalares.indexOf(ofertaHospitalar) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaHospitalar);
       }
    }

    public static void filtrarOfertasEmpregoEducacao(){
       for(OfertaEmprego ofertaEducacao : ofertasEducacao){
            int numeroOferta = ofertasEducacao.indexOf(ofertaEducacao) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaEducacao);
       }
    }

    public static void filtrarOfertasEmpregoRestantes(){
        for(OfertaEmprego ofertaRestante : ofertasRestantes){
            int numeroOferta = ofertasRestantes.indexOf(ofertaRestante) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaRestante);
        }
    }

    public static void seInscreverOfertaEmpregoAreaTecnologia() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você que se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasTecnologia.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasTecnologia.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
   
    public static void seInscreverOfertaEmpregoAreaVendas() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você que se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasVendas.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasVendas.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
   
    public static void seInscreverOfertaEmpregoAreaHospitalar() {
        String cpfDesejado = CPF();    
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você que se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertaHospitalares.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertaHospitalares.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
     
    public static void seInscreverOfertaEmpregoAreaAlimentos() {
        String cpfDesejado = CPF();    
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você quer se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasAlimentos.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasAlimentos.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
      
    public static void seInscreverOfertaEmpregoAreaEducacao() {
        String cpfDesejado = CPF();    
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você quer se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasEducacao.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasEducacao.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
     
    public static void seInscreverOfertaEmpregoAreasRestantes() {
        String cpfDesejado = CPF();    
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você quer se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasRestantes.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasRestantes.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }

    public static void imprimirCandidatos() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) { //Verifica se existe candidatos cadastrados no sistema
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {            
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    JTextArea textArea = new JTextArea(20, 40);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    textArea.append(candidato.toString() + "\n\n");         
                    textArea.setEditable(false);
                    Object[] options = {"OK", "Cancel"};
                    JOptionPane.showOptionDialog(
                            null,
                            scrollPane,
                            "Dados completos do seu cadastro",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            options,
                            options[0]
                    );
                    }
                }
            }
        }
    }

    public static void imprimirCadastroTodosClientes(){
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nenhum candidato foi cadastrado no sistema ainda.");
        }else{
            JTextArea textArea = new JTextArea(20, 40);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            for (Candidato candidato : candidatos) {
                textArea.append(candidato.toString() + "\n\n");
            }
            textArea.setEditable(false);
            Object[] options = {"OK", "Cancel"};
            JOptionPane.showOptionDialog(
                    null,
                    scrollPane,
                    "Banco de dados dos candidatos cadastrados e suas ofertas inscritas",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );
           
        }
    }

    public static void imprimirOfertasEmpregoInscritas() {
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {
                    // Verifica se o candidato tem ofertas de emprego inscritas
                    if (candidato.getOfertasInscritas().isEmpty()) {
                        System.out.println("O candidato não tem nenhuma oferta de emprego inscrita ainda.");
                    } else {
                        JTextArea textArea = new JTextArea(20, 40);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        
                        for (OfertaEmprego oferta : candidato.getOfertasInscritas()) {
                            textArea.append(oferta.toString() + "\n");
                        }
                        textArea.setEditable(false);
                        Object[] options = {"OK", "Cancel"};
                        JOptionPane.showOptionDialog(
                        null,
                        scrollPane,
                        "Ofertas de emprego inscritas para " + candidato.getNome() + ":" ,
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]
                        );
                    }
                    break; // Se encontrou o candidato, não precisa continuar procurando
                }
            }
        }
    }

    // public static void apagarOfertaEmpregoInscrita(){
    //     String cpfDesejado = CPF();
    //     if (verificaCPF(cpfDesejado)) {
    //         for (Candidato candidato : candidatos) {
    //             if (candidato.getCpf().equals(cpfDesejado)) {  
    //                 // Verifica se o candidato tem ofertas de emprego inscritas
    //                 if (candidato.getOfertasInscritas().isEmpty()) {
    //                     System.out.println("O candidato não tem nenhuma oferta de emprego inscrita ainda.");
    //                 }else{                        
    //                     System.out.println("Ofertas de emprego inscritas para "+ candidato.getNome() +":");                            
    //                     // Imprime as ofertas de emprego com números
    //                     for (int i = 0; i < candidato.getOfertasInscritas().size(); i++) {
    //                         int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
    //                         System.out.println("\nOferta número: " + numeroOferta);
    //                         System.out.println(candidato.getOfertasInscritas().get(i).toString());
    //                     }
    //                     System.out.println("\nQual oferta de emprego você deseja retirar sua inscrição? (Digite o número da oferta)");
    //                     int numeroOfertaEscolhida = in.nextInt();
    //                     // Verifica se o número da oferta escolhida é válido
    //                     if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= candidato.getOfertasInscritas().size()){     
    //                         //removendo a oferta de emprego da empresa              
    //                         candidato.getOfertasInscritas().remove(numeroOfertaEscolhida - 1);
    //                         System.out.println("\nInscrição retirada com sucesso!");
    //                     }else{
    //                         System.out.println("\nNúmero de oferta inválido.");
    //                     }
    //                 }
    //                 break; // Se encontrou a empresa, não precisa continuar procurando
    //             }
    //         } 
    //     }
    // }
    public static void apagarOfertaEmpregoInscrita() {
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {
                    if (candidato.getOfertasInscritas().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "O candidato não tem nenhuma oferta de emprego inscrita ainda.");
                    } else {
                        StringBuilder mensagem = new StringBuilder();
                        //mensagem.append("Ofertas de emprego inscritas para ").append(candidato.getNome()).append(":\n");

                        for (int i = 0; i < candidato.getOfertasInscritas().size(); i++) {
                            int numeroOferta = i + 1;
                            mensagem.append("\nOferta número: ").append(numeroOferta).append("\n")
                                    .append(candidato.getOfertasInscritas().get(i).toString()).append("\n");
                        }

                        JTextArea textArea = new JTextArea(10, 40);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                        textArea.setText(mensagem.toString());
                        textArea.setEditable(false);

                        JPanel panel = new JPanel(new BorderLayout());
                        panel.add(scrollPane, BorderLayout.NORTH);

                        JLabel mensagemLabel = new JLabel("\nQual das ofertas você deseja tirar a sua inscrição, digite o número:");
                        panel.add(mensagemLabel, BorderLayout.CENTER);

                        JTextField inputField = new JTextField();
                        panel.add(inputField, BorderLayout.SOUTH);

                        int result = JOptionPane.showOptionDialog(
                                null,
                                panel,
                                "Ofertas de emprego inscritas para " + candidato.getNome(),
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                null,
                                null
                        );

                        if (result == JOptionPane.OK_OPTION) {
                            // Lógica para processar o campo de entrada
                            String input = inputField.getText();
                            int numeroOfertaEscolhida = Integer.parseInt(input);

                            if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= candidato.getOfertasInscritas().size()) {
                                candidato.getOfertasInscritas().remove(numeroOfertaEscolhida - 1);
                                JOptionPane.showMessageDialog(null, "Inscrição retirada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Número de oferta inválido.");
                            }
                        }
                    }
                    break;
                }
            }
        }
    }       
    /*
    public static void apagarOfertaEmpregoInscrita() {
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {
                    if (candidato.getOfertasInscritas().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "O candidato não tem nenhuma oferta de emprego inscrita ainda.");
                    } else {
                        JTextArea textArea = new JTextArea(20, 40);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                            
                        for (int i = 0; i < candidato.getOfertasInscritas().size(); i++) {
                            int numeroOferta = i + 1;
                            textArea.append("\nOferta número: ").append(numeroOferta).append("\n")
                                    .append(candidato.getOfertasInscritas().get(i).toString()).append("\n");
                        }
                        //textArea.setEditable(false);
                        JOptionPane.showOptionDialog(
                        null,
                        scrollPane,
                        "Ofertas de emprego inscritas para " + candidato.getNome() + ":" ,
                        null,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,                        
                        );

                        textArea.append("\nQual oferta de emprego você deseja retirar sua inscrição? (Digite o número da oferta)");

                        String input = JOptionPane.showInputDialog(null, mensagem.toString());

                        try {
                            int numeroOfertaEscolhida = Integer.parseInt(input);

                            if (input >= 1 && input <= candidato.getOfertasInscritas().size()) {
                                candidato.getOfertasInscritas().remove(input - 1);
                                JOptionPane.showMessageDialog(null, "Inscrição retirada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Número de oferta inválido.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
                        }
                    }
                    break;
                }
            }
        } 
    }
     */
    public static Candidato lerDadosCandidato() {
        boolean camposPreenchidos = false;

        while (!camposPreenchidos) {
        JPanel panel = new JPanel(new GridLayout(10, 2, 20, 5));

        JTextField nomeField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField dataNascimentoField = new JTextField();
        JTextField enderecoField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextField areaAtuacaoField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField nivelEscolaridadeField = new JTextField();
        JTextField instituicaoField = new JTextField();

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Data de Nascimento:"));
        panel.add(dataNascimentoField);
        panel.add(new JLabel("Endereço:"));
        panel.add(enderecoField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("Área de Atuação:"));
        panel.add(areaAtuacaoField);
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Nível de Escolaridade:"));
        panel.add(nivelEscolaridadeField);
        panel.add(new JLabel("Instituição:"));
        panel.add(instituicaoField);

        // Defina as dimensões preferenciais do painel
        Dimension preferredSize = new Dimension(400, 300);
        panel.setPreferredSize(preferredSize);

        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                "Digite os seus dados:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );

        if (result == JOptionPane.OK_OPTION) {
            // Obtenha os valores inseridos pelos usuários
            String nome = nomeField.getText();
            String email = emailField.getText();
            String dataNascimento = dataNascimentoField.getText();
            String endereco = enderecoField.getText();
            String telefone = telefoneField.getText();
            String areaAtuacao = areaAtuacaoField.getText();
            String cpf = cpfField.getText();
            String nivelEscolaridade = nivelEscolaridadeField.getText();
            String instituicao = instituicaoField.getText();

            // Realize as verificações necessárias, se aplicável
            if (verificaCPF(cpf)) {
                JOptionPane.showMessageDialog(null, "\nEsse CPF já existe no sistema. Logo você já tem uma conta conosco!\n");
                return null;
            }

            if (algumCampoEmBranco(nomeField, emailField, dataNascimentoField, enderecoField, telefoneField, areaAtuacaoField, cpfField, nivelEscolaridadeField, instituicaoField) == false) {
                camposPreenchidos = true;
                // Crie e retorne um novo objeto Candidato
                ArrayList<OfertaEmprego> ofertasInscritas = new ArrayList<>();
                
                return new Candidato(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cpf, nivelEscolaridade, instituicao, ofertasInscritas);
                
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            
        }else{
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