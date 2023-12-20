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
                if (verificaCNPJ(cnpjDesejado)) {
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

    public static void editarNomeEmpresa() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    String novoNome = JOptionPane.showInputDialog(null,
                            "Antigo nome cadastrado no cadastro da empresa: " + empresa.getNome()
                                    + " \nDigite o novo nome:");
                    empresa.setNome(novoNome);
                    JOptionPane.showMessageDialog(null, "Nome editado com sucesso!");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }
    }

    public static void editarEmailEmpresa() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    String novoEmail = JOptionPane.showInputDialog(null,
                            "Antigo email cadastrado no cadastro da empresa: " + empresa.getEmail()
                                    + " \nDigite o novo email: ");
                    empresa.setEmail(novoEmail);
                    JOptionPane.showMessageDialog(null, "Email editado com sucesso!");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }
    }

    public static void editarDataCriacaoEmpresa() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    String novaDataCriacao = JOptionPane.showInputDialog(null,
                            "Antiga data de criação cadastrada no cadastro da empresa: " + empresa.getDataNascimento()
                                    + " \nDigite a nova data de criação da empresa:");
                    empresa.setDataNascimento(novaDataCriacao);
                    JOptionPane.showMessageDialog(null, "Data de criação editada com sucesso!");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }
    }

    public static void editarEnderecoEmpresa() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    String novoEndereco = JOptionPane.showInputDialog(null,
                            "Antigo endereço cadastrado no cadastro da empresa: " + empresa.getEndereco()
                                    + " \nDigite o novo endereço: ");
                    empresa.setEndereco(novoEndereco);
                    JOptionPane.showMessageDialog(null, "Endereço editado com sucesso!");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }
    }

    public static void editarTelefoneEmpresa() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    String novoTelefone = JOptionPane.showInputDialog(null,
                            "Antigo telefone cadastrado no cadastro da empresa: " + empresa.getTelefone()
                                    + " \nDigite o novo telefone:");
                    empresa.setTelefone(novoTelefone);
                    JOptionPane.showMessageDialog(null, "Telefone editado com sucesso!");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }
    }

    public static void editarAreaAtuacaoEmpresa() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    String novaAreaAtuacao = JOptionPane.showInputDialog(null,
                            "Antiga área de atuação cadastrada no cadastro da empresa: " + empresa.getAreaAtuacao()
                                    + " \nDigite a nova área de atuação:");
                    empresa.setAreaAtuacao(novaAreaAtuacao);
                    JOptionPane.showMessageDialog(null, "Área de atuação editada com sucesso!");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }
    }

    public static void editarCNPJEmpresa() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    String novoCNPJ = JOptionPane.showInputDialog(null,
                            "Antigo CNPJ cadastrado no cadastro da empresa: " + empresa.getCnpj()
                                    + " \nDigite o novo CNPJ:");
                    empresa.setCnpj(novoCNPJ);
                    JOptionPane.showMessageDialog(null, "CNPJ editado com sucesso!");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "\nNenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
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

                if (algumCampoEmBranco(nomeField, emailField, dataNascimentoField, enderecoField, telefoneField,
                        areaAtuacaoField, cnpjField) == false) {
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
}