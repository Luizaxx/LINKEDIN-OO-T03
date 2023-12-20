package controler;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import model.Candidato;
import model.Empresa;
import model.OfertaEmprego;

public class OfertaEmpregoControler {

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();

    public static void cadastrarOfertaEmprego(String cnpjDesejado) {
        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equals(cnpjDesejado)) {
                OfertaEmprego novaOfertaEmprego = lerDadosOfertaEmprego(empresa);
                empresa.getOfertasOfertadas().add(novaOfertaEmprego);// Adicionando uma nova oferta de emprego no
                                                                     // arrayList de ofertasOfertadas da empresa
                if (empresa.getAreaAtuacao().equals("Tecnologia"))
                    Dados.getOfertasTecnologia().add(novaOfertaEmprego);
                if (empresa.getAreaAtuacao().equals("Vendas"))
                    Dados.getOfertasVendas().add(novaOfertaEmprego);
                if (empresa.getAreaAtuacao().equals("Hospitalar"))
                    Dados.getOfertasHospitalar().add(novaOfertaEmprego);
                if (empresa.getAreaAtuacao().equals("Educação"))
                    Dados.getOfertasEducacao().add(novaOfertaEmprego);
                if (empresa.getAreaAtuacao().equals("Alimentos"))
                    Dados.getOfertasAlimentos().add(novaOfertaEmprego);
                if (!(empresa.getAreaAtuacao().equals("Tecnologia")) && !(empresa.getAreaAtuacao().equals("Vendas"))
                        && !(empresa.getAreaAtuacao().equals("Hospitalar"))
                        && !(empresa.getAreaAtuacao().equals("Educação"))
                        && !(empresa.getAreaAtuacao().equals("Alimentos"))) {
                    Dados.getOfertasRestantes().add(novaOfertaEmprego);
                }
                JOptionPane.showMessageDialog(null, "Oferta criada com sucesso!");
                break; // Se encontrou, não precisa continuar procurando
            }
        }
    }

    public static void editarDados(String cnpjDesejado) {
        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equals(cnpjDesejado)) {
                if (empresa.getOfertasOfertadas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "A empresa não tem nenhuma oferta de emprego ainda.");
                } else {
                    do {
                        DefaultListModel<String> listModel = new DefaultListModel<>();

                        for (OfertaEmprego oferta : empresa.getOfertasOfertadas()) {
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

                        JLabel mensagemLabel = new JLabel("Selecione a oferta de emprego que você deseja editar:");
                        panel.add(mensagemLabel, BorderLayout.NORTH);

                        panel.add(scrollPane, BorderLayout.CENTER);

                        int result = JOptionPane.showOptionDialog(
                                null,
                                panel,
                                "Ofertas de emprego inscritas para " + empresa.getNome(),
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                null,
                                null);

                        if (result == JOptionPane.OK_OPTION) {
                            int selectedIndex = listaOfertas.getSelectedIndex();
                            if (selectedIndex != -1) {
                                do {
                                    OfertaEmprego ofertaSelecionada = empresa.getOfertasOfertadas().get(selectedIndex);
                                    OfertaEmprego ofertaOriginal = new OfertaEmprego(ofertaSelecionada);

                                    JPanel panelEditar = new JPanel(new GridLayout(5, 2, 20, 5));

                                    JTextField salarioField = new JTextField("" + ofertaSelecionada.getSalario());
                                    JTextField cargoField = new JTextField(ofertaSelecionada.getCargo());
                                    JTextField qntVagasField = new JTextField("" + ofertaSelecionada.getQntVagas());
                                    JTextField escolaridadeField = new JTextField(ofertaSelecionada.getEscolaridade());

                                    panelEditar.add(new JLabel("Salário:"));
                                    panelEditar.add(salarioField);
                                    panelEditar.add(new JLabel("Cargo:"));
                                    panelEditar.add(cargoField);
                                    panelEditar.add(new JLabel("Quantidade de Vagas:"));
                                    panelEditar.add(qntVagasField);
                                    panelEditar.add(new JLabel("Escolaridade Mínima:"));
                                    panelEditar.add(escolaridadeField);

                                    // Defina as dimensões preferenciais do painel
                                    Dimension SecondPreferredSize = new Dimension(400, 300);
                                    panelEditar.setPreferredSize(SecondPreferredSize);

                                    int SecondResult = JOptionPane.showOptionDialog(
                                            null,
                                            panelEditar,
                                            "Atualize o dados da oferta de emprego escolhida:",
                                            JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            null,
                                            null);
                                    if (SecondResult == JOptionPane.OK_OPTION) {
                                        if (!algumCampoEmBranco(salarioField, cargoField, qntVagasField,
                                                escolaridadeField)) {
                                            double salario = Double.parseDouble(salarioField.getText());
                                            ofertaSelecionada.setSalario(salario);
                                            ofertaSelecionada.setCargo(cargoField.getText());
                                            int vagas = Integer.parseInt(qntVagasField.getText());
                                            ofertaSelecionada.setQntVagas(vagas);
                                            ofertaSelecionada.setEscolaridade(escolaridadeField.getText());
                                            if (dadosForamAlterados(ofertaSelecionada, ofertaOriginal)) {
                                                JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Nenhum dado foi alterado.");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "Não é permitido deixar nenhum campo em branco!\nTodos os campos precisam estar preenchidos.",
                                                    "Aviso",
                                                    JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        break;
                                    }
                                } while (true);

                            } else {
                                JOptionPane.showMessageDialog(null, "Selecione uma oferta antes de prosseguir.",
                                        "Aviso", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            // Se o usuário cancelar a operação ou fechar a janela (volta ao menu anterior)
                            break;
                        }
                    } while (true);
                }
            }
        }
    }

    public static void apagarOfertaEmprego(String cnpjDesejado) {
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

                    JLabel mensagemLabel = new JLabel("Qual oferta da empresa " + empresa.getNome()
                            + " você deseja apagar? (Digite o número da oferta)");
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
                                null);

                        if (result == JOptionPane.OK_OPTION) {
                            // Lógica para processar o campo de entrada
                            String input = inputField.getText();
                            if (algumCampoEmBranco(inputField)) {
                                JOptionPane.showMessageDialog(null, "Digite o número da oferta antes de prosseguir.",
                                        "Aviso", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int numeroOfertaEscolhida = Integer.parseInt(input);
                                if (numeroOfertaEscolhida >= 1
                                        && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                                    // Removendo a oferta de emprego da empresa
                                    OfertaEmprego ofertaRemovida = empresa.getOfertasOfertadas()
                                            .remove(numeroOfertaEscolhida - 1);
                                    // Removendo as ofertas do ArrayLists que ela está
                                    if (empresa.getAreaAtuacao().equals("Tecnologia"))
                                        Dados.getOfertasTecnologia().remove(ofertaRemovida);
                                    if (empresa.getAreaAtuacao().equals("Vendas"))
                                        Dados.getOfertasVendas().remove(ofertaRemovida);
                                    if (empresa.getAreaAtuacao().equals("Hospitalar"))
                                        Dados.getOfertasHospitalar().remove(ofertaRemovida);
                                    if (empresa.getAreaAtuacao().equals("Educação"))
                                        Dados.getOfertasEducacao().remove(ofertaRemovida);
                                    if (empresa.getAreaAtuacao().equals("Alimentos"))
                                        Dados.getOfertasAlimentos().remove(ofertaRemovida);
                                    if (!(empresa.getAreaAtuacao().equals("Tecnologia"))
                                            && !(empresa.getAreaAtuacao().equals("Vendas"))
                                            && !(empresa.getAreaAtuacao().equals("Hospitalar"))
                                            && !(empresa.getAreaAtuacao().equals("Educação"))
                                            && !(empresa.getAreaAtuacao().equals("Alimentos"))) {
                                        Dados.getOfertasRestantes().remove(ofertaRemovida);
                                    }

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

    public static void imprimirOfertasEmprego(String cnpjDesejado) {
        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equals(cnpjDesejado)) {
                // Verifica se a empresa tem ofertas de emprego
                if (empresa.getOfertasOfertadas().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "A empresa não tem nenhuma oferta de emprego cadastrada ainda!");
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
                    Object[] options = { "OK", "Cancel" };
                    JOptionPane.showOptionDialog(
                            null,
                            scrollPane,
                            "Ofertas de emprego para a empresa " + empresa.getNome() + ":",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            options,
                            options[0]);
                }
                break; // Se encontrou a empresa, não precisa continuar procurando
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
                    null);

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
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos.", "Aviso",
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

    private static boolean dadosForamAlterados(OfertaEmprego atual, OfertaEmprego original) {
        return !(atual.getSalario() == original.getSalario())
                || !(atual.getCargo().trim().equals(original.getCargo().trim()))
                || !(atual.getQntVagas() == original.getQntVagas())
                || !(atual.getEscolaridade().trim().equals(original.getEscolaridade().trim()));
    }
}