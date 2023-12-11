package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteView extends JFrame {
    
    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JTextField cpfTextField;
    // Adicione outros campos conforme necessário


    public ClienteView() {
        // Configurações da janela
        JFrame jfrm = new JFrame("Cadastro de Cliente");
        jfrm.setSize(400, 300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(new GridLayout(8, 2));

        // Adiciona os componentes à janela
        jfrm.add(new JLabel("Nome:"));
        nomeTextField = new JTextField();
        jfrm.add(nomeTextField);

        jfrm.add(new JLabel("Email:"));
        emailTextField = new JTextField();
        jfrm.add(emailTextField);

        jfrm.add(new JLabel("CPF:"));
        cpfTextField = new JTextField();
        jfrm.add(cpfTextField);

        // Adicione outros campos conforme necessário

        // Botão para cadastrar o cliente
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });
        jfrm.add(cadastrarButton);

        // Botão para chamar outras funções da classe CandidatoControler
        JButton outraFuncaoButton = new JButton("Outra Função");
        outraFuncaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame a função desejada da classe CandidatoControler aqui
                // Exemplo: CandidatoControler.outraFuncao();
            }
        });
        jfrm.add(outraFuncaoButton);

        // Exemplo de botão para fechar a aplicação
        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jfrm.add(fecharButton);
    }

    public void cadastrarCliente() {
        // Obtenha os dados da interface gráfica
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        String cpf = cpfTextField.getText();
        // Obtenha outros dados conforme necessário

        // Chame a função desejada da classe CandidatoControler
        // Exemplo: CandidatoControler.cadastrarCliente(nome, email, cpf, ...);
    }
}
