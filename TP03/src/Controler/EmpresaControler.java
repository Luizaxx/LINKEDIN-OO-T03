package controler;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Candidato;
import model.Empresa;
import model.OfertaEmprego;

public class EmpresaControler {

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();

    public static String CNPJ() {
        boolean camposPreenchidos = false;
        while (!camposPreenchidos) {
            String cnpjDesejado = JOptionPane.showInputDialog(null, "Qual é o CNPJ da empresa? ",
                    "Informe o CNPJ da empresa", JOptionPane.PLAIN_MESSAGE);
            if (cnpjDesejado == null) {
                break;
            }
            if (cnpjDesejado.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite o CNPJ da empresa antes de prosseguir.", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                if (!verificaCNPJ(cnpjDesejado)) {
                    JOptionPane.showMessageDialog(null,
                            "Esse CNPJ não existe na nossa base de dados\ndigite um CNPJ valido!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    camposPreenchidos = true;
                    return cnpjDesejado;
                }
            }
        }
        return null;
    }

    public static boolean verificaCNPJ(String cnpjDesejado) {
        boolean encontrado = false;
        if (cnpjDesejado != null) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    encontrado = true;
                    break;
                }
            }
        }
        return encontrado;
    }

    public static void cadastrarEmpresa() {
        Empresa novaEmpresa = lerDadosEmpresa();
        if (novaEmpresa != null) {
            Dados.getEmpresas().add(novaEmpresa);
            JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso!", "Sucesso",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void imprimirEmpresas(String cnpjDesejado) {
        if (empresas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma empresa foi cadastrada no sistema ainda.");
        } else {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    JTextArea textArea = new JTextArea(20, 40);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    textArea.append(empresa.toString() + "\n\n");
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
                    break;
                }
            }
        }
    }

    public static void imprimirTodasEmpresas() {
        if (empresas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma empresa foi cadastrada no sistema ainda.");
        } else {
            JTextArea textArea = new JTextArea(35, 40);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            for (Empresa empresa : empresas) {
                textArea.append(empresa.toString() + "\n\n");
            }
            textArea.setEditable(false);
            Object[] options = { "OK", "Cancel" };
            JOptionPane.showOptionDialog(
                    null,
                    scrollPane,
                    "Banco de dados das empresas cadastradas",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);
        }
    }

    public static void editarDados(String cnpjDesejado) {
        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equals(cnpjDesejado)) {
                do {
                    Empresa empresaOriginal = new Empresa(empresa);

                    JPanel panel = new JPanel(new GridLayout(10, 2, 20, 5));
                    JTextField nomeField = new JTextField(empresa.getNome());
                    JTextField emailField = new JTextField(empresa.getEmail());
                    JTextField dataNascimentoField = new JTextField(empresa.getDataNascimento());
                    JTextField enderecoField = new JTextField(empresa.getEndereco());
                    JTextField telefoneField = new JTextField(empresa.getTelefone());
                    JTextField areaAtuacaoField = new JTextField(empresa.getAreaAtuacao());
                    JTextField cnpjField = new JTextField(empresa.getCnpj());

                    panel.add(new JLabel("Nome:"));
                    panel.add(nomeField);
                    panel.add(new JLabel("Email:"));
                    panel.add(emailField);
                    panel.add(new JLabel("Data de criação:"));
                    panel.add(dataNascimentoField);
                    panel.add(new JLabel("Endereço:"));
                    panel.add(enderecoField);
                    panel.add(new JLabel("Telefone:"));
                    panel.add(telefoneField);
                    panel.add(new JLabel("Área de Atuação:"));
                    panel.add(areaAtuacaoField);
                    panel.add(new JLabel("CNPJ:"));
                    panel.add(cnpjField);

                    // Defina as dimensões preferenciais do painel
                    Dimension preferredSize = new Dimension(400, 300);
                    panel.setPreferredSize(preferredSize);

                    int result = JOptionPane.showOptionDialog(
                            null,
                            panel,
                            "Atualize os seus dados:",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            null);

                    if (result == JOptionPane.OK_OPTION) {
                        if (!algumCampoEmBranco(nomeField, emailField, dataNascimentoField, enderecoField,
                                telefoneField, areaAtuacaoField, cnpjField)) {

                            String cnpj = cnpjField.getText();
                            if (!cnpj.equals(empresa.getCnpj())) {
                                if (verificaCNPJ(cnpj)) {
                                    JOptionPane.showMessageDialog(null,
                                            "\nEsse CNPJ já existe no sistema. Digite outro CNPJ!\n");
                                } else {
                                    empresa.setCnpj(cnpj);
                                    JOptionPane.showMessageDialog(null, "CNPJ alterado com sucesso!");
                                }
                            }

                            empresa.setNome(nomeField.getText());
                            empresa.setEmail(emailField.getText());
                            empresa.setDataNascimento(dataNascimentoField.getText());
                            empresa.setEndereco(enderecoField.getText());
                            empresa.setTelefone(telefoneField.getText());
                            empresa.setAreaAtuacao(areaAtuacaoField.getText());

                            if (dadosForamAlterados(empresa, empresaOriginal)) {
                                JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Nenhum dado foi alterado.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Não é permitido deixar nenhum campo em branco!\n" + //
                                            "Todos os campos precisam estar preenchidos.",
                                    "Aviso",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        break;
                    }
                } while (true);
            }
        }
    }

    public static void apagarCadastroDoSistema(String cnpjDesejado) {
        Iterator<Empresa> iterator = empresas.iterator();
        while (iterator.hasNext()) {
            Empresa empresa = iterator.next();
            if (empresa != null && empresa.getCnpj().equals(cnpjDesejado)) {
                // Remova a oferta da empresa excluída dos candidatos
                CandidatoControler.removerOfertaEmpregoCandidatos(cnpjDesejado);

                iterator.remove(); // Remove a empresa usando o iterador
                JOptionPane.showMessageDialog(null, "Empresa removida com sucesso!");
                break; // Se encontrou a empresa, não precisa continuar procurando
            }
        }
    }

    public static Empresa lerDadosEmpresa() {
        boolean camposPreenchidos = false;
        while (!camposPreenchidos) {
            JPanel panel = new JPanel(new GridLayout(10, 2, 20, 5));

            JTextField nomeField = new JTextField();
            JTextField emailField = new JTextField();
            JTextField dataNascimentoField = new JTextField();
            JTextField enderecoField = new JTextField();
            JTextField telefoneField = new JTextField();
            JTextField areaAtuacaoField = new JTextField();
            JTextField cnpjField = new JTextField();

            panel.add(new JLabel("Nome:"));
            panel.add(nomeField);
            panel.add(new JLabel("Email:"));
            panel.add(emailField);
            panel.add(new JLabel("Data de criação da empresa:"));
            panel.add(dataNascimentoField);
            panel.add(new JLabel("Endereço:"));
            panel.add(enderecoField);
            panel.add(new JLabel("Telefone:"));
            panel.add(telefoneField);
            panel.add(new JLabel("Área de Atuação:"));
            panel.add(areaAtuacaoField);
            panel.add(new JLabel("CNPJ:"));
            panel.add(cnpjField);

            // Defina as dimensões preferenciais do painel
            Dimension preferredSize = new Dimension(400, 300);
            panel.setPreferredSize(preferredSize);

            int result = JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "Digite os dados da empresa:",
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
                String cnpj = cnpjField.getText();

                if (verificaCNPJ(cnpj)) {
                    JOptionPane.showMessageDialog(null,
                            "\nEsse CNPJ já existe no sistema. Logo essa empresa já tem uma conta conosco!\n");
                    return null;
                }

                if (!algumCampoEmBranco(nomeField, emailField, dataNascimentoField, enderecoField, telefoneField,
                        areaAtuacaoField, cnpjField)) {
                    camposPreenchidos = true;
                    ArrayList<OfertaEmprego> ofertasOfertadas = new ArrayList<OfertaEmprego>();

                    return new Empresa(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cnpj,
                            ofertasOfertadas);
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Aviso",
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

    private static boolean dadosForamAlterados(Empresa atual, Empresa original) {
        return !atual.getNome().trim().equals(original.getNome().trim())
                || !atual.getEmail().trim().equals(original.getEmail().trim())
                || !atual.getDataNascimento().trim().equals(original.getDataNascimento().trim())
                || !atual.getEndereco().trim().equals(original.getEndereco().trim())
                || !atual.getTelefone().trim().equals(original.getTelefone().trim())
                || !atual.getAreaAtuacao().trim().equals(original.getAreaAtuacao().trim())
                || !atual.getCnpj().trim().equals(original.getCnpj().trim());
    }

}