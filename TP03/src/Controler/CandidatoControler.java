package controler;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import java.awt.*;

import model.Candidato;
import model.Empresa;
import model.OfertaEmprego;

public class CandidatoControler {

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();
    static ArrayList<OfertaEmprego> ofertasInscritas = Dados.getOfertasInscritas();
    static ArrayList<OfertaEmprego> ofertasTecnologia = Dados.getOfertasTecnologia();
    static ArrayList<OfertaEmprego> ofertasVendas = Dados.getOfertasVendas();
    static ArrayList<OfertaEmprego> ofertaHospitalares = Dados.getOfertasHospitalar();
    static ArrayList<OfertaEmprego> ofertasAlimentos = Dados.getOfertasAlimentos();
    static ArrayList<OfertaEmprego> ofertasEducacao = Dados.getOfertasEducacao();
    static ArrayList<OfertaEmprego> ofertasRestantes = Dados.getOfertasRestantes();

    public static String CPF() {
        boolean camposPreenchidos = false;
        while (!camposPreenchidos) {
            String cpfDesejado = JOptionPane.showInputDialog(null, "\nQual é o seu CPF? ", "Informe o seu CPF",
                    JOptionPane.PLAIN_MESSAGE);
            if (cpfDesejado == null) { // Caso o usuário cancele a operação ou aperte no botão de fechar a janela
                break;
            }
            if (cpfDesejado.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite o seu CPF antes de prosseguir.", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                if (!verificaCPF(cpfDesejado)) {
                    JOptionPane.showMessageDialog(null,
                            "Esse CPF não existe na nossa base de dados\ndigite um CPF valido!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    camposPreenchidos = true;
                    return cpfDesejado;
                }
            }
        }
        return null;
    }

    public static boolean verificaCPF(String cpfDesejado) {
        boolean encontrado = false;
        if (cpfDesejado != null) {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {
                    encontrado = true;
                    break;
                }
            }
        }
        return encontrado;
    }

    public static void cadastrarCandidato() {
        Candidato novoCandidato = lerDadosCandidato();
        if (novoCandidato != null) {
            Dados.getCandidatosInscritos().add(novoCandidato);
            JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso!", "Sucesso!",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void apagarCadastroDoSistema() {
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            Iterator<Candidato> iterator = candidatos.iterator();
            while (iterator.hasNext()) {
                Candidato candidato = iterator.next();
                if (candidato.getCpf().equals(cpfDesejado)) {
                    iterator.remove(); // Remove o candidato usando o iterador
                    JOptionPane.showMessageDialog(null, "Candidato(a) removido(a) com sucesso!");
                    break; // Se encontrou o candidato, não precisa continuar procurando
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
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

    public static void filtrarOfertasEmpregoTecnologia() {
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        for (OfertaEmprego ofertaTecnologia : ofertasTecnologia) {
            int numeroOferta = ofertasTecnologia.indexOf(ofertaTecnologia) + 1;
            textArea.append("\nOferta número: " + numeroOferta + "\n");
            textArea.append(ofertaTecnologia.toString());
        }
        textArea.setEditable(false);
        Object[] options = { "OK", "Cancel" };
        JOptionPane.showOptionDialog(
                null,
                scrollPane,
                "Todas as ofertas de emprego da área de Tecnologia",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static void filtrarOfertasEmpregoVendas() {
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        for (OfertaEmprego ofertaVendas : ofertasVendas) {
            int numeroOferta = ofertasVendas.indexOf(ofertaVendas) + 1;
            textArea.append("\nOferta número: " + numeroOferta + "\n");
            textArea.append(ofertaVendas.toString());
        }
        textArea.setEditable(false);
        Object[] options = { "OK", "Cancel" };
        JOptionPane.showOptionDialog(
                null,
                scrollPane,
                "Todas as ofertas de emprego da área de Vendas",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static void filtrarOfertasEmpregoAlimentos() {
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        for (OfertaEmprego ofertaAlimentos : ofertasAlimentos) {
            int numeroOferta = ofertasAlimentos.indexOf(ofertaAlimentos) + 1;
            textArea.append("\nOferta número: " + numeroOferta + "\n");
            textArea.append(ofertaAlimentos.toString());
        }
        textArea.setEditable(false);
        Object[] options = { "OK", "Cancel" };
        JOptionPane.showOptionDialog(
                null,
                scrollPane,
                "Todas as ofertas de emprego da área de Alimentos",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static void filtrarOfertasEmpregoHospitalar() {
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        for (OfertaEmprego ofertaHospitalar : ofertaHospitalares) {
            int numeroOferta = ofertaHospitalares.indexOf(ofertaHospitalar) + 1;
            textArea.append("\nOferta número: " + numeroOferta + "\n");
            textArea.append(ofertaHospitalar.toString());
        }
        textArea.setEditable(false);
        Object[] options = { "OK", "Cancel" };
        JOptionPane.showOptionDialog(
                null,
                scrollPane,
                "Todas as ofertas de emprego da área Hospitalar",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static void filtrarOfertasEmpregoEducacao() {
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        for (OfertaEmprego ofertaEducacao : ofertasEducacao) {
            int numeroOferta = ofertasEducacao.indexOf(ofertaEducacao) + 1;
            textArea.append("\nOferta número: " + numeroOferta + "\n");
            textArea.append(ofertaEducacao.toString());
        }
        textArea.setEditable(false);
        Object[] options = { "OK", "Cancel" };
        JOptionPane.showOptionDialog(
                null,
                scrollPane,
                "Todas as ofertas de emprego da área de Educação",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static void filtrarOfertasEmpregoRestantes() {
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        for (OfertaEmprego ofertaRestante : ofertasRestantes) {
            int numeroOferta = ofertasRestantes.indexOf(ofertaRestante) + 1;
            textArea.append("\nOferta número: " + numeroOferta + "\n");
            textArea.append(ofertaRestante.toString());
        }
        textArea.setEditable(false);
        Object[] options = { "OK", "Cancel" };
        JOptionPane.showOptionDialog(
                null,
                scrollPane,
                "Todas as ofertas de emprego restante",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static void seInscreverOfertaEmpregoAreaTecnologia() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                for (Candidato candidato : candidatos) {
                    if (candidato.getCpf().equals(cpfDesejado)) {
                        boolean camposPreenchidos = false;
                        while (!camposPreenchidos) {
                            StringBuilder mensagem = new StringBuilder();
                            for (OfertaEmprego ofertaTecnologia : ofertasTecnologia) {
                                int numeroOferta = ofertasTecnologia.indexOf(ofertaTecnologia) + 1;
                                mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                                        .append(ofertaTecnologia.toString()).append("\n");
                            }
                            JTextArea textArea = new JTextArea(10, 40);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                            textArea.setText(mensagem.toString());
                            textArea.setEditable(false);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.NORTH);

                            JLabel mensagemLabel = new JLabel(
                                    "Em qual das ofertas você deseja se inscrever? Digite o número da oferta:");
                            panel.add(mensagemLabel, BorderLayout.CENTER);

                            JTextField inputField = new JTextField();
                            panel.add(inputField, BorderLayout.SOUTH);

                            int result = JOptionPane.showOptionDialog(
                                    null,
                                    panel,
                                    "Ofertas de emprego da área de Tecnologia desponíveis para " + candidato.getNome(),
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    null);

                            if (result == JOptionPane.OK_OPTION) {
                                String input = inputField.getText();
                                if (algumCampoEmBranco(inputField)) {
                                    JOptionPane.showMessageDialog(null,
                                            "Digite o número da oferta antes de prosseguir.", "Aviso",
                                            JOptionPane.WARNING_MESSAGE);
                                } else {
                                    int numeroOfertaEscolhida = Integer.parseInt(input);
                                    if (numeroOfertaEscolhida <= 0
                                            || numeroOfertaEscolhida >= ofertasTecnologia.size() + 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "Número de oferta inválido, digite novamente.", "Aviso",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        OfertaEmprego ofertaSelecionada = ofertasTecnologia
                                                .get(numeroOfertaEscolhida - 1);
                                        if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Você já está inscrito(a) nesta oferta!");
                                        } else {
                                            camposPreenchidos = true;
                                            candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!");
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
            }
        }
    }

    public static void seInscreverOfertaEmpregoAreaVendas() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                for (Candidato candidato : candidatos) {
                    if (candidato.getCpf().equals(cpfDesejado)) {
                        boolean camposPreenchidos = false;
                        while (!camposPreenchidos) {
                            StringBuilder mensagem = new StringBuilder();
                            for (OfertaEmprego ofertaVendas : ofertasVendas) {
                                int numeroOferta = ofertasVendas.indexOf(ofertaVendas) + 1;
                                mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                                        .append(ofertaVendas.toString()).append("\n");
                            }
                            JTextArea textArea = new JTextArea(10, 40);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                            textArea.setText(mensagem.toString());
                            textArea.setEditable(false);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.NORTH);

                            JLabel mensagemLabel = new JLabel(
                                    "Em qual das ofertas você deseja se inscrever? Digite o número da oferta:");
                            panel.add(mensagemLabel, BorderLayout.CENTER);

                            JTextField inputField = new JTextField();
                            panel.add(inputField, BorderLayout.SOUTH);

                            int result = JOptionPane.showOptionDialog(
                                    null,
                                    panel,
                                    "Ofertas de emprego da área de Vendas desponíveis para " + candidato.getNome(),
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    null);

                            if (result == JOptionPane.OK_OPTION) {
                                String input = inputField.getText();
                                if (algumCampoEmBranco(inputField)) {
                                    JOptionPane.showMessageDialog(null,
                                            "Digite o número da oferta antes de prosseguir.", "Aviso",
                                            JOptionPane.WARNING_MESSAGE);
                                } else {
                                    int numeroOfertaEscolhida = Integer.parseInt(input);
                                    if (numeroOfertaEscolhida <= 0
                                            || numeroOfertaEscolhida >= ofertasVendas.size() + 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "Número de oferta inválido, digite novamente.", "Aviso",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        OfertaEmprego ofertaSelecionada = ofertasVendas.get(numeroOfertaEscolhida - 1);
                                        if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Você já está inscrito(a) nesta oferta!");
                                        } else {
                                            camposPreenchidos = true;
                                            candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!");
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
            }
        }
    }

    public static void seInscreverOfertaEmpregoAreaHospitalar() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                for (Candidato candidato : candidatos) {
                    if (candidato.getCpf().equals(cpfDesejado)) {
                        boolean camposPreenchidos = false;
                        while (!camposPreenchidos) {
                            StringBuilder mensagem = new StringBuilder();
                            for (OfertaEmprego ofertaHospitalar : ofertaHospitalares) {
                                int numeroOferta = ofertaHospitalares.indexOf(ofertaHospitalar) + 1;
                                mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                                        .append(ofertaHospitalar.toString()).append("\n");
                            }
                            JTextArea textArea = new JTextArea(10, 40);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                            textArea.setText(mensagem.toString());
                            textArea.setEditable(false);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.NORTH);

                            JLabel mensagemLabel = new JLabel(
                                    "Em qual das ofertas você deseja se inscrever? Digite o número da oferta:");
                            panel.add(mensagemLabel, BorderLayout.CENTER);

                            JTextField inputField = new JTextField();
                            panel.add(inputField, BorderLayout.SOUTH);

                            int result = JOptionPane.showOptionDialog(
                                    null,
                                    panel,
                                    "Ofertas de emprego da área Hospitalar desponíveis para " + candidato.getNome(),
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    null);

                            if (result == JOptionPane.OK_OPTION) {
                                String input = inputField.getText();
                                if (algumCampoEmBranco(inputField)) {
                                    JOptionPane.showMessageDialog(null,
                                            "Digite o número da oferta antes de prosseguir.", "Aviso",
                                            JOptionPane.WARNING_MESSAGE);
                                } else {
                                    int numeroOfertaEscolhida = Integer.parseInt(input);
                                    if (numeroOfertaEscolhida <= 0
                                            || numeroOfertaEscolhida >= ofertaHospitalares.size() + 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "Número de oferta inválido, digite novamente.", "Aviso",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        OfertaEmprego ofertaSelecionada = ofertaHospitalares
                                                .get(numeroOfertaEscolhida - 1);
                                        if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Você já está inscrito(a) nesta oferta!");
                                        } else {
                                            camposPreenchidos = true;
                                            candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!");
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
            }
        }
    }

    public static void seInscreverOfertaEmpregoAreaAlimentos() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                for (Candidato candidato : candidatos) {
                    if (candidato.getCpf().equals(cpfDesejado)) {
                        boolean camposPreenchidos = false;
                        while (!camposPreenchidos) {
                            StringBuilder mensagem = new StringBuilder();
                            for (OfertaEmprego ofertaAlimentos : ofertasAlimentos) {
                                int numeroOferta = ofertasAlimentos.indexOf(ofertaAlimentos) + 1;
                                mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                                        .append(ofertaAlimentos.toString()).append("\n");
                            }
                            JTextArea textArea = new JTextArea(10, 40);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                            textArea.setText(mensagem.toString());
                            textArea.setEditable(false);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.NORTH);

                            JLabel mensagemLabel = new JLabel(
                                    "Em qual das ofertas você deseja se inscrever? Digite o número da oferta:");
                            panel.add(mensagemLabel, BorderLayout.CENTER);

                            JTextField inputField = new JTextField();
                            panel.add(inputField, BorderLayout.SOUTH);

                            int result = JOptionPane.showOptionDialog(
                                    null,
                                    panel,
                                    "Ofertas de emprego da área de Alimentos desponíveis para " + candidato.getNome(),
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    null);

                            if (result == JOptionPane.OK_OPTION) {
                                String input = inputField.getText();
                                if (algumCampoEmBranco(inputField)) {
                                    JOptionPane.showMessageDialog(null,
                                            "Digite o número da oferta antes de prosseguir.", "Aviso",
                                            JOptionPane.WARNING_MESSAGE);
                                } else {
                                    int numeroOfertaEscolhida = Integer.parseInt(input);
                                    if (numeroOfertaEscolhida <= 0
                                            || numeroOfertaEscolhida >= ofertasAlimentos.size() + 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "Número de oferta inválido, digite novamente.", "Aviso",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        OfertaEmprego ofertaSelecionada = ofertasAlimentos
                                                .get(numeroOfertaEscolhida - 1);
                                        if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Você já está inscrito(a) nesta oferta!");
                                        } else {
                                            camposPreenchidos = true;
                                            candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!");
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
            }
        }
    }

    public static void seInscreverOfertaEmpregoAreaEducacao() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                for (Candidato candidato : candidatos) {
                    if (candidato.getCpf().equals(cpfDesejado)) {
                        boolean camposPreenchidos = false;
                        while (!camposPreenchidos) {
                            StringBuilder mensagem = new StringBuilder();
                            for (OfertaEmprego ofertaEducacao : ofertasEducacao) {
                                int numeroOferta = ofertasEducacao.indexOf(ofertaEducacao) + 1;
                                mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                                        .append(ofertaEducacao.toString()).append("\n");
                            }
                            JTextArea textArea = new JTextArea(10, 40);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                            textArea.setText(mensagem.toString());
                            textArea.setEditable(false);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.NORTH);

                            JLabel mensagemLabel = new JLabel(
                                    "Em qual das ofertas você deseja se inscrever? Digite o número da oferta:");
                            panel.add(mensagemLabel, BorderLayout.CENTER);

                            JTextField inputField = new JTextField();
                            panel.add(inputField, BorderLayout.SOUTH);

                            int result = JOptionPane.showOptionDialog(
                                    null,
                                    panel,
                                    "Ofertas de emprego da área de Educação desponíveis para " + candidato.getNome(),
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    null);

                            if (result == JOptionPane.OK_OPTION) {
                                String input = inputField.getText();
                                if (algumCampoEmBranco(inputField)) {
                                    JOptionPane.showMessageDialog(null,
                                            "Digite o número da oferta antes de prosseguir.", "Aviso",
                                            JOptionPane.WARNING_MESSAGE);
                                } else {
                                    int numeroOfertaEscolhida = Integer.parseInt(input);
                                    if (numeroOfertaEscolhida <= 0
                                            || numeroOfertaEscolhida >= ofertasEducacao.size() + 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "Número de oferta inválido, digite novamente.", "Aviso",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        OfertaEmprego ofertaSelecionada = ofertasEducacao
                                                .get(numeroOfertaEscolhida - 1);
                                        if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Você já está inscrito(a) nesta oferta!");
                                        } else {
                                            camposPreenchidos = true;
                                            candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!");
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
            }
        }
    }

    public static void seInscreverOfertaEmpregoAreasRestantes() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                for (Candidato candidato : candidatos) {
                    if (candidato.getCpf().equals(cpfDesejado)) {
                        boolean camposPreenchidos = false;
                        while (!camposPreenchidos) {
                            StringBuilder mensagem = new StringBuilder();
                            for (OfertaEmprego ofertaRestante : ofertasRestantes) {
                                int numeroOferta = ofertasRestantes.indexOf(ofertaRestante) + 1;
                                mensagem.append("Oferta número: ").append(numeroOferta).append("\n")
                                        .append(ofertaRestante.toString()).append("\n");
                            }
                            JTextArea textArea = new JTextArea(10, 40);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                            textArea.setText(mensagem.toString());
                            textArea.setEditable(false);

                            JPanel panel = new JPanel(new BorderLayout());
                            panel.add(scrollPane, BorderLayout.NORTH);

                            JLabel mensagemLabel = new JLabel(
                                    "Em qual das ofertas você deseja se inscrever? Digite o número da oferta:");
                            panel.add(mensagemLabel, BorderLayout.CENTER);

                            JTextField inputField = new JTextField();
                            panel.add(inputField, BorderLayout.SOUTH);

                            int result = JOptionPane.showOptionDialog(
                                    null,
                                    panel,
                                    "Ofertas de emprego restante desponíveis para " + candidato.getNome(),
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    null);

                            if (result == JOptionPane.OK_OPTION) {
                                String input = inputField.getText();
                                if (algumCampoEmBranco(inputField)) {
                                    JOptionPane.showMessageDialog(null,
                                            "Digite o número da oferta antes de prosseguir.", "Aviso",
                                            JOptionPane.WARNING_MESSAGE);
                                } else {
                                    int numeroOfertaEscolhida = Integer.parseInt(input);
                                    if (numeroOfertaEscolhida <= 0
                                            || numeroOfertaEscolhida >= ofertasRestantes.size() + 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "Número de oferta inválido, digite novamente.", "Aviso",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        OfertaEmprego ofertaSelecionada = ofertasRestantes
                                                .get(numeroOfertaEscolhida - 1);
                                        if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Você já está inscrito(a) nesta oferta!");
                                        } else {
                                            camposPreenchidos = true;
                                            candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!");
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
            }
        }
    }

    public static void imprimirCandidatos() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) { // Verifica se existe candidatos cadastrados no sistema
            JOptionPane.showMessageDialog(null, "Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                for (Candidato candidato : candidatos) {
                    if (candidato.getCpf().equals(cpfDesejado)) {
                        JTextArea textArea = new JTextArea(20, 40);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        textArea.append(candidato.toString() + "\n\n");
                        textArea.setEditable(false);
                        Object[] options = { "OK", "Cancel" };
                        JOptionPane.showOptionDialog(
                                null,
                                scrollPane,
                                "Dados completos do seu cadastro",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                options,
                                options[0]);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
            }
        }
    }

    public static void imprimirCadastroTodosClientes() {
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            JTextArea textArea = new JTextArea(20, 40);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            for (Candidato candidato : candidatos) {
                textArea.append(candidato.toString() + "\n\n");
            }
            textArea.setEditable(false);
            Object[] options = { "OK", "Cancel" };
            JOptionPane.showOptionDialog(
                    null,
                    scrollPane,
                    "Banco de dados dos candidatos cadastrados e suas ofertas inscritas",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

        }
    }

    public static void imprimirOfertasEmpregoInscritas() {
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {
                    // Verifica se o candidato tem ofertas de emprego inscritas
                    if (candidato.getOfertasInscritas().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "O candidato não tem nenhuma oferta de emprego inscrita ainda.");
                    } else {
                        JTextArea textArea = new JTextArea(20, 40);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                        for (OfertaEmprego oferta : candidato.getOfertasInscritas()) {
                            textArea.append(oferta.toString() + "\n");
                        }
                        textArea.setEditable(false);
                        Object[] options = { "OK", "Cancel" };
                        JOptionPane.showOptionDialog(
                                null,
                                scrollPane,
                                "Ofertas de emprego inscritas para " + candidato.getNome() + ":",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                options,
                                options[0]);
                    }
                    break; // Se encontrou o candidato, não precisa continuar procurando
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
        }
    }

    public static void apagarOfertaEmpregoInscrita() {
        String cpfDesejado = CPF();
    
        for (Candidato candidato : candidatos) {
            if (candidato.getCpf().equals(cpfDesejado)) {
                if (candidato.getOfertasInscritas().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "O candidato não tem nenhuma oferta de emprego inscrita ainda.");
                } else {
                    DefaultListModel<String> listModel = new DefaultListModel<>();
    
                    for (OfertaEmprego oferta : candidato.getOfertasInscritas()) {
                        // Substitua \n por <br> para quebras de linha
                        String ofertaString = oferta.toString().replace("\n", "<br> &nbsp;");
                        listModel.addElement("<html>" + ofertaString + "</html>");
                    }
    
                    JList<String> listaOfertas = new JList<>(listModel);
                    listaOfertas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
                    JScrollPane scrollPane = new JScrollPane(listaOfertas);
    
                    JPanel panel = new JPanel(new BorderLayout());
                    // Defina as dimensões preferenciais do painel
                    Dimension preferredSize = new Dimension(400, 300);
                    panel.setPreferredSize(preferredSize);
    
                    JLabel mensagemLabel = new JLabel("Selecione a oferta que deseja retirar a inscrição:");
                    panel.add(mensagemLabel, BorderLayout.NORTH);
    
                    panel.add(scrollPane, BorderLayout.CENTER);
    
                    int result = JOptionPane.showOptionDialog(
                            null,
                            panel,
                            "Ofertas de emprego inscritas para " + candidato.getNome(),
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            null);
    
                    if (result == JOptionPane.OK_OPTION) {
                        // Lógica para processar a lista de seleção
                        int selectedIndex = listaOfertas.getSelectedIndex();
    
                        if (selectedIndex != -1) {
                            candidato.getOfertasInscritas().remove(selectedIndex);
                            JOptionPane.showMessageDialog(null, "Inscrição retirada com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Selecione uma oferta antes de prosseguir.",
                                    "Aviso", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                break;
            }
        }
    }
    

    public static void editarDados(String cpfDesejado) {
        for (Candidato candidato : candidatos) {
            if (candidato.getCpf().equals(cpfDesejado)) {
                do {
                    // Crie uma cópia do candidato antes de qualquer edição
                    Candidato candidatoOriginal = new Candidato(candidato);

                    JPanel panel = new JPanel(new GridLayout(10, 2, 20, 5));

                    JTextField nomeField = new JTextField(candidato.getNome());
                    JTextField emailField = new JTextField(candidato.getEmail());
                    JTextField dataNascimentoField = new JTextField(candidato.getDataNascimento());
                    JTextField enderecoField = new JTextField(candidato.getEndereco());
                    JTextField telefoneField = new JTextField(candidato.getTelefone());
                    JTextField areaAtuacaoField = new JTextField(candidato.getAreaAtuacao());
                    JTextField cpfField = new JTextField(candidato.getCpf());
                    JTextField nivelEscolaridadeField = new JTextField(candidato.getNivelEscolaridade());
                    JTextField instituicaoField = new JTextField(candidato.getInstituicao());

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
                            null);

                    if (result == JOptionPane.OK_OPTION) {
                        String cpf = cpfField.getText();
                        if (!cpf.equals(candidato.getCpf())) {
                            if (verificaCPF(cpf)) {
                                JOptionPane.showMessageDialog(null,
                                        "\nEsse CPF já existe no sistema. Digite outro CPF!\n");
                                // Continue to the next iteration of the loop (return to the edit screen)
                                continue;
                            } else {
                                candidato.setCpf(cpf);
                                JOptionPane.showMessageDialog(null, "CPF alterado com sucesso!");
                            }
                        }

                        // Atualize os dados do candidato com os valores dos campos de texto
                        candidato.setNome(nomeField.getText());
                        candidato.setEmail(emailField.getText());
                        candidato.setDataNascimento(dataNascimentoField.getText());
                        candidato.setEndereco(enderecoField.getText());
                        candidato.setTelefone(telefoneField.getText());
                        candidato.setAreaAtuacao(areaAtuacaoField.getText());

                        candidato.setNivelEscolaridade(nivelEscolaridadeField.getText());
                        candidato.setInstituicao(instituicaoField.getText());

                        // Verifique se houve alterações nos dados
                        if (dadosForamAlterados(candidato, candidatoOriginal)) {
                            JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum dado foi alterado.");
                            continue;
                        }
                    } else {
                        // Se o usuário cancelar a operação ou fechar a janela (volta ao menu anterior)
                        break;
                    }
                } while (true);
            }
        }
    }

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
                    null);

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
                    JOptionPane.showMessageDialog(null,
                            "\nEsse CPF já existe no sistema. Logo você já tem uma conta conosco!\n");
                    return null;
                }

                if (algumCampoEmBranco(nomeField, emailField, dataNascimentoField, enderecoField, telefoneField,
                        areaAtuacaoField, cpfField, nivelEscolaridadeField, instituicaoField) == false) {
                    camposPreenchidos = true;
                    // Crie e retorne um novo objeto Candidato
                    ArrayList<OfertaEmprego> ofertasInscritas = new ArrayList<>();

                    return new Candidato(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cpf,
                            nivelEscolaridade, instituicao, ofertasInscritas);

                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar.", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                }

            } else {
                // Retorna null se o usuário pressionar Cancelar ou fechar a janela
                return null;
            }
        }
        return null;
    }

    private static boolean algumCampoEmBranco(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                return true; // Pelo menos um campo está em branco
            }
        }
        return false; // Nenhum campo está em branco
    }

    public static String verificaCampoPreenchido(String campo) {
        if (campo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo antes de prosseguir.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            return campo;
        }
        return null;
    }

    private static boolean dadosForamAlterados(Candidato atual, Candidato original) {
        return !atual.getNome().trim().equals(original.getNome().trim())
                || !atual.getEmail().trim().equals(original.getEmail().trim())
                || !atual.getDataNascimento().trim().equals(original.getDataNascimento().trim())
                || !atual.getEndereco().trim().equals(original.getEndereco().trim())
                || !atual.getTelefone().trim().equals(original.getTelefone().trim())
                || !atual.getAreaAtuacao().trim().equals(original.getAreaAtuacao().trim())
                || !atual.getCpf().trim().equals(original.getCpf().trim())
                || !atual.getNivelEscolaridade().trim().equals(original.getNivelEscolaridade().trim())
                || !atual.getInstituicao().trim().equals(original.getInstituicao().trim());
    }

}