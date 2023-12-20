package main;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controler.CandidatoControler;
import controler.Dados;
import controler.EmpresaControler;
import controler.OfertaEmpregoControler;
import model.Candidato;

public class Main {

    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            int op1 = imprimirMenuPrincipal();
            switch (op1) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigada por utilizar o sistema. Até logo!");
                    System.exit(0);
                    break;
                case 1:
                    loop = menuCandidato();
                    break;
                case 2:
                    loop = menuEmpresa();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
    }

    public static int imprimirMenuPrincipal() {
        String frameTitle = "Menu Principal";
        JFrame frame = new JFrame(frameTitle);
        int op;
        String input = JOptionPane.showInputDialog(
                frame, "Escolha uma das opções a seguir:\n" +
                        "0 - Sair da aplicação\n" +
                        "1 - Candidato\n" +
                        "2 - Empresa",
                frameTitle,
                JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
        if (input == null) {
            return 0; // Saindo do sistema
        } // Verificando se o input é vazio
        if (input.trim().isEmpty()) {
            return -1; // Indicador de opção invalida
        }
        op = Integer.parseInt(input);
        frame.dispose(); // Fechando o frame
        return op;
    }

    public static boolean menuCandidato() {
        boolean loopCandidato = true;
        String cpfDesejado;
        while (loopCandidato) {

            int op2 = imprimirMenuCandidato();
            switch (op2) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigada por utilizar o sistema. Até logo!");
                    System.exit(0);
                case 1:
                    loopCandidato = false; // Sai do loop do candidato, mas continua no loop principal
                    break;
                case 2:
                    CandidatoControler.cadastrarCandidato();
                    break;
                case 3:
                    cpfDesejado = CandidatoControler.CPF();
                    CandidatoControler.imprimirCandidatos(cpfDesejado);
                    break;
                case 4:
                    cpfDesejado = CandidatoControler.CPF();
                    CandidatoControler.editarDados(cpfDesejado);
                    break;
                case 5:
                    cpfDesejado = CandidatoControler.CPF();
                    CandidatoControler.apagarCadastroDoSistema(cpfDesejado);
                    break;
                case 6:
                    loopCandidato = menuFiltroOfertasEmprego();
                    break;
                case 7:
                    loopCandidato = menuInscreverOfertaEmprego();
                    break;
                case 8:
                    cpfDesejado = CandidatoControler.CPF();
                    CandidatoControler.imprimirOfertasEmpregoInscritas(cpfDesejado);
                    break;
                case 9:
                    cpfDesejado = CandidatoControler.CPF();
                    CandidatoControler.apagarOfertaEmpregoInscrita(cpfDesejado);
                    break;
                case 10:
                    // JOptionPane.showMessageDialog(null, "Os dados foram impressos no terminal");
                    CandidatoControler.imprimirCadastroTodosClientes();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true; // Continua no loop principal
    }

    public static int imprimirMenuCandidato() {
        int op;
        String input = JOptionPane.showInputDialog(
                null, "Escolha uma das opções a seguir:\n" +
                        "0 - Sair da aplicação\n" +
                        "1 - Voltar para o menu principal\n" +
                        "2 - Se cadastrar (caso seja usuário novato)\n" +
                        "3 - Visualizar cadastro de cliente específico\n" +
                        "4 - Editar cadastro\n" +
                        "5 - Apagar o seu cadastro do sistema\n" +
                        "6 - Visualizar ofertas de empregos disponíveis\n" +
                        "7 - Se inscrever em uma oferta de emprego\n" +
                        "8 - Vizualizar ofertas de emprego que você está inscrito\n" +
                        "9 - Retirar a sua inscrição de uma oferta de emprego\n" +
                        "10 - Visualizar todos os candidatos cadastrados no sistema",
                "Ben vindo candidato",
                JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
        if (input == null) {
            // Volta ao menu principal
            return 1;
        }
        // Verificando se o input é vazio
        if (input.trim().isEmpty()) {
            // Indicador de opção invalida
            return -1;
        }
        op = Integer.parseInt(input);
        return op;
    }

    public static boolean menuEmpresa() {
        boolean loopEmpresa = true;
        String cnpjDesejado;
        while (loopEmpresa) {
            int op4 = imprimirMenuEmpresa();
            switch (op4) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigada por utilizar o sistema. Até logo!");
                    System.exit(0);
                case 1:
                    loopEmpresa = false; // Sai do loop da empresa, mas continua no loop principal
                    break;
                case 2:
                    EmpresaControler.cadastrarEmpresa();
                    break;
                case 3:
                    cnpjDesejado = EmpresaControler.CNPJ();
                    EmpresaControler.imprimirEmpresas(cnpjDesejado);
                    break;
                case 4:
                    cnpjDesejado = EmpresaControler.CNPJ();
                    EmpresaControler.editarDados(cnpjDesejado);
                    break;
                case 5:
                    cnpjDesejado = EmpresaControler.CNPJ();
                    EmpresaControler.apagarCadastroDoSistema(cnpjDesejado);
                    break;
                case 6:
                    cnpjDesejado = EmpresaControler.CNPJ();
                    OfertaEmpregoControler.cadastrarOfertaEmprego(cnpjDesejado);
                    break;
                case 7:
                    cnpjDesejado = EmpresaControler.CNPJ();
                    OfertaEmpregoControler.imprimirOfertasEmprego(cnpjDesejado);
                    break;
                case 8:
                    cnpjDesejado = EmpresaControler.CNPJ();
                    OfertaEmpregoControler.editarDados(cnpjDesejado);
                    break;
                case 9:
                    cnpjDesejado = EmpresaControler.CNPJ();
                    OfertaEmpregoControler.apagarOfertaEmprego(cnpjDesejado);
                    break;
                case 10:
                    EmpresaControler.imprimirTodasEmpresas();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true; // Continua no loop principal
    }

    public static int imprimirMenuEmpresa() {
        String frameTitle = "Bem vindo à área destinada às empresas";
        JFrame frame = new JFrame(frameTitle);
        int op;
        String input = JOptionPane.showInputDialog(
                frame, "Escolha uma das opções a seguir:\n" +
                        "0 - Sair da aplicação\n" +
                        "1 - Voltar para o menu principal\n" +
                        "2 - Se cadastrar (caso seja usuário novato)\n" +
                        "3 - Visualizar cadastro de uma empresa específica\n" +
                        "4 - Editar cadastro\n" +
                        "5 - Apagar o cadastro da empresa do sistema\n" +
                        "6 - Criar oferta de emprego\n" +
                        "7 - Visualizar ofertas de emprego da sua empresa que estão abertas\n" +
                        "8 - Editar uma oferta de emprego\n" +
                        "9 - Apagar uma oferta de emprego\n" +
                        "10 - Visualizar todas as empresas cadastradas no sistema",
                frameTitle,
                JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
        if (input == null) {
            // Volta para o menu principal
            return 1;
        } // Verificando se o input é vazio
        if (input.trim().isEmpty()) {
            // Indicador de opção invalida
            return -1;
        }
        op = Integer.parseInt(input);
        frame.dispose(); // Fechando o frame
        return op;
    }

    public static boolean menuFiltroOfertasEmprego() {
        boolean filtrarOfertasEmprego = true;

        while (filtrarOfertasEmprego) {
            int op6 = imprimirMenuFiltroOfertasEmprego();
            switch (op6) {
                case 0:
                    filtrarOfertasEmprego = false;
                    break;
                case 1:
                    CandidatoControler.filtrarOfertasEmpregoTecnologia();
                    break;
                case 2:
                    CandidatoControler.filtrarOfertasEmpregoVendas();
                    break;
                case 3:
                    CandidatoControler.filtrarOfertasEmpregoHospitalar();
                    break;
                case 4:
                    CandidatoControler.filtrarOfertasEmpregoEducacao();
                    break;
                case 5:
                    CandidatoControler.filtrarOfertasEmpregoAlimentos();
                    break;
                case 6:
                    CandidatoControler.filtrarOfertasEmpregoRestantes();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true;
    }

    public static int imprimirMenuFiltroOfertasEmprego() {
        String frameTitle = "Menu filtrar oferta de emprego";
        JFrame frame = new JFrame(frameTitle);
        int op;
        String input = JOptionPane.showInputDialog(
                frame,
                "Escolha um dos filtro desejados para visualizar as \nofertas de emprego por área de atuação das empresas:\n"
                        +
                        "\n1 - Tecnologia\n" +
                        "2 - Vendas\n" +
                        "3 - Hospitalar\n" +
                        "4 - Educação\n" +
                        "5 - Alimentos\n" +
                        "6 - Área não especificada acima\n" +
                        "Digite 0 para voltar ao menu anterior",
                frameTitle,
                JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
        if (input == null) {
            return 0; // volta para o meni anterior
        } // Verificando se o input é vazio
        if (input.trim().isEmpty()) {
            return -1; // Indicador de opção invalida
        }
        op = Integer.parseInt(input);
        frame.dispose(); // Fechando o frame
        return op;
    }

    public static boolean menuInscreverOfertaEmprego() {
        String cpfDesejado = CandidatoControler.CPF();
        boolean filtrarOfertasEmprego = true;
        while (filtrarOfertasEmprego) {
            int op6 = imprimirMenuInscreverOfertasEmprego();
            switch (op6) {
                case 0:
                    filtrarOfertasEmprego = false;
                    break;
                case 1:
                    CandidatoControler.seInscreverOfertaEmpregoAreaTecnologia(cpfDesejado);
                    break;
                case 2:
                    CandidatoControler.seInscreverOfertaEmpregoAreaVendas(cpfDesejado);
                    break;
                case 3:
                    CandidatoControler.seInscreverOfertaEmpregoAreaHospitalar(cpfDesejado);
                    break;
                case 4:
                    CandidatoControler.seInscreverOfertaEmpregoAreaEducacao(cpfDesejado);
                    break;
                case 5:
                    CandidatoControler.seInscreverOfertaEmpregoAreaAlimentos(cpfDesejado);
                    break;
                case 6:
                    CandidatoControler.seInscreverOfertaEmpregoAreasRestantes(cpfDesejado);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true;
    }

    public static int imprimirMenuInscreverOfertasEmprego() {
        String frameTitle = "Se inscrever em uma vaga de emprego";
        JFrame frame = new JFrame(frameTitle);
        int op;
        String input = JOptionPane.showInputDialog(
                frame, "Para se inscrever:" +
                        "\nEscolha um dos filtro desejados para visualizar as\nofertas de emprego por área de atuação das empresas:\n"
                        +
                        "\n1 - Tecnologia\n" +
                        "2 - Vendas\n" +
                        "3 - Hospitalar\n" +
                        "4 - Educação\n" +
                        "5 - Alimentos\n" +
                        "6 - Área não especificada acima\n" +
                        "Digite 0 para voltar ao menu anterior",
                frameTitle,
                JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
        if (input == null) {
            return 0; // volta para o meni anterior
        } // Verificando se o input é vazio
        if (input.trim().isEmpty()) {
            return -1; // Indicador de opção invalida
        }
        op = Integer.parseInt(input);
        frame.dispose(); // Fechando o frame
        return op;
    }
}